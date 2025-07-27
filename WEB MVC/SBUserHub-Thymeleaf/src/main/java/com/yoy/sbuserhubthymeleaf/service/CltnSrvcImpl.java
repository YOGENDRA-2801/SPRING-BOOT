package com.yoy.sbuserhubthymeleaf.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yoy.sbuserhubthymeleaf.entity.Client;
import com.yoy.sbuserhubthymeleaf.repository.ClientRepository;

@Service
public class CltnSrvcImpl implements ClientService
{
	private final ClientRepository clntrepo ;

	public CltnSrvcImpl(ClientRepository clntrepo) {
		super();
		this.clntrepo = clntrepo;
	}

	@Transactional
	@Override
	public Client addClient(Client client) {
		try {
			return clntrepo.save(client) ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional (readOnly = true)
	@Override
	public Client findById(Long id) {
		try {
			return clntrepo.findById(id).get() ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
