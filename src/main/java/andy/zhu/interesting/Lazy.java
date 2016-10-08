package andy.zhu.interesting;

/**
 * Created by zhujinchang on 16-10-8.
 *
 * It is Lazy and cached.
 */
public abstract class Lazy<T> {

    private T mRef;

    public T get() {
        if (mRef == null) {
            mRef = init();
        }

        return mRef;
    }

    protected abstract T init();

    public interface Creator<T> {
        T create();
    }

    /**
     * Use this method like this:
     * Lazy<String> lazy = Lazy.create(() -> "");
     * Instead of:
     * Lazy<String> lazy = new Lazy<String>() {
     *     @Override
     *     protected String init() {
     *         return "";
     *     }
     * };
     */
    public static <T> Lazy<T> create(final Creator<T> creator) {
        return new Lazy<T>() {
            @Override
            protected T init() {
                return creator.create();
            }
        };
    }
}
