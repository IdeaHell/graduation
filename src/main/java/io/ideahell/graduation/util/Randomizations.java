package io.ideahell.graduation.util;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

public final class Randomizations {

    private static final ThreadLocalRandom RAND = ThreadLocalRandom.current();

    private Randomizations() {}

    public static boolean roll(int value, int from) {
        return RAND.nextInt(from) < value;
    }

    public static boolean rollPercent(int value) {
        return roll(value, 100);
    }

    public static <E extends Enum> E rollEnum(Class<E> enumClass) {
        final String VALUES_METHOD_NAME = "values";
        E[] values = (E[]) Array.newInstance(enumClass, 0);
        try {
            values = (E[]) enumClass.getMethod(VALUES_METHOD_NAME).invoke(null);
        } catch (NoSuchMethodException | // Enum#values() does exist
                SecurityException | // Using native classloader
                IllegalAccessException | // Enum#values() is public
                IllegalArgumentException | // Enum#values() requires no args
                InvocationTargetException ex // Enum#values values is static
                ) {
            // should not happen
        }

        return values[RAND.nextInt(values.length)];
    }

}
