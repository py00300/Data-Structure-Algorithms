package ds.mit.session.one.oracle;

public class FuncInterfaceSample {

  public static void main(String[] args) {
    /*
      - the below lambda expression can be assigned to any functional interface which does not accept any input and is void
      - Functional Interfaces provide a target Type for lambda expressions
      - Lambda Expressions can be bound to different functional interfaces if the method signatures are compatible
      - Functions descriptors: shows input types and return types (method signature without a method name)
        - examples: () -> void
        -  (int, int) -> int equivalent functional interface interface with JUST ONE method with any name as public int anyName(int left, int right);
     */
   Runnable myLambda = () -> System.out.println("Hey this is Lambda");

  }
}
