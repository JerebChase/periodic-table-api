package com.periodictable.elements.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.periodictable.elements.models.Element;
import com.periodictable.elements.models.ElementDetails;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;

@Service
public class DynamoDbService {
    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;
    private final TableSchema<Element> elementTableSchema;
    private final TableSchema<ElementDetails> elementDetailsTableSchema;

    @Autowired
    public DynamoDbService(
      DynamoDbEnhancedClient dynamoDbEnhancedClient, 
      TableSchema<Element> elementTableSchema,
      TableSchema<ElementDetails> elementDetailsTableSchema
    ) {
        this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
        this.elementTableSchema = elementTableSchema;
        this.elementDetailsTableSchema = elementDetailsTableSchema;
    }

    public List<Element> getElements() {
        DynamoDbTable<Element> elementTable = dynamoDbEnhancedClient.table("periodic-table-dev", elementTableSchema);
        List<Element> elements = new ArrayList<>();

        // Scan the table and add each customer to the list
        Iterator<Page<Element>> results = elementTable.scan(ScanEnhancedRequest.builder().consistentRead(true).build())
                .iterator();
        while (results.hasNext()) {
            Page<Element> page = results.next();
            elements.addAll(page.items());
        }

        return elements;
    }

    public ElementDetails getElementById(int id) throws ResourceNotFoundException {
        DynamoDbTable<ElementDetails> elementTable = dynamoDbEnhancedClient.table("periodic-table-dev", elementDetailsTableSchema);
        var element = elementTable.getItem(r -> r.key(k -> k.partitionValue(id)));
        if (element == null) {
            throw ResourceNotFoundException.builder().message("Element not found").build();
        }
        return element;
    }
}
