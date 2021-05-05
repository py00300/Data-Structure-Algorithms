package coursera.algorithms.week.one;

public class QuickUnion {

  private int[] id;

  public QuickUnion(int n) {
    this.id = new int[n];
    for (int i = 0; i < n; i++) {
      this.id[i] = i;
    }
  }

  public int root(int i) {
    while (i != id[i]) {
      i = this.id[i];
    }
    return i;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    this.id[i] = j;
  }


}
