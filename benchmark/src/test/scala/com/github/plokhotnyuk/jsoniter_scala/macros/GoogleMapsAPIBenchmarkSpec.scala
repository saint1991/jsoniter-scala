package com.github.plokhotnyuk.jsoniter_scala.macros

class GoogleMapsAPIBenchmarkSpec extends BenchmarkSpecBase {
  private val benchmark = new GoogleMapsAPIBenchmark
  
  "GoogleMapsAPIBenchmark" should {
    "deserialize properly" in {
      benchmark.readCirce() shouldBe benchmark.obj
      benchmark.readDslJsonJava() shouldBe benchmark.obj
      benchmark.readJacksonScala() shouldBe benchmark.obj
      benchmark.readJsoniterScala() shouldBe benchmark.obj
      benchmark.readPlayJson() shouldBe benchmark.obj
      benchmark.readUPickle() shouldBe benchmark.obj
    }
    "serialize properly" in {
      toString(benchmark.writeCirce()) shouldBe GoogleMapsAPI.compactJsonString
      toString(benchmark.writeDslJsonJava()) shouldBe GoogleMapsAPI.compactJsonString
      toString(benchmark.writeJacksonScala()) shouldBe GoogleMapsAPI.compactJsonString
      toString(benchmark.writeJsoniterScala()) shouldBe GoogleMapsAPI.compactJsonString
      toString(benchmark.preallocatedBuf, benchmark.preallocatedOff, benchmark.writeJsoniterScalaPrealloc()) shouldBe GoogleMapsAPI.compactJsonString
      toString(benchmark.writePlayJson()) shouldBe GoogleMapsAPI.compactJsonString
      toString(benchmark.writeUPickle()) shouldBe GoogleMapsAPI.compactJsonString
    }
  }
}