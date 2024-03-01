package com.desafio.resources;

import com.desafio.dtos.CreateTransferDTO;
import com.desafio.models.Transfer;
import com.desafio.services.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/transfers")
public class TransferResource {

    private final TransferService transferService;

    public TransferResource(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping()
    public ArrayList<Transfer> getAll() {
        return this.transferService.getAll();
    }

    @GetMapping("/{id}")
    public Transfer getOneById(@PathVariable("id") Long id) {
        return this.transferService.getOneById(id);
    }

    @PostMapping
    public Transfer create(@RequestBody CreateTransferDTO transferDto) {
        return this.transferService.create(transferDto);
    }

    @PutMapping("/{id}")
    public Transfer update(@PathVariable("id") Long id, @RequestBody Transfer transfer) {
        return this.transferService.update(id, transfer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        this.transferService.delete(id);
    }
}