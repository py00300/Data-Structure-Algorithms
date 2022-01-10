package ds.mit.session.one.oracle;

public class A {

  public static void log() {
    System.out.println("From A");
  }

  public void log2() {
    System.out.println("Non static From A");
  }

  public void log3() {
    System.out.println("Log 3 From A");
  }
}

/*
  Questions:
  1. disadvantage of Micro Services.
    Communication between services is complex, More services equals more resources, Global testing is difficult,
    Debugging problems can be harder, Deployment challengers, Large vs small product companies
  2. how do transaction management in microservices.
    2PC (2 phase Commit, Saga pattern)
  3. benefit of foreign key in DB.
    Foreign keys with constraints(in some DB engines) give you data integrity on the low level(level of database).
    It means you can't physically create a record that doesn't fulfill relation. It's just a way to be more safe.
  4. use case of using store procedures.
    They allow modular programming.
    They allow faster execution.
    They can reduce network traffic.
    They can be used as a security mechanism.
  5. what is referential integrity?
   A REFERENTIAL INTEGRITY is a database concept that is used to build and maintain logical relationships between tables to avoid logical corruption of data.
   It is a very useful and important part in RDBMS.
   Usually, referential integrity is made up of the combination of a primary key and a foreign key.
   The main concept of REFERENTIAL INTEGRITY is that it does not allow to add any record in a table that contains the foreign key unless the reference table containing a corresponding primary key.
   If any record in referenced table (i.e. the table who contain primary key) is deleted, all the corresponding records in the referencing table will be deleted for the referential integrity.
  6. what is having clause in SQL.
   The HAVING clause was added to SQL because the WHERE keyword could not be used with aggregate functions.
   SELECT column_name(s)
   FROM table_name
   WHERE condition
   GROUP BY column_name(s)
   HAVING condition
   ORDER BY column_name(s);
  7. what is Dependency Injection?
  8. what is AOP?
  Aspect-Oriented Programming (AOP) complements Object-Oriented Programming (OOP) by providing another way of thinking about program structure.
  The key unit of modularity in OOP is the class, whereas in AOP the unit of modularity is the aspect.
  Aspects enable the modularization of concerns such as transaction management that cut across multiple types and objects.
  (Such concerns are often termed crosscutting concerns in AOP literature.)
  One of the key components of Spring is the AOP framework. While the Spring IoC container does not depend on AOP, meaning you do not need to use AOP if you don't want to, AOP complements Spring IoC to provide a very capable middleware solution.
  9. if we have 9 coins 8 same wight 1 heavier how find the one which is heavier? how many compare is needed?
  10. what is functional interface in java? benefits?
   a functional interface has exactly one abstract method.
   Since default methods have an implementation, they are not abstract.
   If an interface declares an abstract method overriding one of the public methods of java.lang.Object, that also does not count toward the interface's abstract method count since any implementation of the interface will have an implementation from java.lang.Object or elsewhere
  11. what is stream in java benefits?
    Streams are a more declarative style. Or a more expressive style
    Streams have a strong affinity with functions
    Streams encourage less mutability
    Streams encourage looser coupling
    Streams can succinctly express quite sophisticated behaviour
    Streams provide scope for future efficiency gains
   Disadvantages?
    Performance
    Familiarity
    Cognitive overhead
    Debuggers
  12. what are the differences between stream, input stream?
  13. Security in web services and OWASP considerations?
   https://owasp.org/www-pdf-archive/SecuringWebServices-RixGroenboom.pdf
  14. what is unique key primary key? what are the constraints?
   A primary key is a column of table which uniquely identifies each tuple (row) in that table.
   Primary key enforces integrity constraints to the table.
   Only one primary key is allowed to use in a table. The primary key does not accept the any duplicate and NULL values.
   The primary key value in a table changes very rarely so it is chosen with care where the changes can occur in a seldom manner.
   A primary key of one table can be referenced by foreign key of another table.
  15. How to sort based on 3 different variable inside a class?
   A comparable object is capable of comparing itself with another object. The class itself must implements the java.lang.Comparable interface to compare its instances.
    Consider a Movie class that has members like, rating, name, year. Suppose we wish to sort a list of Movies based on year of release.
    We can implement the Comparable interface with the Movie class, and we override the method compareTo() of Comparable interface.
   Unlike Comparable, Comparator is external to the element type we are comparing.
    It?s a separate class. We create multiple separate classes (that implement Comparator) to compare by different members.
    Collections class has a second sort() method and it takes Comparator. The sort() method invokes the compare() to sort objects.
    To compare movies by Rating, we need to do 3 things :
    Create a class that implements Comparator (and thus the compare() method that does the work previously done by compareTo()).
    Make an instance of the Comparator class.
    Call the overloaded sort() method, giving it both the list and the instance of the class that implements Comparator.
  16. OOP vs functional?
  17. enhanced for loop vs stream for each?
   The better practice is to use for-each.
   Besides violating the Keep It Simple, Stupid principle, the new-fangled forEach() has at least the following deficiencies:
     Can't use non-final variables
     Can't handle checked exceptions.
     Limited flow-control. A return in a lambda equals a continue in a for-each, but there is no equivalent to a break.
     It's also difficult to do things like return values, short circuit, or set flags (which would have alleviated things a bit, if it wasn't a violation of the no non-final variables rule).
  18. immutable? how create it? benefits?
   An object is considered immutable if its state cannot change after it is constructed. Maximum reliance on immutable objects is widely accepted as a sound strategy for creating simple, reliable code.
   Immutable objects are particularly useful in concurrent applications.
   Since they cannot change state, they cannot be corrupted by thread interference or observed in an inconsistent state.
   Programmers are often reluctant to employ immutable objects, because they worry about the cost of creating a new object as opposed to updating an object in place.
   The impact of object creation is often overestimated, and can be offset by some of the efficiencies associated with immutable objects.
   These include decreased overhead due to garbage collection, and the elimination of code needed to protect mutable objects from corruption.

   The following subsections take a class whose instances are mutable and derives a class with immutable instances from it.
   In so doing, they give general rules for this kind of conversion and demonstrate some of the advantages of immutable objects.
   The following rules define a simple strategy for creating immutable objects.
   Not all classes documented as "immutable" follow these rules.
   This does not necessarily mean the creators of these classes were sloppy ? they may have good reason for believing that instances of their classes never change after construction. However, such strategies require sophisticated analysis and are not for beginners.
   - Don't provide "setter" methods ? methods that modify fields or objects referred to by fields.
   - Make all fields final and private.
   - Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final.
   - A more sophisticated approach is to make the constructor private and construct instances in factory methods.
   If the instance fields include references to mutable objects, don't allow those objects to be changed:
    Don't provide methods that modify the mutable objects.
    Don't share references to the mutable objects.
    Never store references to external, mutable objects passed to the constructor; if necessary, create copies, and store references to the copies.
    Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods.

  19. concurrency design best practices and considerations?
  20. how find a loop in link list?
  21. check exception vs unchecked exception? why make exceptions checked or unchecked?
  1). Difference between ArrayList and LinkedList?
  2). What  is Map?
  3). What is Vector?
  4). Difference between Overloading and Overriding?
  5). Can possible to create Object for Parent class with child class reference? ex: Class A{ //Statements } Class B extends A{ //Statements PSVM(){ B Reference_Variable=new A(); } }
  6). What is Synchronization?
  7). what is the time complexity of Arraylist and Linked List?
  8). Write a program to print the higher version of a Value? Ex: Value1=7.3.4.2.5.9 Value2=7.3.2.3.8.1 o/p: 7.3.4.2.5.9 in these 2 values write a program to print the Higher Version?
  9). Test case: "Hai i am SAP" O/P: "iaH i ma PAS" write a program in java for above O/P?
  10). About Project?
  11). Flow of execution of a project with Architecture?
  12).Basic SQL Questions? (DDL DML TCl Commands)
  13). About Agile/Driven Methodology?
  14). What is final keyword?
  15) what is Data hiding?
  16) Design patterns? (Singleton Design Pattern program)
  17). Internal implementation of HashSet?
  1) Why main method is void in JAVA?
  2) Are string parameters mandatory in main method? At what time are the parameters read?
  3)Difference between sleep and wait
  4)Difference between yield vs join
  5)Checked and unchecked exceptions.
  6) Concurrent hash map.
  7)Difference between isInstance and Instance of
  8)When to use reflection and name few methods?
  9)Fail fast vs fail safe iterator
  10) JVM JRE and JDK.What does rt.jar contain?
  11 )When to use LinkedHash Map and Tree map? Which is better for insertion,deletion and search?
  12) What is static method?Where are static variable stored in memory?
  13) JAVA memory model.
  14)JAVA garbage collection process.What is survivor space?
  15)When to override toString() method?
  16)Design a DS which does the following operations:
    1)Insert,2)Delete,3)Search in O(1) complexity.


 */
