import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.Window
import spark.implicits._

val transactions = spark.read
  .option("header", "true")
  .option("inferSchema", "true")
  .csv("file:///home/sri/spark-assignment-2/Q20/transactions.csv")

val customers = spark.read
  .option("header", "true")
  .option("inferSchema", "true")
  .csv("file:///home/sri/spark-assignment-2/Q20/customers.csv")

println("Original transactions:")
transactions.show()

// Handle null values
val cleaned = transactions
  .na.fill(Map(
    "amount" -> 0.0,
    "transaction_date" -> "Unknown"
  ))

// Derived column
val enriched = cleaned.withColumn(
  "amount_category",
  when(col("amount") >= 1000, "High")
    .when(col("amount") >= 500, "Medium")
    .otherwise("Low")
)

// Customer aggregation
val customerTotals = enriched
  .groupBy("customer_id")
  .agg(
    sum("amount").alias("total_amount"),
    count("*").alias("transaction_count")
  )

// Window function
val windowSpec =
  Window.orderBy(desc("total_amount"))

val rankedCustomers = customerTotals
  .withColumn(
    "customer_rank",
    dense_rank().over(windowSpec)
  )

// Broadcast join with small customer lookup
val finalResult = rankedCustomers.join(
  broadcast(customers),
  Seq("customer_id"),
  "left"
)

// Repartition
val finalOutput = finalResult.repartition(4)

println("Final result:")
finalOutput.show(false)

// Write Parquet
finalOutput.write
  .mode("overwrite")
  .parquet(
    "file:///home/sri/spark-assignment-2/Q20/output"
  )

println("Parquet output written successfully.")
