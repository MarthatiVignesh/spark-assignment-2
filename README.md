# Incremental Order Processing & Sales

## Overview
A PySpark Structured Streaming project that incrementally reads daily order CSV files, validates records, calculates order totals, handles duplicate order IDs, and computes cumulative sales by city.

## Technologies
- Python 3
- Apache Spark / PySpark 3.5.3
- Structured Streaming
- CSV input and Parquet batch storage

## Project structure
- `src/order_streaming.py` — streaming application
- `order_source/day_01/`, `day_02/`, `day_03/` — sample daily CSV files
- `output/processed_batches/` — generated batch data
- `output/city_sales/` — cumulative city sales output
- `checkpoint/order_stream/` — streaming recovery checkpoint

## Features
- Incremental CSV file ingestion
- Validation of required fields, quantities, prices, and timestamps
- Total order value calculation (`quantity * unit_price`)
- UDF-based order value classification
- Duplicate order ID handling
- Cumulative city-wise sales and item totals
- Checkpoint-based restart recovery

## Run
From the project root, with Python 3 and PySpark 3.5.3 installed:

```bash
python3 src/order_streaming.py
```

Add new daily CSV files under `order_source/` while the stream is running. Preserve the same header and column format.

## Restart recovery
Stop the application and restart it using the same checkpoint directory. Do not delete `checkpoint/order_stream/` if you want Spark to resume from its saved progress.

## Sample results
The three sample files produced these cumulative totals:

| City | Total sales | Items |
|---|---:|---:|
| Delhi | 63,200 | 5 |
| Kanpur | 15,900 | 5 |
| Lucknow | 79,000 | 3 |
| Mumbai | 65,000 | 1 |
| **Total** | **223,100** | **14** |

Duplicate order `O103` is counted once in the cumulative result.

## Generated files
The `output/` and `checkpoint/` directories are runtime-generated and should not be committed. The local `.gitignore` excludes them.
