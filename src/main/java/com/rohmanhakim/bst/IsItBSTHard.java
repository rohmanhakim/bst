package com.rohmanhakim.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IsItBSTHard {
  static class BST {
    Vertex root;
    private Vertex prev;

    BST() {
    }

    private boolean inOrderTraversal(Vertex x) {
      if (x != null) {
        if (!inOrderTraversal(x.getLeft()))
          return false;
        if (x.getKey() <= prev.getKey())
          return false;
        if (x.getKey() >= x.parent.key)
          return false;
        prev = x;
        return inOrderTraversal(x.getRight());
      }
      return true;
    }
  }

  static class Vertex {

    private Vertex left;
    private Vertex right;
    private Vertex parent;

    private int leftIndex;
    private int rightIndex;

    private int key;

    public Vertex() {
    }


    public Vertex getLeft() {
      return left;
    }

    public void setLeft(Vertex left) {
      this.left = left;
      left.parent = this;
    }

    public Vertex getRight() {
      return right;
    }

    public void setRight(Vertex right) {
      this.right = right;
      right.parent = this;
    }

    public Vertex getParent() {
      return parent;
    }

    public void setParent(Vertex parent) {
      this.parent = parent;
    }

    public int getKey() {
      return key;
    }

    public void setKey(int key) {
      this.key = key;
    }

    public int getLeftIndex() {
      return leftIndex;
    }

    public void setLeftIndex(int leftIndex) {
      this.leftIndex = leftIndex;
    }

    public int getRightIndex() {
      return rightIndex;
    }

    public void setRightIndex(int rightIndex) {
      this.rightIndex = rightIndex;
    }
  }

  private static BST construct(List<Vertex> vertices) {

    for (int i = 0; i < vertices.size(); i++) {
      Vertex v = vertices.get(i);
      if (v.getLeftIndex() != -1) {
        v.setLeft(vertices.get(v.getLeftIndex()));
      }
      if (v.getRightIndex() != -1) {
        v.setRight(vertices.get(v.getRightIndex()));
      }
    }
    BST bst = new BST();
    if (vertices.size() > 0)
      bst.root = vertices.get(0);
    return bst;
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner((System.in));
    int n = scanner.nextInt();
    List<Vertex> vertices = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int key = scanner.nextInt();
      int left = scanner.nextInt();
      int right = scanner.nextInt();

      Vertex v = new Vertex();
      v.setKey(key);
      v.setLeftIndex(left);
      v.setRightIndex(right);
      vertices.add(v);
    }

    BST bst = construct(vertices);

    if (bst.inOrderTraversal(bst.root)) {
      System.out.print("CORRECT");
    } else {
      System.out.println("INCORRECT");
    }
  }
}
