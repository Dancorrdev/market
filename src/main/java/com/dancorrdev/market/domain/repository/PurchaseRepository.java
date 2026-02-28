package com.dancorrdev.market.domain.repository;

import com.dancorrdev.market.domain.Purchase;
import com.dancorrdev.market.domain.PurchaseItem;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<PurchaseItem> getAll();
    Optional<List<PurchaseItem>> getById(Integer id);
    Purchase save(Purchase purchase);
}
