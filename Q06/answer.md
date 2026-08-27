# Q6 — Transformation vs Action

## Transformations

Transformations create a new RDD from an existing RDD.

They are lazily evaluated. Spark records the transformation in the DAG but does not execute it immediately.

### Transformations in this question

- `map`
- `filter`
- `flatMap`
- `reduce`
- `reduceByKey`

## Actions

Actions trigger the execution of the Spark computation.

They return a result to the driver or write the result to external storage.

### Actions in this question

- `collect`
- `count`
- `saveAsTextFile`

## Classification Table

| Operation | Type | Lazy? |
|---|---|---|
| `map` | Transformation | Yes |
| `filter` | Transformation | Yes |
| `flatMap` | Transformation | Yes |
| `reduce` | Action | No |
| `collect` | Action | No |
| `count` | Action | No |
| `reduceByKey` | Transformation | Yes |
| `saveAsTextFile` | Action | No |

## Important Note

`reduce` is an **action**, not a transformation.

It combines the elements of an RDD and returns the final result to the driver.

For example:

```scala
val numbers = sc.parallelize(Seq(1, 2, 3, 4))
val sum = numbers.reduce(_ + _)
