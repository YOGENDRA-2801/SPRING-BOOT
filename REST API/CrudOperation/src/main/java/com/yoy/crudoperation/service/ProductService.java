package com.yoy.crudoperation.service;

import java.math.BigDecimal;
import java.util.List;

import com.yoy.crudoperation.entity.Products;

public interface ProductService {
	
//	CREATE OPERATION
	public Products insertProduct(Products products) ;
//	READ OPERATION
	public Products findProById(Long id) ;
	public List<Products> getAllPro() ;
//	UPDATE OPERATION
	public Products updateProduct(Long id , BigDecimal price) ;
//	DELETE OPERATION
	public boolean removeProduct(Long id) ;
	
}