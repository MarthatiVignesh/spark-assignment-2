val numbers = sc.parallelize(1 to 100, 4)

println(
  s"Original partitions: ${numbers.getNumPartitions}"
)

val repartitioned = numbers.repartition(8)

println(
  s"After repartition(8): ${repartitioned.getNumPartitions}"
)

val coalesced = repartitioned.coalesce(4)

println(
  s"After coalesce(4): ${coalesced.getNumPartitions}"
)

println("Sample data:")
coalesced.take(10).foreach(println)
