val numbers = sc.parallelize(1 to 100)

println(s"Default partitions: ${numbers.getNumPartitions}")

val repartitioned = numbers.repartition(4)

println(
  s"Partitions after repartition(4): ${repartitioned.getNumPartitions}"
)

println("Sample data:")
repartitioned.take(10).foreach(println)
