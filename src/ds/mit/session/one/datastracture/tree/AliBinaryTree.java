package ds.mit.session.one.datastracture.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import javafx.util.Pair;

public class AliBinaryTree {

  AliBinaryTree left;
  AliBinaryTree right;
  int data;

  public AliBinaryTree(int data) {
    this.data = data;
  }

  public void add(int value) {
    if (value <= this.data) {
      if (left != null) {
        left.add(value);
      } else {
        left = new AliBinaryTree(value);
      }
    } else {
      if (right != null) {
        right.add(value);
      } else {
        right = new AliBinaryTree(value);
      }
    }
  }
  public boolean contains(int value) {
    if (value == this.data) {
      return true;
    }
    if (value < this.data) {
      if (left == null) {
        return false;
      } else {
        return left.contains(value);
      }
    } else {
      if (right == null) {
        return false;
      } else {
        return right.contains(value);
      }
    }
  }

  public AliBinaryTree getNode(int value) {
    if (value == this.data) {
      return this;
    }
    if (value < this.data) {
      if (left == null) {
        return null;
      } else {
        return left.getNode(value);
      }
    } else {
      if (right == null) {
        return null;
      } else {
        return right.getNode(value);
      }
    }
  }
  public void preOrder() {
    if (left != null) {
      left.preOrder();
    }
    System.out.println(this.data);
    if (right != null) {
      right.preOrder();
    }
  }

  public static void main(String[] args) {

    AliBinaryTree aliBinaryTree = getAliBinaryTree();
    Map<String, String> map = new HashMap<>();
    map.putIfAbsent("A", "b");
    map.putIfAbsent("A","c");
    map.getOrDefault("A","d");
    map.getOrDefault("B", "b");
    System.out.println(map);

    Set<Integer> visited = new HashSet<>();
    System.out.println(hasDFS(aliBinaryTree.getNode(5), aliBinaryTree.getNode(3), visited));
    System.out.println(hasBFS(aliBinaryTree.getNode(5), aliBinaryTree.getNode(17)));

  }

  private static boolean hasBFS(AliBinaryTree src, AliBinaryTree dest) {
    LinkedList<AliBinaryTree> toBeVisited = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    toBeVisited.add(src);

    while (!toBeVisited.isEmpty()) {
      AliBinaryTree toVisit = toBeVisited.remove();
      if (toVisit == dest) {
        return true;
      }
      if (visited.contains(toVisit.data)) {
        continue;
      }
      visited.add(toVisit.data);
      if (toVisit.left != null) {
        toBeVisited.add(toVisit.left);
      }
      if (toVisit.right != null) {
        toBeVisited.add(toVisit.right);
      }
    }
    return false;
  }

  private static boolean hasDFS(AliBinaryTree source, AliBinaryTree destination, Set<Integer> visited) {
    if (visited.contains(source.data)) {
      visited.forEach(System.out::println);
      return false;
    }
    visited.add(source.data);
    if (source == destination) {
      visited.forEach(System.out::println);
      return true;
    }

    if (source.left != null && hasDFS(source.left, destination, visited)) {
      visited.forEach(System.out::println);
      return true;
    }
    if (source.right != null && hasDFS(source.right, destination, visited)) {
      visited.forEach(System.out::println);
      return true;
    }
    visited.forEach(System.out::println);
    return false;
  }

  private static int getSumDepth(AliBinaryTree aliBinaryTree, int i) {
    if (aliBinaryTree == null) {return 0;}

    return i + getSumDepth(aliBinaryTree.right, i + 1) + getSumDepth(aliBinaryTree.left, i +1);

  }

  private static AliBinaryTree getAliBinaryTree() {
    AliBinaryTree aliBinaryTree = new AliBinaryTree(5);
    aliBinaryTree.add(9);
    aliBinaryTree.add(3);
    aliBinaryTree.add(10);
    aliBinaryTree.add(2);
    return aliBinaryTree;
  }

}
