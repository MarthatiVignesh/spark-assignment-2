# Q17 — Spark on YARN

## Overview

YARN is a cluster resource-management system. Spark can run on YARN so that YARN manages cluster resources while Spark manages the execution of the Spark application.

## Main Components

### ResourceManager

The ResourceManager is the main YARN resource-management service.

It:

- Manages cluster resources.
- Allocates resources to applications.
- Coordinates with NodeManagers.

### NodeManager

A NodeManager runs on each worker machine in the YARN cluster.

It:

- Manages resources on its node.
- Launches and monitors containers.
- Reports node information to the ResourceManager.

### ApplicationMaster

Each YARN application has an ApplicationMaster.

For a Spark application running on YARN, it helps coordinate the application with YARN and requests resources for the Spark application.

### Driver

The Spark Driver coordinates the Spark application.

Depending on the deployment mode, the Driver can run on the client machine or inside the YARN cluster.

The Driver:

- Creates the SparkContext or SparkSession.
- Builds the execution plan.
- Schedules Spark jobs, stages, and tasks.
- Coordinates the executors.

### Executors

Executors run Spark tasks and process data partitions.

They run inside resources allocated by YARN and:

- Execute Spark tasks.
- Store cached or persisted data.
- Return task results and status to the Driver.

## Spark vs YARN Responsibilities

| Spark | YARN |
|---|---|
| Builds the DAG | Manages cluster resources |
| Creates jobs and stages | Allocates containers/resources |
| Creates tasks | Launches and monitors containers |
| Schedules Spark tasks | Manages nodes and cluster resources |
| Coordinates executors | Provides resources for executors |

## Simplified Flow

```text
              Spark Application
                     |
                     v
                  Driver
                     |
                     v
              YARN ResourceManager
                     |
          +----------+----------+
          |                     |
          v                     v
     NodeManager           NodeManager
          |                     |
          v                     v
     Executor 1             Executor 2
          |                     |
          +----------+----------+
                     |
                  Results
                     |
                     v
                   Driver
