package org.residentportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.residentportal.portal.entity.Article;
import org.residentportal.portal.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer>{

}
