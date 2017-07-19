package andy.zhu.interesting.icare;

import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhujinchang on 2017/7/19.
 */
public class Cares {

    public static String toString(Object o) {
        List<Field> fields = getAllICareFields(o);
        List<String> fieldStrings = new ArrayList<>(fields.size());
        for (Field field: fields) {
            field.setAccessible(true);
            try {
                fieldStrings.add(field.getName() + " = " + field.get(o));
            } catch (IllegalAccessException e) {
                // Do nothing
            }
        }
        return StringUtils.join(fieldStrings, ", ");
    }

    public static boolean equals(Object origin, Object other) {
        if (origin == other) {
            return true;
        } else {
            if (!other.getClass().isAssignableFrom(origin.getClass())) {
                return false;
            } else {
                for (Field field: getAllICareFields(origin)) {
                    try {
                        if (!field.get(origin).equals(field.get(other))) {
                            return false;
                        }
                    } catch (IllegalAccessException e) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static int hashCode(Object o) {
        int result = 17;
        for (Field field: getAllICareFields(o)) {
            try {
                result = 31 * result + field.get(o).hashCode();
            } catch (IllegalAccessException e) {
                // Ignore
            }
        }
        return result;
    }

    private static List<Field> getAllICareFields(Object o) {
        List<Field> allICareFields = new ArrayList<>();
        for (Field field: o.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ICare.class)) {
                allICareFields.add(field);
            }
        }
        return allICareFields;
    }
}
