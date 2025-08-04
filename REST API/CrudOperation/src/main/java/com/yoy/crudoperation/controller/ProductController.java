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

@RestController  // Combination of @Controller and @ResponseBody
public class ProductController {
	
	private final ProductService service ;
	
	public ProductController(ProductService service) {
		super();
		this.service = service;
	}

	@PostMapping("/insert")
//	@ResponseBody -- isko tab use krte hai jab hum view page ka name return nahi kr rhe json type ka data hai ya koi aur data return kr rhe -- Can be used at class level or method level 
	public Products addProducts(@RequestBody Products saaman) {
		return service.insertProduct(saaman) ;
	}
	
//	@RequestBody -- used to bind http request body (usually json or xml format) directly to method parameter, converting it into java object

	@GetMapping("/getallproduct")
	public List<Products> getAllProducts() {
		return service.getAllPro();
	}
	
//	@PathVariable -- Used to extract values from URI template in request URL, allowing dynamic data retrieval from URL 
	
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
	
//	ResponseEntity -- represents entire http response including header , body & status code. Allows greater control over response
	
	@PutMapping("/updatePrice/{id}/price")
	public Products updatePrice(@PathVariable Long id , @RequestParam BigDecimal price) {
		return service.updateProduct(id, price) ;
	}
	
//	@RequestParam -- URL = .../price?price=11111.22
	
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




















