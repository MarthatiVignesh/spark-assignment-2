val departmentMap = Map(
  "E01" -> "Engineering",
  "E02" -> "HR",
  "E03" -> "Finance",
  "E04" -> "Engineering"
)

val broadcastDept = sc.broadcast(departmentMap)

val employees = sc.parallelize(
  Seq(
    ("E01", "Ravi"),
    ("E02", "Priya"),
    ("E03", "Arun"),
    ("E04", "Sneha")
  )
)

val result = employees.map { case (empId, name) =>
  val department =
    broadcastDept.value.getOrElse(empId, "Unknown")

  (empId, name, department)
}

result.collect().foreach(println)
