package com.yoy.crudoperation.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoy.crudoperation.entity.Products;
import com.yoy.crudoperation.service.ProductService;

@RestController
public class ProductController {
	
	private final ProductService service ;
	
	public ProductController(ProductService service) {
		super();
		this.service = service;
	}

	@PostMapping("/insert") 
	public Products addProducts(@RequestBody Products saaman) {
		return service.insertProduct(saaman) ;
	}
	
	@GetMapping("/getallproduct")
	public List<Products> getAllProducts() {
		return service.getAllPro();
	}
		
	@GetMapping("/getproductbyid/{id}")
	public ResponseEntity<Products> getProducts(@PathVariable Long id) {
		Products product = service.findProById(id) ;
		if (product != null) {
			return ResponseEntity.ok().body(product) ;
		}
		else {
//			return ResponseEntity.notFound().build() ;
			return ResponseEntity.notFound().header("Message", "Product not found with id: " + id).build();
		}		
	}
		
	@PutMapping("/updatePrice/{id}/price")
	public Products updatePrice(@PathVariable Long id , @RequestParam BigDecimal price) {
		return service.updateProduct(id, price) ;
	}
		
	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<String> removeProduct(@PathVariable Long id) {
		boolean status = service.removeProduct(id) ;
		if (status) {
			return ResponseEntity.ok().body("USER DELETED") ;
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID " + id + " not found");
		}
	}
}




















