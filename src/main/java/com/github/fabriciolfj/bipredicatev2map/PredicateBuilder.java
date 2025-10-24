package com.github.fabriciolfj.bipredicatev2map;

import java.lang.reflect.Field;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

enum PredicateBuilder {

    EQUALS(String::equals);

    private final BiPredicate<String, String> predicate;

    private PredicateBuilder(BiPredicate<String, String> predicate) {
        this.predicate = predicate;
    }

    public <T> Predicate<T> toPredicate(Function<T, String> getter, String u) {
        return obj -> {
            var result = getter.apply(obj);
            return this.predicate.test(result, u);
        };
    }

    public static <T> Function<T, String> getFieldByName(Class<T> cls, String field) {
        return object -> {
            try {
                Field f = cls.getDeclaredField(field);
                f.setAccessible(true);

                return (String) f.get(object);
            } catch (IllegalAccessException | IllegalArgumentException
                    | NoSuchFieldException | SecurityException e) {                
                throw new RuntimeException(e);
            }
        };
    }        
}