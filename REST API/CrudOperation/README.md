1.	@RestController  is a combination of @Controller and @ResponseBody
2.	@ResponseBody -- isko tab use krte hai jab hum view page ka name return nahi kr rhe json type ka data hai ya koi aur data return kr rhe -- Can be used at class level or method level
3.	@RequestBody -- used to bind http request body (usually json or xml format) directly to method parameter, converting it into java object
4.	@PathVariable -- Used to extract values from URI template in request URL, allowing dynamic data retrieval from URL
5.	ResponseEntity -- represents entire http response including header , body & status code. Allows greater control over response
6.	@RequestParam -- URL = .../price?price=11111.22
7.	ResponseEntity.notFound().build() -- here build() is used to build the response entity with no body.
8. Put -- Resource ko poora replace karne ke liye. Missing fields → null/default values
9. Patch -- Resource ka partial update karne ke liye. Missing fields → unchanged


@Override    @Transactional
public Products updateProduct(Long id, BigDecimal price) {
	Products oldPro = proRepo.findById(id).get() ;
	oldPro.setPrice(price);
	return proRepo.save(oldPro) ; -- 
//		1. Due to @Transactional oldPro object JPA ke persistence context me attached hai 
//		2. Hence when managed object me koi change karte ho (setPrice()), to JPA us change ko transaction commit hote hi automatically flush kar deta hai database me.
//		3. Is case me explicitly save() call karna optional hota hai.
}