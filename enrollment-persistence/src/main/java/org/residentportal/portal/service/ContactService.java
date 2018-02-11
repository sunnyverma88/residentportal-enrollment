package org.residentportal.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.residentportal.portal.entity.Contact;
import org.residentportal.portal.repository.ContactRepository;

@Service
@Transactional
public class ContactService {
	@Autowired
	ContactRepository contactRepository;
	public void save(Contact contact) {
		// TODO Auto-generated method stub
		contactRepository.save(contact);
		
	}

	
	
}
