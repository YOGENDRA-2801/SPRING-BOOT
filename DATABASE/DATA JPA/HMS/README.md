1. In production-grade always use 
	spring.jpa.hibernate.ddl-auto=validate OR spring.jpa.hibernate.ddl-auto=none
	spring.jpa.show-sql=false
2. Test method ka return type hamesha void hona chahiye 
3. Data in persistent context during transaction act as first level cache data [if data available then sql query fire nahi hoti direct data utha leta hai persistent context se hence obj1 == obj2]
4. When data persistent context k ander rhta hai and usme ager humne change kiya but commit nahi kiya to phir jab hibernate dirty checking krta hai last me wah uss data ko commit kr dega
5. Students => students , studentName => student_name -- hibernate/jpa apne aap camelcase & cap-case ko snake case me kr deta hai
6. Unique constraints & Index ki usage se insert operation ki performance p thoda sa -ve impact aata hai. Indexes optimizes the search operation
7. Ager entity class m property(column) ya class(table) ka naam change kiya to rename nahi hoga new bana dega in case of ddl=update to deal with this we have to use migration tool
8. @UniqueConstraint(columnNames = "Tab-Col-Name")  ,  @Index(columnList = "Tab-Col-Name")
9. Data Seeding = Database mein initial/sample data automatically populate krna application startup ke time par. Create "data.sql" file in resource folder and wirte sql insert cmd init + in app.prop file define database-initialization , mode , data-location properties.
10. defer-datasource-initialization => data.sql file automatically run hone ke liye ; init.mode => to specify SQL init scripts kab execute hongi ; init.schema-locations => Custom SQL files ka path