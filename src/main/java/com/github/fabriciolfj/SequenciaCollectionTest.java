package com.github.fabriciolfj;

import java.util.ArrayList;

//trabalha com a ordem de inserção e busca dos objetos
public class SequenciaCollectionTest {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1); 				// [1]
        arrayList.addFirst(0);	// [0, 1]
        arrayList.addLast(2);		// [0, 1, 2]
        arrayList.getFirst();	// 0
        arrayList.getLast();	// 2

    }
}
