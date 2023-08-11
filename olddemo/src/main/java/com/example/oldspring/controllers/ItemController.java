package com.example.oldspring.controllers;

import com.example.oldspring.models.Item;
import com.example.oldspring.services.ItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public Collection<Item> all() {
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public Item one(@PathVariable String id) {
        return itemService.getOne(Integer.valueOf(id));
    }

    @PostMapping
    public Item create(@RequestBody String name) {
        return itemService.createOne(name);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return itemService.deleteOne(Integer.valueOf(id));
    }

    @PutMapping ("/{id}")
    public String update(@PathVariable String id, @RequestParam String name) {
        return itemService.updateOne(Integer.valueOf(id), name);
    }

}