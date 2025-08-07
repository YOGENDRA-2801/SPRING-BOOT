package com.yoy.crudoperation.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yoy.crudoperation.entity.Products;
import com.yoy.crudoperation.repository.ProductRepository;

@Service
public class ProSrvcImpl implements ProductService
{
	
	private final ProductRepository proRepo ;

	public ProSrvcImpl(ProductRepository proRepo) {
		super();
		this.proRepo = proRepo;
	}

	@Override
	@Transactional
	public Products insertProduct(Products products) {
		try {
			return proRepo.save(products) ; 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public Products findProById(Long id) {
		try {
			return proRepo.findById(id).get() ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Products> getAllPro() {
		try {
			return proRepo.findAll() ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public Products updateProduct(Long id, BigDecimal price) {
		try {
			Products oldPro = proRepo.findById(id).get() ;
			oldPro.setPrice(price);
			return oldPro ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public boolean removeProduct(Long id) {
		try {
			proRepo.deleteById(id);
			return true ;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}