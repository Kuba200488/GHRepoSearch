package com.mobicubes.ghreposearch.domain.interactor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kuba on 10/03/2018.
 */

public abstract class BaseUseCase<P, R> {

    @NonNull
    private Disposable disposable = Disposables.empty();
    @Nullable
    private Observable<R> observable;

    public <O extends Observer<R> & Disposable> void execute(
            final P param,
            final O resultObserver
    ) {
        if (isExecuting()) {
            unsubscribe();
        }

        disposable = resultObserver;

        observable = buildObservable(param)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(() -> observable = null);

        observable.subscribe(resultObserver);
    }

    private boolean isExecuting() {
        return observable != null;
    }

    public void unsubscribe() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
            disposable = Disposables.empty();
        }
        observable = null;
    }

    protected abstract Observable<R> buildObservable(P param);
}
