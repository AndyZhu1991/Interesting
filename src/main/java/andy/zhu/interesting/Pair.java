package andy.zhu.interesting;

/**
 * Created by zhujinchang on 16-10-8.
 *
 * If you want return two values, use Pair ~
 */
public class Pair<L, R> {

    private L mLeft;
    private R mRight;

    public Pair(L left, R right) {
        mLeft = left;
        mRight = right;
    }

    public L getLeft() {
        return mLeft;
    }

    public R getRight() {
        return mRight;
    }
}
