package com.billiamram.prioritizer;

import com.billiamram.prioritizer.domain.Item;
import com.billiamram.prioritizer.domain.ItemSet;
import com.billiamram.prioritizer.domain.ItemSetRepository;

import java.util.Set;

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
        mView.showItems(mItemSet.items);
    }

    public void viewUnloaded(View view) {
        if (mView == view) mView = null;
    }

    public interface View {
        void showItemSetName(String name);

        void showItems(Set<Item> items);
    }
}
