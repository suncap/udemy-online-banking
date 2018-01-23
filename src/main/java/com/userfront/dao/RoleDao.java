package com.userfront.dao;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.security.Role;

public interface RoleDao extends CrudRepository<Role, Long>{
	Role findByName(String name);
}
