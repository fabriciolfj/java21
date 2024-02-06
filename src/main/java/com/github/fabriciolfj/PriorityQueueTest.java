package com.github.fabriciolfj;

import com.github.fabriciolfj.pojo.Person;
import com.github.fabriciolfj.pojo.PersonComparator;

import java.util.Iterator;
import java.util.PriorityQueue;

//iterador percorre na ordem de nivel por nivel, ou seja, não garante a ordem de prioridade
//maior prioridade seria o menor valo, maior valor seria de prioridade mais baixa

/**
 *    1
 *   / \
 *  3   2
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(1);
        queue.add(2);

        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.println(element);
        }

        var person1 = new Person("fabricio", 39);
        var person2 = new Person("suzana", 34);
        var person3 = new Person("lucas", 29);

        var queuePerson = new PriorityQueue<Person>(new PersonComparator());
        queuePerson.add(person1);
        queuePerson.add(person2);
        queuePerson.add(person3);

        var iteratorPerson = queuePerson.iterator();

        while (iteratorPerson.hasNext()) {
            System.out.println(iteratorPerson.next());
        }

        System.out.println("=========");

        //pegando a orgem
        while(!queuePerson.isEmpty()) {
            var person = queuePerson.poll();
            System.out.println(person);
        }
    }
}
