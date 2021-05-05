package coursera.algorithms.week.one;

public class Runner {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    QuickFindUF quickFindUF = new QuickFindUF(100000);
    quickFindUF.union(2, 50000);
    quickFindUF.union(50000, 80000);
    System.out.println(quickFindUF.connected(2, 80000));
    System.out.println(System.currentTimeMillis() - startTime);

    long startTime2 = System.currentTimeMillis();
    QuickUnion quickUnion = new QuickUnion(100000);
    quickUnion.union(2, 50000);
    quickUnion.union(50000, 80000);
    System.out.println(quickUnion.connected(2, 80000));
    System.out.println(System.currentTimeMillis() - startTime2);

  }
}
