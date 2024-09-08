package com.periodictable.elements.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.periodictable.elements.models.Element;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;

@Service
public class DynamoDbService {
    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;
    private final TableSchema<Element> elementTableSchema;

    @Autowired
    public DynamoDbService(DynamoDbEnhancedClient dynamoDbEnhancedClient, TableSchema<Element> elementTableSchema) {
        this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
        this.elementTableSchema = elementTableSchema;
    }

    public List<Element> getElements() {
        DynamoDbTable<Element> elementTable = dynamoDbEnhancedClient.table("Elements", elementTableSchema);
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

    public Element getElementById(int id) {
        DynamoDbTable<Element> elementTable = dynamoDbEnhancedClient.table("Elements", elementTableSchema);
        return elementTable.getItem(r -> r.key(k -> k.partitionValue(id)));
    }
}
