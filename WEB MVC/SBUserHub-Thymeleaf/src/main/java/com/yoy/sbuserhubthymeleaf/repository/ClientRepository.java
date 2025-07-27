package com.yoy.sbuserhubthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yoy.sbuserhubthymeleaf.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>
{

}
