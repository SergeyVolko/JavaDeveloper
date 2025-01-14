package product.star.contacts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.star.contacts.models.Contact;
import product.star.contacts.repository.ContactDao;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactDao contactDao;

    @Autowired
    public ContactServiceImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public Contact add(Contact contact) {
        return contactDao.add(contact);
    }

    @Override
    public Optional<Contact> getContactById(long id) {
        return contactDao.getContactById(id);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactDao.gatAllContacts();
    }

    @Override
    public Optional<Contact> updateContact(long id, Contact contact) {
        if (contactDao.getContactById(id).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(contactDao.update(id, contact));
    }
}
