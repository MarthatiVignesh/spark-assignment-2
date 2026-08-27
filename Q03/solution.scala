val numbers = sc.parallelize(Seq(10, 20, 30, 40, 50))

val doubled = numbers.map(x => x * 2)

val total = doubled.sum()

println(s"Sum of doubled numbers: $total")
