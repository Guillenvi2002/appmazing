package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IContactsService;
import com.campusdual.appmazing.model.Contacts;
import com.campusdual.appmazing.model.dao.ContactsDao;
import com.campusdual.appmazing.model.dto.ContactsDTO;
import com.campusdual.appmazing.model.dto.dtomapper.ContactsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ContactsService")
@Lazy
public class ContactsService implements IContactsService {

    @Autowired
    private ContactsDao contactsDao;

    @Override
    public ContactsDTO queryContact(ContactsDTO contactsDTO) {
        Contacts contacts = ContactsMapper.INSTANCE.toEntity(contactsDTO);
        return ContactsMapper.INSTANCE.toDTO(contactsDao.getReferenceById(contacts.getId()));
    }

    @Override
    public List<ContactsDTO> queryAllContacts() {
        return ContactsMapper.INSTANCE.toDTOList(contactsDao.findAll());
    }

    @Override
    public int insertContact(ContactsDTO contactsDTO) {
        Contacts contacts = ContactsMapper.INSTANCE.toEntity(contactsDTO);
        contactsDao.saveAndFlush(contacts);
        return contacts.getId();
    }

    @Override
    public int updateContact(ContactsDTO contactsDTO) {
        return insertContact(contactsDTO);
    }

    @Override
    public int deleteContact(ContactsDTO contactsDTO) {
        int id = contactsDTO.getId();
        Contacts contacts = ContactsMapper.INSTANCE.toEntity(contactsDTO);
        contactsDao.delete(contacts);
        return id;
    }
}
