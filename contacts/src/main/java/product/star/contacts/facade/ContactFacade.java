package product.star.contacts.facade;

import product.star.contacts.dto.ContactDto;

import java.util.List;
import java.util.Optional;

public interface ContactFacade {
    ContactDto add(ContactDto contactDto);
    Optional<ContactDto> getContactById(long id);
    List<ContactDto> getAllContacts();
    Optional<ContactDto> updateContact(long id, ContactDto contactDto);
}
