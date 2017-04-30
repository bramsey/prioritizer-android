package com.billiamram.prioritizer;

import com.billiamram.prioritizer.domain.ItemSet;
import com.billiamram.prioritizer.domain.ItemSetRepository;

import java.util.List;

public class ItemSetListPresenter {
    private View mView;
    private ItemSetRepository itemSetRepository;
    private List<ItemSet> itemSets;

    public ItemSetListPresenter(ItemSetRepository itemSetRepository) {
        this.itemSetRepository = itemSetRepository;
    }

    public void viewLoaded(View view) {
        mView = view;
        itemSets = itemSetRepository.findAll();
        mView.showItemSets(itemSets);
    }

    public void viewUnloaded(View view) {
        if (mView == view) mView = null;
    }

    public void itemSetSelected(int index) {
        mView.navigateToItemSet(itemSets.get(index).id);
    }

    public interface View {
        void showItemSets(List<ItemSet> itemSets);

        void navigateToItemSet(String itemSetId);
    }
}
