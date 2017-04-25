package com.billiamram.prioritizer;

public class Module {
    private static ItemSetListPresenter presenter;

    public static ItemSetListPresenter provideItemSetPresenter() {
        return presenter != null ? presenter : new ItemSetListPresenter(new DemoItemSetRepository());
    }
}
