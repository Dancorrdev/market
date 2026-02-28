package com.dancorrdev.market.web.controller;

import com.dancorrdev.market.domain.Purchase;
import com.dancorrdev.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getPurchases() {
        return new ResponseEntity<>(purchaseService.getAllPurchases(), HttpStatus.OK) ;
    }

    @GetMapping("client/{id}")
    public ResponseEntity<List<Purchase>> getAllPurchasesByClientId(@PathVariable("id") String clientId) {
        return purchaseService.getPurchasesByClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }

}
