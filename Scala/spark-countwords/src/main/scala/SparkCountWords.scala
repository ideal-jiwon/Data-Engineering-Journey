import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object SparkCountWords {
  def main(args: Array[String]): Unit = {
    // Create SparkSession
    val spark = SparkSession.builder()
      .appName("CountWords")
      .master("local[*]")
      .config("spark.sql.adaptive.enabled", "false")
      .config("spark.sql.adaptive.coalescePartitions.enabled", "false")
      .getOrCreate()

    // Import implicits for DataFrame operations
    import spark.implicits._

    println("=== Spark CountWords Example ===")
    println(s"Spark Version: ${spark.version}")
    println(s"Scala Version: ${scala.util.Properties.versionString}")

    try {
      // Create sample data instead of reading from file
      val sampleText = Seq(
        "Hello Spark World",
        "Spark is great for big data processing",
        "Hello World from Apache Spark",
        "Big data processing with Spark",
        "Apache Spark makes data processing easy",
        "Hello from the world of big data",
        "Spark Spark Spark everywhere",
        "Data processing is fun with Apache Spark"
      )

      // Create DataFrame from sample data
      val textDF = sampleText.toDF("line")

      // Count words using DataFrame API
      val wordCounts = textDF
        .select(explode(split(col("line"), " ")).as("word"))
        .filter(col("word") =!= "")
        .select(lower(regexp_replace(col("word"), "[^a-zA-Z]", "")).as("word"))
        .filter(col("word") =!= "")
        .groupBy("word")
        .count()
        .orderBy(desc("count"))

      println("\n=== Word Counts (DataFrame API) ===")
      wordCounts.show()

      // Alternative using RDD API
      val textRDD = spark.sparkContext.parallelize(sampleText)
      val wordCountsRDD = textRDD
        .flatMap(_.split(" "))
        .filter(_.nonEmpty)
        .map(_.toLowerCase.replaceAll("[^a-zA-Z]", ""))
        .filter(_.nonEmpty)
        .map(word => (word, 1))
        .reduceByKey(_ + _)
        .sortBy(-_._2)

      println("\n=== Word Counts (RDD API) ===")
      wordCountsRDD.collect().foreach { case (word, count) =>
        println(s"$word: $count")
      }

      println("\n=== Total number of words ===")
      val totalWords = wordCountsRDD.map(_._2).reduce(_ + _)
      println(s"Total words: $totalWords")

      println("\n=== CountWords example completed successfully! ===")

    } catch {
      case e: Exception =>
        println(s"Error: ${e.getMessage}")
        e.printStackTrace()
    } finally {
      spark.stop()
    }
  }
}