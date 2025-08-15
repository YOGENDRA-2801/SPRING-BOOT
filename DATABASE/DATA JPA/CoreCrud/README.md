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