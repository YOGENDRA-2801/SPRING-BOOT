package in.yoy.annobasedconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.yoy.annobasedconfig.beans.Students;

@SpringBootApplication
public class AnnoBasedConfigApplication implements CommandLineRunner 
{
	
//	CommandLineRunner ek interface hota h jo spring boot app start hote hi jo bhi code humne provide kiya h usko execute krwa dena
	
	@Autowired
	private Students stud ;

	public static void main(String[] args) 
	{		
		SpringApplication.run(AnnoBasedConfigApplication.class, args);		
	}

	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println("Spring Boot Application Started!");
		stud.display();
	}
}
