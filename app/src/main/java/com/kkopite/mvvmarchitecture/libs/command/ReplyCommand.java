package com.kkopite.mvvmarchitecture.libs.command;

import io.reactivex.functions.Action;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;

/**
 * Created by kkopite on 2018/10/29.
 */

public class ReplyCommand<T> {

    private Action execute0;
    private Consumer<T> execute1;

    private BooleanSupplier canExecute0;

    public ReplyCommand(Action execute) {
        this.execute0 = execute;
    }


    public ReplyCommand(Consumer<T> execute) {
        this.execute1 = execute;
    }

    /**
     *
     * @param execute callback for event
     * @param canExecute0 if this function return true the action execute would be invoked! otherwise would't invoked!
     */
    public ReplyCommand(Action execute, BooleanSupplier canExecute0) {
        this.execute0 = execute;
        this.canExecute0 = canExecute0;
    }

    /**
     *
     * @param execute callback for event,this callback need a params
     * @param canExecute0 if this function return true the action execute would be invoked! otherwise would't invoked!
     */
    public ReplyCommand(Consumer<T> execute, BooleanSupplier canExecute0) {
        this.execute1 = execute;
        this.canExecute0 = canExecute0;
    }


    public void execute() {
        try {
            if (execute0 != null && canExecute0()) {
                execute0.run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean canExecute0() throws Exception {
        return canExecute0 == null || canExecute0.getAsBoolean();
    }

    public void execute(T parameter) {
        try {
            if (execute1 != null && canExecute0()) {
                execute1.accept(parameter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
