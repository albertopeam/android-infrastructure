package es.albertopeam.apparchitecturelibs.notes;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.afollestad.materialdialogs.MaterialDialog;

import java.lang.ref.WeakReference;

import es.albertopeam.apparchitecturelibs.R;
import com.github.albertopeam.infrastructure.exceptions.HandledException;
import com.github.albertopeam.infrastructure.exceptions.ExceptionDelegate;

class UnsupportedOperationExceptionDelegate
        implements ExceptionDelegate {


    private WeakReference<Activity> activityWeakReference;


    UnsupportedOperationExceptionDelegate(Activity activity) {
        this.activityWeakReference = new WeakReference<>(activity);
    }


    @Override
    public boolean canHandle(@NonNull Exception exception) {
        return exception instanceof UnsupportedOperationException;
    }


    @Override
    public HandledException handle(@NonNull Exception exception) {
        return new HandledException(exception) {
            @Override
            public void recover() {
                new MaterialDialog.Builder(activityWeakReference.get())
                        .content(R.string.unsupported_operation_exception)
                        .positiveText("ok")
                        .show();
            }
        };
    }
}