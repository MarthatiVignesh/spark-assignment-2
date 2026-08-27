# Q10 — Spark Execution Flow

## Spark Program

```scala
val numbers = sc.parallelize(Seq(1, 2, 3, 4, 5, 6))

val doubled = numbers.map(x => x * 2)

val result = doubled.sum()

println(s"Final result: $result")
