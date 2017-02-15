package at.favre.lib.planb;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import at.favre.lib.planb.data.CrashData;
import at.favre.lib.planb.recover.CrashRecoverBehaviour;

/**
 * Factory for all built-in crash behaviors
 */
public interface RecoverBehaviorFactory {

    /**
     * Creates behaviour where crashes will be suppressed and no error dialog or similar will be shown
     */
    CrashRecoverBehaviour createSuppressCrashBehaviour();

    /**
     * Creates behaviour where crashes will be suppressed and no error dialog or similar will be shown
     *
     * @param prePostAction   called before {@link CrashRecoverBehaviour#handleCrash(Context, Thread, Throwable, CrashData, PlanBConfig)}
     * @param postCrashAction called after {@link CrashRecoverBehaviour#handleCrash(Context, Thread, Throwable, CrashData, PlanBConfig)}
     */
    CrashRecoverBehaviour createSuppressCrashBehaviour(@Nullable CrashRecoverBehaviour.CrashAction prePostAction, @Nullable CrashRecoverBehaviour.CrashAction postCrashAction);

    /**
     * Creates behaviour which acts like the default handle (ie. showing a OS error dialog)
     */
    CrashRecoverBehaviour createDefaultHandlerBehaviour();

    /**
     * Creates behaviour which acts like the default handle (ie. showing a OS error dialog)
     *
     * @param prePostAction   called before {@link CrashRecoverBehaviour#handleCrash(Context, Thread, Throwable, CrashData, PlanBConfig)}
     * @param postCrashAction called after {@link CrashRecoverBehaviour#handleCrash(Context, Thread, Throwable, CrashData, PlanBConfig)}
     */
    CrashRecoverBehaviour createDefaultHandlerBehaviour(@Nullable CrashRecoverBehaviour.CrashAction prePostAction, @Nullable CrashRecoverBehaviour.CrashAction postCrashAction);

    /**
     * Creates behaviour where the current foreground activity (or launch activity) will be started on crash, effectively restarting the app
     */
    CrashRecoverBehaviour createStartActivityCrashBehaviour();

    /**
     * Creates behaviour where the provided activity will be started
     *
     * @param intent of the activity to be started
     */
    CrashRecoverBehaviour createStartActivityCrashBehaviour(Intent intent);

    /**
     * Creates behaviour where the provided activity will be started
     *
     * @param prePostAction   called before {@link CrashRecoverBehaviour#handleCrash(Context, Thread, Throwable, CrashData, PlanBConfig)}
     * @param postCrashAction called after {@link CrashRecoverBehaviour#handleCrash(Context, Thread, Throwable, CrashData, PlanBConfig)}
     */
    CrashRecoverBehaviour createStartActivityCrashBehaviour(@Nullable CrashRecoverBehaviour.CrashAction prePostAction, @Nullable CrashRecoverBehaviour.CrashAction postCrashAction);

    /**
     * Creates behaviour where the provided activity will be started.
     *
     * @param intent          of the activity to be started
     * @param prePostAction   called before {@link CrashRecoverBehaviour#handleCrash(Context, Thread, Throwable, CrashData, PlanBConfig)}
     * @param postCrashAction called after {@link CrashRecoverBehaviour#handleCrash(Context, Thread, Throwable, CrashData, PlanBConfig)}
     */
    CrashRecoverBehaviour createStartActivityCrashBehaviour(Intent intent, @Nullable CrashRecoverBehaviour.CrashAction prePostAction, @Nullable CrashRecoverBehaviour.CrashAction postCrashAction);
}