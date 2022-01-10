package ds.mit.session.one.oracle;

import java.util.stream.Stream;

public class StreamApiJavaEight {

  /*
     - Java 8 streams process collections in a functional way
     - NOT related to JAVA io.Streams
     - What is stream? A sequence of elements from some source (e.g. a collection) that can be processed
     - it is NOT a data structure(has no storage)
     - chain operations together like a pipeline 2 types of operations Intermediate and Terminal operations
       - INT -> INT -> INT -> TER
       - data can flow among these operations
     Intermediate Operations:
     - provide ongoing functional processing mechanism (the pipeline)
     - can be chained together(always return stream reference)
     - Lazily evaluated when terminal operation is encountered
     Terminal Operations:
     - Trigger evaluation of a pipeline (i.e. chain of intermediate operations)

     - mySet.stream()
     - myList.stream()
     - Stream.of() for arrays
     - can stream Maps too just not directly (use set-returning method instead e.g. entrySet and stream from that)
     - Terminal Operations: creating result collections. use collectors class methods: toSet - creates a set of the elements in Stream
     - allMatch/anyMatch to test elements in the stream (pass a predicate) - return a boolean
     - noneMatch tests all elements to check a condition is NOT true
     
  */
  public static void main(String[] args) {

    // A sample of Pipeline
    Stream.of("bob", "fred", "alice", "ali")
        .map(name -> name.toUpperCase())
        .filter(s -> s.length() == 5)
        .sorted()
        .forEach(System.out::println);
  }
}
