package at.favre.lib.planb.recover;

import android.content.Context;

import at.favre.lib.planb.data.CrashData;

public interface RecoverBehaviour {

    boolean killProcess();

    boolean callDefaultExceptionHandler();

    boolean persistCrashData();

    void handleCrash(Context context, Thread thread, Throwable throwable, CrashData crashData);

    CrashAction getPreCrashAction();

    CrashAction getPostCrashAction();

    interface CrashAction {
        void onUnhandledException(Context context, Thread thread, Throwable throwable, CrashData crashData);

        class Default implements CrashAction {
            @Override
            public void onUnhandledException(Context context, Thread thread, Throwable throwable, CrashData crashData) {

            }
        }
    }
}
