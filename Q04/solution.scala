val numbers = sc.parallelize(Seq(1, 2, 3, 4, 5, 6))

val evenNumbers = numbers.filter(x => x % 2 == 0)

val doubled = evenNumbers.map(x => x * 2)

val total = doubled.reduce(_ + _)

println(s"Sum: $total")

println("Original RDD:")
numbers.collect().foreach(println)

println("Lineage:")
println(doubled.toDebugString)
