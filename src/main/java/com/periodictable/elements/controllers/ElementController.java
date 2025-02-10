package com.periodictable.elements.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
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

    @ApiResponse(responseCode = "200", description = "Successful response")
    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    @GetMapping(value = "/elements", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Element> getElements() {
      return dbService.getElements();
    }

    @ApiResponse(responseCode = "200", description = "Successful response")
    @ApiResponse(responseCode = "404", description = "Element not found", content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    @GetMapping(value = "/elements/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ElementDetails getElement(@PathVariable int id) {
      return dbService.getElementById(id);
    }
}