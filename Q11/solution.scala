val lines = sc.textFile(
  "file:///home/sri/spark-assignment-2/Q11/input.txt"
)

val words = lines.flatMap(line => line.split("\\s+"))

val sparkWords = words.filter(word => word.equalsIgnoreCase("Spark"))

val pairs = sparkWords.map(word => (word.toLowerCase, 1))

val counts = pairs.reduceByKey(_ + _)

counts.saveAsTextFile(
  "file:///home/sri/spark-assignment-2/Q11/output"
)
