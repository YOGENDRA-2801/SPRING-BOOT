@ModelAttribute
 	✅ Form data → User object inside controller mein bind kar deta hai
 	✅ Incoming request data handle karta hai
 	❌ Response mein data send nahi kar sakta
 	@ModelAttribute = Incoming data handle karta hai
 	Request → Controller  ---  @ModelAttribute  ---  Form data bind karta hai


Model
 	✅ JSP/View mein data send karta hai
 	✅ Response data handle karta hai
 	JSP ko data bhejta hai
 	Model = Outgoing data handle karta hai
 	Controller → View  ---  Model  ---  View ko data send karta hai


public String profile(@ModelAttribute User user, Model model) {
		Spring creates User object, binds form data
		Spring automatically: create a model and model.addAttribute("user", user);
		iske alwava kuch aur krna h to model bhi declare krna padega
}


@Autowired private User user ;  // Yaha tumne Entity ko Bean ki tarah inject karne ki koshish ki hai, lekin Entity classes Spring Beans nahi hoti.
User entity hai, Bean nahi! Spring isko manage nahi karta as a Bean. Services/Repositories are Spring Beans
Therefore you have explicitly create instance of User entity using new keyword