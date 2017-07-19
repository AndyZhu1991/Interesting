package andy.zhu.interesting.runat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhujinchang on 2017/7/19.
 */
public class RunAt {

    private List<Runnable> mRunnables = new ArrayList<>();
    private boolean isOutDated = false;

    public void post(Runnable runnable) {
        mRunnables.add(runnable);
    }

    public void postOrExecute(Runnable runnable) {
        if (isOutDated) {
            runnable.run();
        } else {
            mRunnables.add(runnable);
        }
    }

    public void execute() {
        for (Runnable runnable: mRunnables) {
            runnable.run();
        }
        mRunnables.clear();
        isOutDated = true;
    }

    public void reset() {
        mRunnables.clear();
        isOutDated = false;
    }
}
