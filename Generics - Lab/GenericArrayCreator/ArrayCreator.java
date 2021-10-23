package GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    public static<T> T[] create(int length, T item) {
        T[] array = (T[]) Array.newInstance(item.getClass(), length);
        Arrays.fill(array, item);
        return array;
    }

    public static<T> T[] create(Class<T> cls, int length, T item) {
        T[] array = (T[]) Array.newInstance(cls, length);
        Arrays.fill(array, item);
        return array;
    }
}
