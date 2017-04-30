package com.billiamram.prioritizer;

import com.billiamram.prioritizer.domain.ItemSet;
import com.billiamram.prioritizer.domain.ItemSetRepository;

public class ItemSetDetailsPresenter {

    private View mView;
    private ItemSetRepository itemSetRepository;
    private ItemSet mItemSet;

    public ItemSetDetailsPresenter(ItemSetRepository itemSetRepository) {
        this.itemSetRepository = itemSetRepository;
    }

    public void viewLoaded(View view, String itemSetId) {
        mView = view;
        mItemSet = itemSetRepository.findById(itemSetId);
        mView.showItemSetName(mItemSet.name);
    }

    public void viewUnloaded(View view) {
        if (mView == view) mView = null;
    }

    public interface View {
        void showItemSetName(String name);
    }
}
