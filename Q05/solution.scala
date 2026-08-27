val sentences = Seq(
  "Spark is fast",
  "Spark is distributed",
  "Hadoop is distributed",
  "Spark is powerful"
)

val lines = sc.parallelize(sentences)

val words = lines.flatMap(line => line.split("\\s+"))

val pairs = words.map(word => (word.toLowerCase, 1))

val wordCounts = pairs.reduceByKey(_ + _)

wordCounts.collect().foreach(println)
