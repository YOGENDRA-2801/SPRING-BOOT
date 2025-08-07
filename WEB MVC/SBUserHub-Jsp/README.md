1.	JSP is not the default view technology in spring boot but we can use JSP in spring boot. By default spring boot uses Thymleaf for view rendering.

2.	Html page can be accessed "directly" via the anchore by mentioning it with .html extension but the same cannot be achieved for jsp [if you try to access jsp page directly by mentioned it's extension .jsp you will get "Whitelabel Error Page"]

3.	<a href=contact.html> contact us </a> ✓✓          <a href=contact.jsp> contact us </a> ✕✕

4.	To enable support for jsp in spring boot we have add tomcat jasper dependencies

5.	Model interface ka use kiya to send the model object while returning the view name taki uss view page per jab user data enter kare to wah model m store ho jaye

6.	Then jab wah view page phirse redirect karega and request controller k pass aayegi to hum @ModelAttribute ka use krke uss data ko get krwa lenge
