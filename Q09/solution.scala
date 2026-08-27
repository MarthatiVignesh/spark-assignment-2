// Normal RDD
val numbers = sc.parallelize(Seq(10, 20, 30, 40))

val total = numbers.reduce(_ + _)

println(s"Normal RDD reduce result: $total")

// Pair RDD
val salaries = sc.parallelize(
  Seq(
    ("IT", 50000),
    ("HR", 40000),
    ("IT", 60000),
    ("HR", 45000),
    ("Finance", 70000)
  )
)

val departmentTotals = salaries.reduceByKey(_ + _)

println("Department salary totals:")

departmentTotals.collect().foreach(println)
