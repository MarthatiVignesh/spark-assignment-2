# Q1 — Understanding the Spark Cluster

## Spark Cluster Architecture

```text
                    +----------------------+
                    |     Cluster Manager  |
                    |  Resource Allocation |
                    +----------+-----------+
                               |
                               |
                    +----------v-----------+
                    |        Driver       |
                    |  Spark Application   |
                    |  SparkContext /     |
                    |  SparkSession       |
                    +----------+-----------+
                               |
                 +-------------+-------------+
                 |                           |
                 v                           v
        +------------------+        +------------------+
        |   Worker Node 1  |        |   Worker Node 2  |
        |                  |        |                  |
        |   Executor 1     |        |   Executor 2     |
        |   - Tasks        |        |   - Tasks        |
        |   - Cached Data  |        |   - Cached Data  |
        +------------------+        +------------------+
