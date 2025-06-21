package com.gifthub.fabriciolfj.gatherers;

import com.github.fabriciolfj.gatherers.NumericSumGatherer;
import com.github.fabriciolfj.gatherers.SentenceSplitterGatherer;
import com.github.fabriciolfj.gatherers.SlidingWindowGatherer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFunctions {

    @Test
    void givenNumbers_whenFolded_thenSumIsEmitted() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        Stream folded = numbers.gather(Gatherers.fold(() -> 0, Integer::sum));
        List resultList = folded.toList();
        assertEquals(1, resultList.size());
        assertEquals(15, resultList.getFirst());
    }

    @Test
    void givenWords_whenMappedConcurrently_thenUppercasedWordsAreEmitted() {
        Stream<String> words = Stream.of("a", "b", "c", "d");
        List<String> resultList = words.gather(Gatherers.mapConcurrent(2, String::toUpperCase)).toList();
        assertEquals(4, resultList.size());
        assertEquals(List.of("A", "B", "C", "D"),resultList);
    }

    //retorna os valores intermediarios, diferente do fold
    @Test
    void givenNumbers_whenScanned_thenRunningTotalsAreEmitted() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4);
        List<Integer> resultList = numbers.gather(Gatherers.scan(() -> 0, Integer::sum)).toList();
        assertEquals(4, resultList.size());
        assertEquals(List.of(1, 3, 6, 10),resultList);
    }

    @Test
    void givenNumbers_whenWindowedSliding_thenOverlappingWindowsAreEmitted() {
        List<List<Integer>> expectedOutput = List.of(List.of(1, 2, 3), List.of(2, 3, 4), List.of(3, 4, 5));
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        List<List<Integer>> resultList = numbers.gather(Gatherers.windowSliding(3))
                .toList();
        assertEquals(3, resultList.size());
        assertEquals(expectedOutput,resultList);
    }

    @Test
    void givenStrings_whenUsingCustomGatherer_thenLengthsAreCalculated() {
        List<Integer> expectedOutput = List.of(5, 6, 3);
        Stream<String> inputStrings = Stream.of("apple", "banana", "cat");
        List<Object> resultList = inputStrings.gather(Gatherer.of((state, element, downstream) -> {
                    downstream.push(element.length());
                    return true;
                }))
                .toList();
        assertEquals(3, resultList.size());
        assertEquals(expectedOutput, resultList);
    }

    @Test
    void givenNumbers_whenUsingCustomManyToOneGatherer_thenSumIsCalculated() {
        Stream<Integer> inputValues = Stream.of(1, 2, 3, 4, 5, 6);
        List<Integer> result = inputValues.gather(new NumericSumGatherer())
                .toList();
        Assertions.assertEquals(Integer.valueOf(21), result.getFirst());
    }

    @Test
    void givenSentences_whenUsingCustomOneToManyGatherer_thenWordsAreExtracted() {
        List<String> expectedOutput = List.of("hello", "world", "java", "streams");
        Stream<String> sentences = Stream.of("hello world", "java streams");
        List<String> words = sentences.gather(new SentenceSplitterGatherer())
                .toList();
        assertEquals(expectedOutput, words);
    }

    @Test
    void givenNumbers_whenWindowedSliding_thenOverlappingWindowsAreEmitted2() {
        List<List<Integer>> expectedOutput = List.of(List.of(1, 2, 3), List.of(2, 3, 4), List.of(3, 4, 5));
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        List<List<Integer>> resultList = numbers.gather(new SlidingWindowGatherer())
                .toList();
        Assertions.assertEquals(3, resultList.size());
        Assertions.assertEquals(expectedOutput, resultList);
    }
}
