package product.star.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product.star.contacts.dto.ContactDto;
import product.star.contacts.facade.ContactFacade;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactFacade contactFacade;

    @Autowired
    public ContactController(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }

    @PostMapping
    public ResponseEntity<ContactDto> add(@RequestBody ContactDto contactDto) {
        return new ResponseEntity<>(contactFacade.add(contactDto), HttpStatus.OK);
    }

    @GetMapping("/contact/{contactId}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable long contactId) {
        return contactFacade.getContactById(contactId)
                .map(contactDto -> new ResponseEntity<>(contactDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        return new ResponseEntity<>(contactFacade.getAllContacts(), HttpStatus.OK);
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<ContactDto> updateContact(@PathVariable long contactId, @RequestBody ContactDto contactDto) {
        return contactFacade.updateContact(contactId, contactDto)
                .map(contact -> new ResponseEntity<>(contact, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
