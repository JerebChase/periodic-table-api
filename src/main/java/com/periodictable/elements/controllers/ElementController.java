package com.periodictable.elements.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.periodictable.elements.models.Element;
import com.periodictable.elements.models.ElementDetails;
import com.periodictable.elements.services.DynamoDbService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class ElementController {
    private final DynamoDbService dbService;

    @Autowired
    ElementController(DynamoDbService dbService) {
      this.dbService = dbService;
    }

    @ApiResponse(
        responseCode = "200",
        description = "Successful response",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Element[].class))
    )
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/elements")
    public List<Element> getElements() {
      return dbService.getElements();
    }

    @ApiResponse(
        responseCode = "200",
        description = "Successful response",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ElementDetails.class))
    )
    @ApiResponse(responseCode = "404", description = "Element not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/elements/{id}")
    public ElementDetails getElement(@PathVariable int id) {
      return dbService.getElementById(id);
    }
}