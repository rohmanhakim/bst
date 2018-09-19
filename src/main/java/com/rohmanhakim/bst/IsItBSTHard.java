package com.rohmanhakim.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class IsItBSTHard {

  static class BST {
    Vertex root;
  }

  static class Vertex {

    private Vertex left = null;
    private Vertex right = null;
    private Vertex parent = null;

    private int leftIndex;
    private int rightIndex;

    private int key;

    void setLeft(Vertex left) {
      this.left = left;
      left.parent = this;
    }

    private void setRight(Vertex right) {
      this.right = right;
      right.parent = this;
    }
  }

  private static BST construct(List<Vertex> vertices) {

    for (Vertex v : vertices) {
      if (v.leftIndex != -1) {
        v.setLeft(vertices.get(v.leftIndex));
      }
      if (v.rightIndex != -1) {
        v.setRight(vertices.get(v.rightIndex));
      }
    }
    BST bst = new BST();
    if (vertices.size() > 0)
      bst.root = vertices.get(0);
    return bst;
  }

  private static boolean isBST(Vertex root, int min, int max){
    if(root != null) {
      if(root.left == null && root.right == null && root.parent == null){
        return true;
      }
      if(root.key >= max || root.key < min){
        return false;
      }
      return isBST(root.left,min,root.key) && isBST(root.right,root.key,max);
    } else {
      return true;
    }
  }


  public static void main(String[] args) {

    int INT_MAX = 2147483647;
    int INT_MIN = -2147483647;

    Scanner scanner = new Scanner((System.in));
    int n = scanner.nextInt();
    List<Vertex> vertices = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int key = scanner.nextInt();
      int leftIndex = scanner.nextInt();
      int rightIndex = scanner.nextInt();

      Vertex v = new Vertex();
      v.key = key;
      v.leftIndex = leftIndex;
      v.rightIndex = rightIndex;
      vertices.add(v);
    }

    BST bst = construct(vertices);

    if(isBST(bst.root, INT_MIN, INT_MAX)){
      System.out.println("CORRECT");
    } else {
      System.out.println("INCORRECT");
    }

  }
}
