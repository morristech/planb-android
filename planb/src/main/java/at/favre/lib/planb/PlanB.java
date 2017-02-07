package at.favre.lib.planb;

import android.content.Context;

import at.favre.lib.planb.data.CrashDataHandler;

public final class PlanB {
    private static PlanB instance;
    static Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

    public static PlanB get() {
        if (instance == null) {
            instance = new PlanB();
        }
        return instance;
    }

    private PlanBConfig config;

    private PlanB() {
    }

    public void enableCrashHandler(PlanBConfig config, Context context) {
        this.config = config;
        Thread.setDefaultUncaughtExceptionHandler(new PlanBUncaughtExceptionHandler(context, config));
    }

    public void disableCrashHandler() {
        Thread.setDefaultUncaughtExceptionHandler(defaultUncaughtExceptionHandler);
    }

    public PlanBConfig.Builder configBuilder(Context context) {
        return PlanBConfig.newBuilder(context);
    }

    public CrashDataHandler getCrashDataHandler() {
        if (config == null) {
            throw new IllegalStateException("you need to enable the crash handler first");
        }
        return config.storage;
    }
}
