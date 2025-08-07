@Id
@SequenceGenerator(
 	name = "user_gen", // ✅ Java code mein reference name
 	sequenceName = "user_seq", // Optional -- ✅ Database mein actual sequence object ka naam:
 	initialValue = 101, // ✅ Starting value
 	allocationSize = 1  // ✅ 1-1 increment के लिए add करो
 	)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")


If index.html file static folder ke ander hai then usko as a  landing page set-up krne k liye hume controller ki need nahi hai
@GetMapping("/")  public String openHome()  {  return "index" ;  }


1.	"Files-jo-static-folder-m-h" OR "Static-file" ko with extension mention kr skte hai inside hyperlink but dynamic pages ko without extension hi mention krne ka 

2.	"Files jo template ya web-inf m h" OR "Dynamic Pages" k liye humko controller ki need padti hai 

3.	th:field="*{name-should-be-same-as-entity-class-property-name}"

4.	Jab aap th:field="*{id}" use karte ho, Thymeleaf model object ke id field ki value ko bind karta hai input field ke saath. And by default, Java me int/long ka default value 0 hota hai, isliye Thymeleaf form ess filled m ek prefilled value show hoti hai 0. To remove this use datatype as Long or Integer i.e. wrapper class