val numbers = sc.parallelize(Seq(1, 2, 3, 4, 5, 6))

// Narrow transformation
val doubled = numbers.map(x => x * 2)

// Narrow transformation
val evenNumbers = numbers.filter(x => x % 2 == 0)

// Pair RDD
val pairs = sc.parallelize(
  Seq(
    ("A", 10),
    ("B", 20),
    ("A", 30),
    ("B", 40)
  )
)

// Wide transformation - causes a shuffle
val reduced = pairs.reduceByKey(_ + _)

// Wide transformation - causes a shuffle
val grouped = pairs.groupByKey()

println("Doubled:")
doubled.collect().foreach(println)

println("Even numbers:")
evenNumbers.collect().foreach(println)

println("reduceByKey:")
reduced.collect().foreach(println)

println("groupByKey:")
grouped.collect().foreach(println)
