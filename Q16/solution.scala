val numbers = sc.parallelize(1 to 1000000)

val processed = numbers
  .map(x => x * 2)
  .filter(x => x % 4 == 0)

processed.cache()

println("First action - count:")
println(processed.count())

println("Second action - sum:")
println(processed.sum())

println(s"Storage level: ${processed.getStorageLevel}")
