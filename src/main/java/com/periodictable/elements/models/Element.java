package com.periodictable.elements.models;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Element {
    public int atomicNumber;
    public float atomicRadius;
    public float atomicWeight;
    public float boilingPointKelvin;
    public float density;
    public String discoverer;
    public int displayColumn;
    public int displayRow;
    public String electronConfiguration;
    public float electronegativity;
    public String element;
    public float firstIonizationPotential;
    public int group;
    public float ionicRadius;
    public int isotopes;
    public float meltingPointKelvin;
    public String mostStableCrystal;
    public int period;
    public String phase;
    public float specificHeatCapacity;
    public String symbol;
    public String type;
    public int yearOfDiscovery;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("AtomicNumber")
    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    @DynamoDbAttribute("AtomicRadius")
    public float getAtomicRadius() {
        return atomicRadius;
    }

    public void setAtomicRadius(float atomicRadius) {
        this.atomicRadius = atomicRadius;
    }

    @DynamoDbAttribute("AtomicWeight")
    public float getAtomicWeight() {
        return atomicWeight;
    }

    public void setAtomicWeight(float atomicWeight) {
        this.atomicWeight = atomicWeight;
    }

    @DynamoDbAttribute("BoilingPointKelvin")
    public float getBoilingPointKelvin() {
        return boilingPointKelvin;
    }

    public void setBoilingPointKelvin(float boilingPointKelvin) {
        this.boilingPointKelvin = boilingPointKelvin;
    }

    @DynamoDbAttribute("Density")
    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    @DynamoDbAttribute("Discoverer")
    public String getDiscoverer() {
        return discoverer;
    }

    public void setDiscoverer(String discoverer) {
        this.discoverer = discoverer;
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

    @DynamoDbAttribute("ElectronConfiguration")
    public String getElectronConfiguration() {
        return electronConfiguration;
    }

    public void setElectronConfiguration(String electronConfiguration) {
        this.electronConfiguration = electronConfiguration;
    }

    @DynamoDbAttribute("Electronegativity")
    public float getElectronegativity() {
        return electronegativity;
    }

    public void setElectronegativity(float electronegativity) {
        this.electronegativity = electronegativity;
    }

    @DynamoDbAttribute("Element")
    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    @DynamoDbAttribute("FirstIonizationPotential")
    public float getFirstIonizationPotential() {
        return firstIonizationPotential;
    }

    public void setFirstIonizationPotential(float firstIonizationPotential) {
        this.firstIonizationPotential = firstIonizationPotential;
    }

    @DynamoDbAttribute("Group")
    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @DynamoDbAttribute("IonicRadius")
    public float getIonicRadius() {
        return ionicRadius;
    }

    public void setIonicRadius(float ionicRadius) {
        this.ionicRadius = ionicRadius;
    }

    @DynamoDbAttribute("Isotopes")
    public int getIsotopes() {
        return isotopes;
    }

    public void setIsotopes(int isotopes) {
        this.isotopes = isotopes;
    }

    @DynamoDbAttribute("MeltingPointKelvin")
    public float getMeltingPointKelvin() {
        return meltingPointKelvin;
    }

    public void setMeltingPointKelvin(float meltingPointKelvin) {
        this.meltingPointKelvin = meltingPointKelvin;
    }

    @DynamoDbAttribute("MostStableCrystal")
    public String getMostStableCrystal() {
        return mostStableCrystal;
    }

    public void setMostStableCrystal(String mostStableCrystal) {
        this.mostStableCrystal = mostStableCrystal;
    }

    @DynamoDbAttribute("Period")
    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @DynamoDbAttribute("Phase")
    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    @DynamoDbAttribute("SpecificHeatCapacity")
    public float getSpecificHeatCapacity() {
        return specificHeatCapacity;
    }

    public void setSpecificHeatCapacity(float specificHeatCapacity) {
        this.specificHeatCapacity = specificHeatCapacity;
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

    @DynamoDbAttribute("YearOfDiscovery")
    public int getYearOfDiscovery() {
        return yearOfDiscovery;
    }

    public void setYearOfDiscovery(int yearOfDiscovery) {
        this.yearOfDiscovery = yearOfDiscovery;
    }
}
