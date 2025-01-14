package product.star.contacts.facade;

import org.springframework.stereotype.Service;
import product.star.contacts.dto.ContactDto;
import product.star.contacts.models.Contact;
import product.star.contacts.services.ContactService;

import java.util.List;
import java.util.Optional;

@Service
public class ContactFacadeImpl implements ContactFacade {
    private final ContactService contactService;

    public ContactFacadeImpl(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    public ContactDto add(ContactDto contactDto) {
        Contact contact = contactService.add(new Contact(contactDto));
        return new ContactDto(contact);
    }

    @Override
    public Optional<ContactDto> getContactById(long id) {
        Optional<Contact> optionalContact = contactService.getContactById(id);
        return optionalContact.map(ContactDto::new);
    }

    @Override
    public List<ContactDto> getAllContacts() {
        return contactService.getAllContacts().stream()
                .map(ContactDto::new)
                .toList();
    }

    @Override
    public Optional<ContactDto> updateContact(long id, ContactDto contactDto) {
        Optional<Contact> optionalContact = contactService.updateContact(id, new Contact(contactDto));
        return optionalContact.map(ContactDto::new);
    }
}
