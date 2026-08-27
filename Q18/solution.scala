import spark.implicits._

val employees = Seq(
  (1, "Ravi", "Engineering", 70000),
  (2, "Priya", "HR", 50000),
  (3, "Arun", "Finance", 60000),
  (4, "Sneha", "Engineering", 80000),
  (5, "Kiran", "HR", 55000)
)

val df = employees.toDF(
  "id",
  "name",
  "department",
  "salary"
)

println("Employee DataFrame:")
df.show()

df.createOrReplaceTempView("employees")

println("Employees with salary greater than 60000:")

spark.sql("""
  SELECT name, department, salary
  FROM employees
  WHERE salary > 60000
""").show()

println("Average salary by department:")

spark.sql("""
  SELECT department, AVG(salary) AS average_salary
  FROM employees
  GROUP BY department
""").show()
