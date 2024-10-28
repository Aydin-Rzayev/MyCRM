package com.MyCRM.MyCRM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyCRM.MyCRM.models.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer>{

}
