package com.campusdual.appmazing.model.dao;

import com.campusdual.appmazing.model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsDao extends JpaRepository<Contacts, Integer> {
}
