package com.github.fabriciolfj.serialization.filter;

import java.io.ObjectInputFilter;

public class MelonFilter implements ObjectInputFilter {

    @Override
    public Status checkInput(FilterInfo filterInfo) {
        var clazz = filterInfo.serialClass();

        if (clazz != null) {
            return !(clazz.getPackage().getName().equals("com.github.fabriciolfj.serialization")) && clazz.getSimpleName().equals("Melon") ?
                    Status.ALLOWED : Status.REJECTED;
        }

        return Status.UNDECIDED;
    }
}
