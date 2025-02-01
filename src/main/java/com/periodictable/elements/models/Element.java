package com.periodictable.elements.models;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Element {
    public int atomicNumber;
    public int displayColumn;
    public int displayRow;
    public String element;
    public String symbol;
    public String type;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("AtomicNumber")
    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    @DynamoDbAttribute("DisplayColumn")
    public int getDisplayColumn() {
        return displayColumn;
    }

    public void setDisplayColumn(int displayColumn) {
        this.displayColumn = displayColumn;
    }

    @DynamoDbAttribute("DisplayRow")
    public int getDisplayRow() {
        return displayRow;
    }

    public void setDisplayRow(int displayRow) {
        this.displayRow = displayRow;
    }

    @DynamoDbAttribute("Element")
    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    @DynamoDbAttribute("Symbol")
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @DynamoDbAttribute("Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
