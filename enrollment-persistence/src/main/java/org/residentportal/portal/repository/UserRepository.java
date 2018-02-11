package org.residentportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.residentportal.portal.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	User findByName(String name);
	User findByEmail(String email);

}
