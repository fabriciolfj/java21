package com.gifthub.fabriciolfj;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

//trabalha com a ordem de inserção e busca dos objetos
public class SequenciaCollectionTest {

    public static void main(String[] args) {
        SequencedSet<String> sequenciadoSet = new LinkedHashSet< >( ) ;
        sequenciadoSet.addFirst( "Apple" ); ;
        sequenciadoSet.add ( "Banana" ) ;
        sequenciadoSet.addLast ( "Cherry" ); ;
        assertEquals ( "Apple" ,sequenciadoSet.getFirst ( )) ;
        assertEquals ( "Cherry" , sequenciadoSet.getLast ( )) ;

        SequencedCollection<String> sequencedCollection = new ArrayList < > () ;
        sequencedCollection.addFirst ( "Apple" ); ;
        sequencedCollection.add ( "Banana" ) ;
        sequencedCollection.addLast ( "Cherry" ); ;
        assertEquals ( "Apple" ,sequencedCollection.getFirst ( )) ;
        assertEquals ( "Cherry" ,sequencedCollection.getLast ( )) ;


        SequencedMap< String, Integer > sequenciadMap = new LinkedHashMap <>() ;
        sequenciadMap.putFirst ( "Apple" , 10 ) ;
        sequenciadMap. put ( "Banana" , 20 ) ;
        sequenciadMap. putLast ( "Cherry" , 30 ) ;

        assertEquals ( "Apple" , sequenciadMap.firstEntry ( ) . getKey ()) ;
        assertEquals ( 10 ,sequenciadMap.firstEntry ( ) . getValue ()) ;
        assertEquals ( "Cherry" , sequenciadMap. lastEntry () . getKey ()) ;
        assertEquals ( 30 ,sequenciadMap.lastEntry ( ) . getValue ()) ;
    }
}
