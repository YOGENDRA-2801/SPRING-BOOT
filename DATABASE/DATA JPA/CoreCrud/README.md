1. Hamare diye hue return type ke hisab se JPA apni query ko modify krta hai.
		If query cmd ka output list h but humne return type single obj set kiya hai then first ocurrence return karega answer ka
2. Refer https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html for various jpa query methods
3. JPA spec me koi mechanism define nahi hai jo missing columns ke liye auto-null daale aur phir entity banaye. Partial data ke liye JPA ke paas 2 option hote hain: Object[] and DTO projection (new SomeDto(...)) aur full data k liye entity object like Patient. Projection doesn't work with native query
4. COUNT() function
		COUNT() empty rakhna SQL syntax me valid nahi hai — () ke andar kuch na kuch aana hi chahiye.
		COUNT(*) → table ki har row ko count karta hai, chahe column NULL ho ya na ho. But ager pura row hi null h to count nahi karega
		COUNT(columnName) → sirf non-NULL values count karega us column ke liye.
5. @Transactional  -- From spring framework package , required for modifying DB
6. @Modifying -- Indicates a query method should be considered as modifying query.This annotation is only considered if used on query methods defined through a Query annotation. It's not applied on custom implementation methods or queries derived from the method name
7. Pagination works on all types of query (query method , native , jpql). Page , Pageable , PageRequest -- From data.domain
8. Paginaion
		1. Pagination : um query ke results ko ek hi baar me saara load krne ke bajaye page by page load karein.
		2. Page = Results ka ek chunk (e.g., 10 rows ek page me)
		3. Pageable = Page number + Page size + Sorting info
		4. PageRequest = Pageable ka implementation jo batata hai kaun sa page aur kitne records chahiye
		5 Page<T> = Paged results ka wrapper jo data + meta info (total pages, total elements) deta hai	


1. Foreign key wala column == Join Column as yah 2 classes/table ko join krta h. Use @JoinColumn instead of @Column in case of mapping. In case of entity you should always define mapping when doing foreign-key-case
2. Two source of truth stating the same statement => creates ambiguity , yah scene bi-directional mapping k case m ho skta h hence to resolve this there is concept of 'owning side (foreign key ko own krne wala)' and 'inverse side (mappedBy attribute wala)'
3. Owning Side => will have FK but not mappedBy attribute. Many-to-Many -- FK resides in separate table (jaha many-to-many + joincolumn wahi owning side). Many-to-One & One-to-Many -- FK is in many side table. One-to-One -- Dependent side is owing side (80-90% case, look for dependency>performance>db-design>busns-logic)
4. Inverse side se koi bhi change karega to association wale column per kuch bhi affect nahi krga as association column belongs to owing side. Hence changes ko action me lane k liye unko owning me dalo than inverse m bhi daal do just to maintain bidirectional consistency
5. HashSet ko create kiya new keyword se in entity class taki hibernate ko null value store na krna pade reference variable me 