package com.MyCRM.MyCRM.repositories;

import com.MyCRM.MyCRM.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}
