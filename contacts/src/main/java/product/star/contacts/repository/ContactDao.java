package product.star.contacts.repository;

import product.star.contacts.models.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactDao {
    List<Contact> gatAllContacts();
    Optional<Contact> getContactById(long id);
    Contact add(Contact contact);
    Contact update(long id, Contact contact);
}
