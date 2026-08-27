# Q20 — End-to-End Spark Project Explanation

## 1. DAG

The application builds a logical DAG from the DataFrame operations.

The major flow is:

CSV Read
→ Null Handling
→ Derived Column
→ GroupBy Aggregation
→ Window Function
→ Broadcast Join
→ Repartition
→ Parquet Write

## 2. Transformations

Transformations are evaluated lazily.

Examples used in this application include:

- `na.fill`
- `withColumn`
- `groupBy`
- `agg`
- `withColumn` with a window function
- `join`
- `repartition`

## 3. Actions

The final write operation:

```scala
write.parquet(...)
