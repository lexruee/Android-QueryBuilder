package ch.xonix.querybuilder.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ch.xonix.querybuilder.QueryBuilder;

public class QueryBuilderTest {

	@Test
	public void shouldSelectAll() {
		String shouldBe = "SELECT * FROM TEST";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void shouldSelectCols() {
		String shouldBe = "SELECT id, name, age FROM TEST";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select("id","name","age").from("TEST").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testWhereClause() {
		String shouldBe = "SELECT * FROM TEST WHERE name = 'alex'";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST").where("name").eq("'alex'").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testAndWhereClause() {
		String shouldBe = "SELECT * FROM TEST WHERE name = 'alex' AND id = 1";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST").where("name").eq("'alex'").and("id").eq("1").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testMutipleAndWhereClause() {
		String shouldBe = "SELECT * FROM TEST WHERE name = 'alex' AND id = 1 AND age = 30";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST").where("name").eq("'alex'").and("id").eq("1").and("age").eq("30").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testOrWhereClause() {
		String shouldBe = "SELECT * FROM TEST WHERE name = 'alex' OR id = 1";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST").where("name").eq("'alex'").or("id").eq("1").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testMutipleOrWhereClause() {
		String shouldBe = "SELECT * FROM TEST WHERE name = 'alex' OR id = 1 OR age = 30";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST").where("name").eq("'alex'").or("id").eq("1").or("age").eq("30").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testEqualsClause() {
		String shouldBe = "SELECT * FROM TEST WHERE name = 'alex'";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST").where("name").eq("'alex'").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testNotEqualsClause() {
		String shouldBe = "SELECT * FROM TEST WHERE name != 'alex'";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST").where("name").neq("'alex'").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testInnerJoin() {
		String shouldBe = "SELECT * FROM TEST1 INNER JOIN TEST2 ON TEST1.id = TEST2.id";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST1").innerJoin("TEST2").on("TEST1.id").eq("TEST2.id").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testOrderBy() {
		String shouldBe = "SELECT * FROM TEST1 ORDER BY id";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST1").orderBy("id").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testMutipleOrderBy() {
		String shouldBe = "SELECT * FROM TEST1 ORDER BY id, name";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST1").orderBy("id","name").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testLike() {
		String shouldBe = "SELECT * FROM TEST1 WHERE name LIKE '%alex%'";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST1").where("name").like("'%alex%'").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testGroupBy() {
		String shouldBe = "SELECT * FROM TEST1 GROUP BY name, id";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST1").groupBy("name","id").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testLess() {
		String shouldBe = "SELECT * FROM TEST1 WHERE ID < 10";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST1").where("ID").less("10").build();
		assertEquals(shouldBe,test);
	}

	@Test
	public void testGreater() {
		String shouldBe = "SELECT * FROM TEST1 WHERE ID > 10";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST1").where("ID").greater("10").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testGreaterOrEquals() {
		String shouldBe = "SELECT * FROM TEST1 WHERE ID >= 10";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST1").where("ID").greaterOrEquals("10").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testLessOrEquals() {
		String shouldBe = "SELECT * FROM TEST1 WHERE ID <= 10";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST1").where("ID").lessOrEquals("10").build();
		assertEquals(shouldBe,test);
	}
	
	@Test
	public void testHaving() {
		String shouldBe = "SELECT * FROM TEST1 WHERE ID <= 10 HAVING COUNT(ID) >= 2";
		QueryBuilder builder = new QueryBuilder();
		String test = builder.select().from("TEST1").where("ID").lessOrEquals("10").having("COUNT(ID)").greaterOrEquals("2").build();
		assertEquals(shouldBe,test);
	}

}
