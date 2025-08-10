1.	[Presentation Layer] <--DTO--> [Service Layer] <--Entity--> [Repository Layer]
2.	DTO => Used for the exchange of data between the presentation layer and the service layer.
3.	Entity => Used for the exchange of data between the repository layer and the service layer.
4.	ResponseBody => tells that controller sejo data return hoga wah json form me return hoga naki html/jsp view name.
5.	@Data => from Lombok package Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.  
6.	@AllArgsConstructor => from Lombok package Generates an all-args constructor.An all-args constructor requires one argument for every field in the class
7.	@RequiredArgsConstructor => creates constructor with required properties (final wale properties)
8.	spring boot automatically (via httpmessageconverter) jackson response ko json format me convert kr deta hai
9.	modelmapper -- baar baar new keyword use na krna pade esiliye use kiya 


public List<StudentDto> getAllStudents() {
//    allStudents ka type List<Student> hai hence .stream() ka type Stream<Student> ban jata hai. Isliye .map(...) ke andar aap jo parameter doge (student) uska type Student hoga
	List<Student> allStudents = repository.findAll() ;
// 	here student is a lambda parameter and i	ska type Java compiler automatically infer kar leta hai based on stream ka type.
	return allStudents.stream().map(student -> new StudentDto(student.getId(),student.getName(),student.getEmail())).toList();
//    Lambda expression me parameter stream ke elements se aata hai. Jab .map() call hota hai, stream har element ko ek-ek karke lambda me pass karta hai.
	}

return modelMapper.map(student, StudentDto.class) ; 
return modelMapper.map(student, studDtoObj) ; 
// student and studentdto should have same field (name & type) if different thode extra config krne padnge

modelMapper.map(updStudDto, existingStud);  
// new separate dto banaya bcoz purane dto mese id ki value joki null thi [ as didn't explicitly provided in json ] wah bhi paste ho ja rha tha 


1.	JPA repository interface ka implementation spring boot provide krta hai implicitly hence we extend it not implement
2.	Interface ko sirf interface extend kar sakta hai, class nahi
3.	entity class ka variable controller class me nahi bana skte but method return use kr skte 
4.	Stream ka use krke hum kisi bhi collection kisi dusere collection me convert kr skte hai 
5.	server.servlet.context-path=/Student-Management -- Application ka base URL prefix set karta hai. saara API endpoint ab http://localhost:8080/Student-Management/... se start hoga.
6.	Delete krte time hum usually kuch return nahi krte  -- http code 204 for no content
7.  debug = true -- properties can be also be provided via the environment variable. alternative for application.properties file is environment variable
