package com.periodictable.elements.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.periodictable.elements.models.Element;

@RestController
public class ElementController {
    @GetMapping("/elements")
    public List<Element> greeting() {
        return new ArrayList<Element>();
    }

    @GetMapping("/elements")
    public Element greeting(@RequestParam(value = "atomicNumber", defaultValue = "1") Number atomicNumber) {
        return new Element();
    }
}