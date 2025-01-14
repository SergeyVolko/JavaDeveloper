package product.star.contacts.services;

import product.star.contacts.models.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact add(Contact contact);
    Optional<Contact> getContactById(long id);
    List<Contact> getAllContacts();
    Optional<Contact> updateContact(long id, Contact contact);
}
