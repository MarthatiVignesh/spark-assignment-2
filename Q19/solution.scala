import org.apache.spark.sql.functions.broadcast
import spark.implicits._

val employees = Seq(
  (1, "Ravi", "D01"),
  (2, "Priya", "D02"),
  (3, "Arun", "D03"),
  (4, "Sneha", "D01")
).toDF("id", "name", "dept_id")

val departments = Seq(
  ("D01", "Engineering"),
  ("D02", "Human Resources"),
  ("D03", "Finance")
).toDF("dept_id", "department")

println("Employees:")
employees.show()

println("Departments:")
departments.show()

println("Inner Join:")
val joined = employees.join(
  departments,
  employees("dept_id") === departments("dept_id"),
  "inner"
)

joined.select(
  employees("id"),
  employees("name"),
  departments("department")
).show()

println("Broadcast Join:")

val broadcastJoined = employees.join(
  broadcast(departments),
  employees("dept_id") === departments("dept_id"),
  "inner"
)

broadcastJoined.select(
  employees("id"),
  employees("name"),
  departments("department")
).show()
