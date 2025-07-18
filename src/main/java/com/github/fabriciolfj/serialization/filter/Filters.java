package com.github.fabriciolfj.serialization.filter;

import java.io.ObjectInputFilter;

public final class Filters {

    private Filters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static ObjectInputFilter.Status melonFilter(ObjectInputFilter.FilterInfo filterInfo) {
        var clazz = filterInfo.serialClass();

        if (clazz != null) {
            return !(clazz.getPackage().getName().equals("com.github.fabriciolfj.serialization")) && clazz.getSimpleName().equals("Melon") ?
                    ObjectInputFilter.Status.ALLOWED : ObjectInputFilter.Status.REJECTED;
        }

        return ObjectInputFilter.Status.UNDECIDED;
    }
}
