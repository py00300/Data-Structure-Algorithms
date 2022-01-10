package coursera.algorithms.week.two.amazon.q1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q1 {

  public static void main(String[] args) {
    int n = 10;
    List<String> edges = Arrays.asList("1 2", "1 3", "2 4", "3 5", "7 8");
    System.out.println(Result.connectedSum(n, edges));
  }

  static class Result {

    /*
     * Complete the 'connectedSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY edges
     */

    public static int connectedSum(int n, List<String> edges) {
      final Graph g = new Graph();

      for (String edge : edges) {

        String[] e = edge.split(" ");

        int s = Integer.parseInt(e[0]);
        int d = Integer.parseInt(e[1]);
        System.out.println(Integer.parseInt(e[0]) + " " + Integer.parseInt(e[1]));
        if (g.getNode(s) == null) {
          g.createNode(s);
        }
        if (g.getNode(d) == null) {
          g.createNode(d);
        }
        g.addEdge(s, d);
      }

      LinkedList<Node> nextToVisit = new LinkedList<>();
      Set<Integer> connected = new HashSet<>();
      for (Map.Entry<Integer, Node> entry : g.nodeLookup.entrySet()) {
        int c = 0;
        Set<Integer> visited = new HashSet<>();
        nextToVisit.add(entry.getValue());
        while (!nextToVisit.isEmpty()) {
          Node node = nextToVisit.remove();
          if (visited.contains(node.id)) {
            continue;
          }
          visited.add(node.id);
          for (Node child : node.ajList) {
            nextToVisit.add(child);
          }
          c++;
        }
        connected.add(c);
      }

      int result = 0;
      int total = 0;
      for (Integer i : connected) {
        if (i != 1) {
          result += Math.ceil(Math.sqrt(i));
          total += i;
        }
      }

      System.out.println(connected);
      return result + (n - total);
    }

  }

  static class Graph {

    Map<Integer, Node> nodeLookup = new HashMap<>();

    public void createNode(int id) {
      this.nodeLookup.put(id, new Node(id));
    }

    public Node getNode(int id) {
      return this.nodeLookup.get(id);
    }

    public void addEdge(int source, int destination) {
      Node s = getNode(source);
      Node d = getNode(destination);
      s.ajList.add(d);
    }


  }

  public static class Node {

    int id;
    LinkedList<Node> ajList = new LinkedList<>();

    Node(int id) {
      this.id = id;
    }
  }
}

