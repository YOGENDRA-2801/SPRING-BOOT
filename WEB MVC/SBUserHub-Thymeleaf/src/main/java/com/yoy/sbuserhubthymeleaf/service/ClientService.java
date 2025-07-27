package com.yoy.sbuserhubthymeleaf.service;

import com.yoy.sbuserhubthymeleaf.entity.Client;

public interface ClientService 
{
	public Client addClient(Client client) ;
	public Client findById(Long id) ;
}