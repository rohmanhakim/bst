//package com.rohmanhakim.bst;
//
//public class SetSums {
//
//  static class Vertex {
//    int key;
//    Vertex left;
//    Vertex right;
//    public Vertex() {}
//  }
//
//  static Vertex rotateRigth(Vertex v){
//    Vertex y  = v.left;
//    v.left = y.right;
//    y.right = v;
//    return y;
//  }
//
//  static Vertex rotateLeft(Vertex v){
//    Vertex y  = v.right;
//    v.right = y.left;
//    y.left = v;
//    return y;
//  }
//
//  static Vertex splay(Vertex root, int key){
//    if(root == null || root.key == key){
//      return  root;
//    }
//
//    if(root.key > key){
//      if(root.left == null) return  root;
//
//
//    }
//  }
//}
