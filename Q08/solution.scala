val languageValues = sc.parallelize(
  Seq(
    ("Java", 10),
    ("Spark", 20),
    ("Java", 15),
    ("Python", 25)
  )
)

val totals = languageValues.reduceByKey(_ + _)

totals.collect().foreach(println)
