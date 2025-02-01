package com.periodictable.elements.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.periodictable.elements.models.Element;
import com.periodictable.elements.models.ElementDetails;
import com.periodictable.elements.services.DynamoDbService;

@RestController
public class ElementController {
    private final DynamoDbService dbService;

    @Autowired
    ElementController(DynamoDbService dbService) {
      this.dbService = dbService;
    }

    @GetMapping("/elements")
    public List<Element> getElements() {
      return dbService.getElements();
    }

    @GetMapping("/elements/{id}")
    public ElementDetails getElement(@PathVariable int id) {
      return dbService.getElementById(id);
    }
}