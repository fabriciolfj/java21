package com.github.fabriciolfj.arvorerecord;

public class Main {

    sealed interface BinaryTree {

        record Leaf() implements BinaryTree {}
        record Node(int value, BinaryTree left, BinaryTree right) implements BinaryTree {}       
    }
    
    static int sumNode(BinaryTree t) {

        return switch (t) {
            
            case BinaryTree.Leaf nl -> 0;
            case BinaryTree.Node nv -> nv.value() + sumNode(nv.left()) + sumNode(nv.right());
        };
    }

    public static void main(String[] args) {

        BinaryTree leaf = new BinaryTree.Leaf();
        BinaryTree s1 = new BinaryTree.Node(5, leaf, leaf);
        BinaryTree s2 = new BinaryTree.Node(10, leaf, leaf);
        BinaryTree s = new BinaryTree.Node(4, s1, s2);

        int sum = sumNode(s);

        System.out.println("Sum: " + sum);
    }
}