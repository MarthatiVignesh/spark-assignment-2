# Q2 — Spark vs Hadoop MapReduce

## Comparison

| Feature | Apache Spark | Hadoop MapReduce |
|---|---|---|
| Processing model | DAG-based processing engine | Map → Shuffle → Reduce |
| Intermediate data | Can keep data in memory | Typically writes intermediate data to disk |
| Speed | Generally faster for iterative and multi-stage workloads | Generally slower due to more disk I/O |
| Iterative processing | Very suitable | Less suitable |
| Ease of combining operations | DAG allows multiple transformations to be optimized | More rigid MapReduce stages |
| Fault tolerance | Uses lineage and recomputation | Uses replicated data and task re-execution |
| Typical use | Interactive analytics, iterative processing, streaming, ML | Large batch processing |

## Why Spark Can Be Faster

Spark can be faster than traditional MapReduce because:

1. **In-memory processing** — Spark can keep intermediate data in memory, reducing disk I/O.
2. **DAG execution** — Spark can optimize a sequence of transformations as a Directed Acyclic Graph.
3. **Lazy evaluation** — Spark can delay execution and optimize the required computation.
4. **Caching** — Frequently reused datasets can be cached.
5. **Reduced overhead** — Spark can reuse executor processes within an application.

## When MapReduce May Still Be Appropriate

Hadoop MapReduce can still be appropriate when:

- The workload is primarily large-scale batch processing.
- The processing does not require repeated reuse of intermediate data.
- Disk-based processing is acceptable.
- An existing Hadoop MapReduce infrastructure and application ecosystem is already available.

## Conclusion

Spark and Hadoop MapReduce are both distributed processing technologies.

Spark is generally advantageous for iterative, multi-stage, and interactive workloads because of its DAG engine, in-memory processing, caching, and lazy evaluation.

MapReduce can still be useful for straightforward, large-scale batch workloads where its disk-based processing model is sufficient.
