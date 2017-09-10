package com.codetest.usermgmnt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codetest.usermgmnt.entity.User;

@Repository
public interface UserManagementRepository extends JpaRepository<User,String>{


}
