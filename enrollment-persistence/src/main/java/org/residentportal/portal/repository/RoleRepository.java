package org.residentportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.residentportal.portal.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

	Role findByName(String string);

}
