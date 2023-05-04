package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IContactsService;
import com.campusdual.appmazing.model.dto.ContactsDTO;
import com.campusdual.appmazing.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/contactos")
public class ContactosController {

    @Autowired
    private IContactsService contactsService;
    @GetMapping
    public String testController(){
        return "Contacts controller works!";
    }

    @PostMapping
    public String testController(@RequestBody String name){
        return "Contacts controller works, " +name + "!";
    }

    @PostMapping(value = "/get")
    public ContactsDTO queryContacts(@RequestBody ContactsDTO contactsDTO){
        return contactsService.queryContact(contactsDTO);
    }

    @GetMapping(value = "/getAll")
    public List<ContactsDTO> queryAllContacts(){
        return contactsService.queryAllContacts();
    }

    @PostMapping(value = "/add")
    public int addContact(@RequestBody ContactsDTO contactsDTO){
        return contactsService.insertContact(contactsDTO);
    }

    @PostMapping(value = "/addAndShow")
    public ContactsDTO addContactAndShow(@RequestBody ContactsDTO contactsDTO){
        int idContact = contactsService.insertContact(contactsDTO);
        ContactsDTO newContact = new ContactsDTO();
        newContact.setId(idContact);
        return contactsService.queryContact(newContact);
    }

    @PutMapping(value = "/update")
    public int updateContact(@RequestBody ContactsDTO contactsDTO){
        return contactsService.updateContact(contactsDTO);
    }

    @DeleteMapping(value = "/delete")
    public int deleteContact(@RequestBody ContactsDTO contactsDTO){
        return contactsService.deleteContact(contactsDTO);
    }

}
