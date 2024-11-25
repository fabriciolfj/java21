package com.github.fabriciolfj;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * O termo "fracamente consistente" significa que:
 *
 * Pode ou não refletir modificações feitas após sua criação
 * Não lança ConcurrentModificationException
 * É projetado para ambientes concorrentes onde consistência absoluta não é necessária
 * O comportamento pode variar entre execuções
 *
 * Este é um comportamento específico de coleções concorrentes como ArrayBlockingQueue, diferente de coleções não-concorrentes como ArrayList que lançariam uma ConcurrentModificationException neste caso.
 * */

public class ArrayQueueTest {

    //fracamente consistente
    public static void main(String[] args) {
        var queue = new ArrayBlockingQueue<Integer>(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        var iterator = queue.iterator();

        System.out.println(queue);

        System.out.println("Replace items until we have 10..19");
        for (int i = 10; i < 20; i++) {
            queue.poll();
            queue.add(i);
        }
        System.out.println("queue = " + queue);

        //mostra o primeiro, pq ArrayBlockingQueue modifica seus elements, e nesse caso para de entregar elementos
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
