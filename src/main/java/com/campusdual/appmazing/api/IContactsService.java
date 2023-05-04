package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ContactsDTO;

import java.util.List;

public interface IContactsService {
    ContactsDTO queryContact(ContactsDTO contactsDTO);
    List<ContactsDTO> queryAllContacts();
    int insertContact(ContactsDTO contactsDTO);
    int updateContact(ContactsDTO contactsDTO);

    int secureUpdateContact(ContactsDTO contactsDTO);

    int deleteContact(ContactsDTO contactsDTO);
}
