package com.rohmanhakim.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Traversal {

  static class BST {
    private Vertex root;

    public BST() {
    }

    public Vertex getRoot() {
      return root;
    }

    public void setRoot(Vertex root) {
      this.root = root;
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
    List<String> inorder = new ArrayList<>();
    List<String> preorder = new ArrayList<>();
    List<String> postorder = new ArrayList<>();

    inOrderTraversal(bst.getRoot(), inorder);
    preOrderTraversal(bst.getRoot(), preorder);
    postOrderTraversal(bst.getRoot(), postorder);

    System.out.println(String.join(" ", inorder.toArray(new CharSequence[inorder.size()])));

    System.out.println(String.join(" ", preorder.toArray(new CharSequence[preorder.size()])));

    System.out.println(String.join(" ", postorder.toArray(new CharSequence[postorder.size()])));
  }

  private static void inOrderTraversal(Vertex x, List<String> result) {
    if (x != null) {
      inOrderTraversal(x.getLeft(), result);
      result.add(String.valueOf(x.getKey()));
      inOrderTraversal(x.getRight(), result);
    }
  }

  private static void preOrderTraversal(Vertex x, List<String> result) {
    if (x != null) {
      result.add(String.valueOf(x.getKey()));
      preOrderTraversal(x.getLeft(), result);
      preOrderTraversal(x.getRight(), result);
    }
  }

  private static void postOrderTraversal(Vertex x, List<String> result) {
    if (x != null) {
      postOrderTraversal(x.getLeft(), result);
      postOrderTraversal(x.getRight(), result);
      result.add(String.valueOf(x.getKey()));
    }
  }

  private static BST construct(List<Vertex> vertices) {
    int rootIndex = 0;
    for (int i = 0; i < vertices.size(); i++) {
      Vertex v = vertices.get(i);
      if (v.getLeftIndex() != -1) {
        v.setLeft(vertices.get(v.getLeftIndex()));
      }
      if (v.getRightIndex() != -1) {
        v.setRight(vertices.get(v.getRightIndex()));
      }
      if (rootIndex == v.getLeftIndex() || rootIndex == v.getRightIndex()) {
        rootIndex = i;
      }
    }
    BST bst = new BST();
    bst.setRoot(vertices.get(rootIndex));
    return bst;
  }

  private static void treeInsert(BST bst, Vertex v) {
    Vertex y = null;
    Vertex x = bst.getRoot();
    while (x != null) {
      y = x;
      if (v.getKey() < x.getKey()) {
        x = x.getLeft();
      } else {
        x = x.getRight();
      }
    }
    v.setParent(y);
    if (y == null) {
      bst.setRoot(v);
    } else if (v.getKey() < y.getKey()) {
      y.setLeft(v);
    } else {
      y.setRight(v);
    }
  }
}

