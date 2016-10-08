package andy.zhu.interesting;

import java.lang.reflect.ParameterizedType;

/**
 * Created by zhujinchang on 16-10-8.
 *
 * Make sure T has a default constructor.
 */
public class DefaultConsLazy<T> extends Lazy<T> {
    @Override
    protected T init() {
        try {
            return ((Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
