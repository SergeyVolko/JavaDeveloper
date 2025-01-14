package product.star.contacts.repository;

import org.springframework.stereotype.Repository;
import product.star.contacts.models.Contact;

import java.util.*;

@Repository
public class ContactsRepository implements ContactDao {
    private long id = 1L;
    private Map<Long, Contact> contacts = new HashMap<>();

    @Override
    public List<Contact> gatAllContacts() {
        return contacts.values()
                .stream()
                .toList();
    }

    @Override
    public Optional<Contact> getContactById(long id) {
        return Optional.ofNullable(contacts.get(id));
    }

    @Override
    public Contact add(Contact contact) {
        contact.setId(id);
        contacts.put(id++, contact);
        return contact;
    }

    @Override
    public Contact update(long id, Contact contact) {
        contact.setId(id);
        contacts.put(id, contact);
        return contact;
    }
}
