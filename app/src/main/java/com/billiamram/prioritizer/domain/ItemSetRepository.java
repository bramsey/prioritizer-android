package com.billiamram.prioritizer.domain;

import java.util.List;

public interface ItemSetRepository {
    List<ItemSet> findAll();

    ItemSet findById(String id);
}
