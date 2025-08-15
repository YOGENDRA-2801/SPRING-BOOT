1. In production-grade always use 
	spring.jpa.hibernate.ddl-auto=validate OR spring.jpa.hibernate.ddl-auto=none
	spring.jpa.show-sql=false
	Use 'insert ignore' instead of simple 'insert'
2. Test method ka return type hamesha void hona chahiye 
3. Data in persistent context during transaction act as first level cache data [if data available then sql query fire nahi hoti direct data utha leta hai persistent context se hence obj1 == obj2]
4. When data persistent context k ander rhta hai and usme ager humne change kiya but commit nahi kiya to phir jab hibernate dirty checking krta hai last me wah uss data ko commit kr dega
5. Students => students , studentName => student_name -- hibernate/jpa apne aap camelcase & cap-case ko snake case me kr deta hai
6. Unique constraints & Index ki usage se insert operation ki performance p thoda sa -ve impact aata hai. Indexes optimizes the search operation
7. Ager entity class m property(column) ya class(table) ka naam change kiya to rename nahi hoga new bana dega in case of ddl=update to deal with this we have to use migration tool
8. @UniqueConstraint(columnNames = "Tab-Col-Name")  ,  @Index(columnList = "Tab-Col-Name")
9. Data Seeding = Database mein initial/sample data automatically populate krna application startup ke time par. Create "data.sql" file in resource folder and wirte sql insert cmd init + in app.prop file define database-initialization , mode , data-location properties.
10. defer-datasource-initialization => data.sql file automatically run hone ke liye ; init.mode => to specify SQL init scripts kab execute hongi ; init.data-locations => Custom SQL file for data ka path
11. spring.sql.init.schema-locations ka kaam hota hai schema 'create' karne wale scripts ka location dena (table creation DDL).
12. spring.sql.init.data-locations ka kaam hota hai data insert/update (DML) wale SQL scripts ka location dena (table me initial/sample data dalne wale DML cmds).
13. @Enumerated annotation enum values ko database mein kaise store karna hai ye define karta hai. EnumType.STRING -- Preferrred + DB me same enum values store krta in form of string. EnumType.ORDINAL -- Default + DB me integral value (1,2,3,...) store krta h not the same enum value


1. To create a object of LocalDate use LocalDate.of(year, month, date) [ inside method argument if meth param ko local date ka obj chahiye ]
2. SQL & JPQL ke COMMANDS case insensitive hote hai




