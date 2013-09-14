#Android-QueryBuilder

Android QueryBuilder is a simple library to construct sql select statements.

##Examples


###Select all
```
QueryBuilder builder = new QueryBuilder();
String sql = builder.select().from("users").build();
```

This will produce the following sql string:

```
SELECT * FROM users
```

###Column selection

```
QueryBuilder builder = new QueryBuilder();
String sql = builder.select("name").from("users").build();
```

SQL:

```
SELECT name FROM users
```

Mutiple columns can be selected as follows:

```
QueryBuilder builder = new QueryBuilder();
String sql = builder.select("name","id").from("users").build();
```

SQL:

```
SELECT name, id FROM users
```


###Where clause
```
QueryBuilder builder = new QueryBuilder();
String sql = builder.select("name").from("users").where("id").eq(1).build();

```

SQL:

```
SELECT name FROM users WHERE id = 1
```


####And 
```
QueryBuilder builder = new QueryBuilder();
String sql = builder.select().from("users").where("password").eq("'password'").and("name").eq("'alex'").build();

```

SQL:

```
SELECT * FROM users WHERE password = 'password' AND name = 'alex'
```

####Or
```
QueryBuilder builder = new QueryBuilder();
String sql = builder.select().from("users").where("name").eq("'alex'").or("name").eq("'pete'").build();

```

SQL:

```
SELECT * FROM users WHERE name = 'alex' OR name = 'pete'
```


###Order by
```
QueryBuilder builder = new QueryBuilder();
String sql = builder.select().from("users").orderBy("name").build();

```

SQL:

```
SELECT * FROM users ORDER BY name
```

```
QueryBuilder builder = new QueryBuilder();
String sql = builder.select().from("users").orderBy("name","id").build();

```

SQL:

```
SELECT * FROM users ORDER BY name, id
```

###Inner join
```
QueryBuilder builder = new QueryBuilder();
String sql = builder.select().from("users").innerJoin("posts").on("posts.user_id").eq("user.id").build();

```

SQL:

```
SELECT * FROM users INNER JOIN posts ON posts.user_id = user.id
```

###Like
```
QueryBuilder builder = new QueryBuilder();
String sql = builder.select().from("users").where("name").like("'%alex%'").build();

```

SQL:

```
SELECT * FROM users WHERE NAME LIKE '%alex%'
```

###Group by
```
QueryBuilder builder = new QueryBuilder();
String sql = builder.select().from("users").groupBy("city").build();
```

SQL:

```
SELECT * FROM users GROUP BY city
```

```
QueryBuilder builder = new QueryBuilder();
String sql = builder.select().from("users").groupBy("city").build();
```

SQL:

```
SELECT * FROM users GROUP BY city
```

###Having
```
QueryBuilder builder = new QueryBuilder();
String sql = builder.select("department","SUM(sales) AS total_sales")
	.from("order_details")
	.groupBy("department")
	.having("SUM(sales)")
	.greater(1000).build();
```

SQL:

```
SELECT department, SUM(sales) AS total_sales FROM order_details GROUP BY department HAVING SUM(sales) > 1000
```




