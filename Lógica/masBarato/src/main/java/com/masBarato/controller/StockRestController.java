package com.masBarato.masBarato.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masBarato.masBarato.dto.StockDto;
import com.masBarato.masBarato.model.classes.Stock;
import com.masBarato.masBarato.service.useCase.Stock.IStockFindInteractor;
import com.masBarato.masBarato.service.useCase.Stock.IStockPostInteractor;
import com.masBarato.masBarato.service.useCase.Stock.IStockPutInteractor;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stock")
public class StockRestController {
    private final IStockFindInteractor findInteractor;
    private final IStockPostInteractor postInteractor;
    private final IStockPutInteractor putInteractor;

    @GetMapping("/{id}")
    public ResponseEntity<StockDto> findById(@PathVariable Integer id) {
        Optional<Stock> stock = Optional.ofNullable(findInteractor.findById(id));
        if (stock.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(StockDto.fromDomain(stock.get()));
    }

    @PostMapping("")
    public boolean create(@RequestBody StockDto dto) {
        Stock stock = StockDto.toDomain(dto);
        return postInteractor.newStock(stock);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Integer id, @RequestBody StockDto dto) {
        Stock stock = StockDto.toDomain(dto);
        return putInteractor.updateStock(id, stock);
    }
}