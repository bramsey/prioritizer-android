package com.billiamram.prioritizer;

import com.billiamram.prioritizer.domain.ItemSet;
import com.billiamram.prioritizer.domain.ItemSetRepository;

import java.util.List;

public class ItemSetListPresenter {
    private View mView;
    private ItemSetRepository itemSetRepository;

    public ItemSetListPresenter(ItemSetRepository itemSetRepository) {
        this.itemSetRepository = itemSetRepository;
    }


    public void viewLoaded(View view) {
        mView = view;
        mView.showItemSets(itemSetRepository.findAll());
    }

    public void viewUnloaded(View view) {
        if (mView == view) mView = null;
    }

    public interface View {
        void showItemSets(List<ItemSet> itemSets);
    }
}
