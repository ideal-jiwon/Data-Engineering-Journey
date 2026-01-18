# Scala Projects

This directory contains Scala programming assignments and projects focused on functional programming and big data processing.

## Projects

### 1. Assignment HelloWorld
A foundational Scala project demonstrating basic Scala concepts and functional programming principles.

**Location:** `assignment-helloworld/`

**Key Components:**
- HelloWorld.scala - Basic Scala application
- Ingest.scala - Data ingestion utilities
- Primes.scala - Prime number calculations

**Build System:** sbt (Scala Build Tool)
**Scala Version:** 2.13.16
**Java Version:** 21

**To Run:**
```bash
cd assignment-helloworld
sbt run
```

### 2. Spark CountWords
Apache Spark application demonstrating distributed word counting using both DataFrame and RDD APIs.

**Location:** `spark-countwords/`

**Key Features:**
- DataFrame API implementation
- RDD API implementation
- Java 21 compatibility with module system fixes
- Reduced logging configuration

**Dependencies:**
- Apache Spark 4.0.1
- Scala 2.13.16
- Java 21

**To Run:**
```bash
cd spark-countwords
sbt run
```

## Prerequisites

### Software Requirements
- Java 21 (OpenJDK recommended)
- Scala 2.13.16
- sbt (Scala Build Tool)
- Apache Spark 4.0.1

### Installation
1. Install Java 21
2. Install sbt
3. Apache Spark will be downloaded automatically via sbt dependencies

## Build Instructions

Each project uses sbt as the build system. Navigate to the project directory and use standard sbt commands:

```bash
# Compile the project
sbt compile

# Run the application
sbt run

# Run tests (if available)
sbt test

# Clean build artifacts
sbt clean
```

## Configuration Notes

### Java 21 Module System
The Spark project includes JVM arguments to handle Java 21 module system restrictions:
- Opens java.base modules for Kryo serialization
- Configures logging to reduce verbosity

### Logging
Spark logging is configured to WARN level to reduce console output while maintaining error visibility.

## Project Structure

```
Scala/
├── README.md
├── assignment-helloworld/
│   ├── build.sbt
│   └── src/
│       └── main/
│           └── scala/
│               └── edu/
│                   └── neu/
│                       └── coe/
│                           └── csye7200/
│                               └── assthw/
└── spark-countwords/
    ├── build.sbt
    ├── src/
    │   └── main/
    │       ├── scala/
    │       └── resources/
    └── sample_text.txt
```

## Learning Objectives

- Functional programming concepts in Scala
- Distributed computing with Apache Spark
- Build automation with sbt
- Java interoperability and module system handling