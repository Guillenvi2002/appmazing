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
    public int secureUpdateContact(ContactsDTO contactsDTO){
        ContactsDTO contact = ContactsMapper.INSTANCE.toDTO(contactsDao.getReferenceById(contactsDTO.getId()));
        if(contact != null){
            if(contactsDTO.getNombre() != null){
                contact.setNombre(contactsDTO.getNombre());
            }
            if(contactsDTO.getApellido1() != null){
                contact.setApellido1(contactsDTO.getApellido1());
            }
            if(contactsDTO.getApellido2() != null){
                contact.setApellido2(contactsDTO.getApellido2());
            }
            if(contactsDTO.getCorreo() != null){
                contact.setCorreo(contactsDTO.getCorreo());
            }
            if(contactsDTO.getTelefono() != null){
                contact.setTelefono(contactsDTO.getTelefono());
            }
            return  updateContact(contact);
        } else {
            return  0;
        }

    }
    @Override
    public int deleteContact(ContactsDTO contactsDTO) {
        int id = contactsDTO.getId();
        Contacts contacts = ContactsMapper.INSTANCE.toEntity(contactsDTO);
        contactsDao.delete(contacts);
        return id;
    }
}
