package com.billiamram.prioritizer;

import com.billiamram.prioritizer.domain.ItemSetRepository;

public class Module {
    private static ItemSetListPresenter itemSetListPresenter;
    private static ItemSetDetailsPresenter itemSetDetailsPresenter;
    private static ItemSetRepository itemSetRepository = new DemoItemSetRepository();

    public static ItemSetListPresenter provideItemSetListPresenter() {
        return itemSetListPresenter != null ? itemSetListPresenter : new ItemSetListPresenter(itemSetRepository);
    }

    public static ItemSetDetailsPresenter provideItemSetDetailsPresenter() {
        return itemSetDetailsPresenter != null ? itemSetDetailsPresenter : new ItemSetDetailsPresenter(itemSetRepository);
    }
}
