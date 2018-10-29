package com.kkopite.mvvmarchitecture.libs.command;

import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Function;

/**
 * Created by kkopite on 2018/10/29.
 */

public class ResponseCommand<T, R> {

    private Function<T, R> execute1;

    private BooleanSupplier canExecute0;

    public ResponseCommand(Function<T, R> execute) {
        this.execute1 = execute;
    }


    public ResponseCommand(Function<T, R> execute, BooleanSupplier canExecute0) {
        this.execute1 = execute;
        this.canExecute0 = canExecute0;
    }

    private boolean canExecute0() throws Exception {
        if (canExecute0 == null) {
            return true;
        }
        return canExecute0.getAsBoolean();
    }

    public R execute(T parameter) {
        try {
            if (execute1 != null && canExecute0()) {
                return execute1.apply(parameter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
