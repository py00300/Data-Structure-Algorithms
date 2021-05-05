package coursera.algorithms.week.one;

public class QuickFindUF {

  private int[] id;

  public QuickFindUF(int n) {
    this.id = new int[n];
    for (int i = 0; i < n; i++) {
      this.id[i] = i;
    }
  }

  public boolean connected(int p, int q) {
    if (this.id[p] == this.id[q]) {
      return true;
    }
    return false;
  }

  public void union(int p, int q) {
    int pid = this.id[p];
    int qid = this.id[q];

    for (int i = 0; i < this.id.length; i++) {
      if (this.id[i] == pid) {
        this.id[i] = qid;
      }
    }
  }


}
