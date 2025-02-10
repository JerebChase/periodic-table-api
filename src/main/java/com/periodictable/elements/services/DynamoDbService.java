package com.periodictable.elements.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.periodictable.elements.models.Element;
import com.periodictable.elements.models.ElementDetails;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;

@Service
public class DynamoDbService {
  @Value("${aws.dynamodb.tablename}")
  private String table;

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
    DynamoDbTable<Element> elementTable = dynamoDbEnhancedClient.table(table, elementTableSchema);
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

  public ElementDetails getElementById(int id) {
    DynamoDbTable<ElementDetails> elementTable = dynamoDbEnhancedClient.table(table, elementDetailsTableSchema);
    var element = elementTable.getItem(r -> r.key(k -> k.partitionValue(id)));
    if (element == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Element not found");
    }
    return element;
  }
}
