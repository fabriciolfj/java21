package com.github.fabriciolfj.hiddenclass;


import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;

public class Simulacao {

    static void main() throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        Class<?> clazz = InternalMath.class;
        String clazzPath = clazz.getName().replace('.', '/') + ".class";
        InputStream stream = clazz.getClassLoader().getResourceAsStream(clazzPath);
        byte[] clazzByte = stream.readAllBytes();

        Class<?> hiddenClass = lookup.defineHiddenClass(clazzByte, true, MethodHandles.Lookup.ClassOption.NESTMATE).lookupClass();

        var obj = hiddenClass.getConstructor().newInstance();

        var method = obj.getClass().getDeclaredMethod("sum", int[].class);
        System.out.println(method.invoke(obj, new int[]{4,5,6}));
    }
}
