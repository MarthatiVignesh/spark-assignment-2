val records = sc.textFile(
  "file:///home/sri/spark-assignment-2/Q13/records.txt"
)

val invalidRecords = sc.longAccumulator("InvalidRecords")

val validRecords = records.filter { line =>
  val fields = line.split(",")

  if (fields.length != 3) {
    invalidRecords.add(1)
    false
  } else {
    true
  }
}

validRecords.count()

println(
  s"Invalid records: ${invalidRecords.value}"
)
