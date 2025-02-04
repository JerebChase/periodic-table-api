package com.periodictable.elements.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.periodictable.elements.models.Element;
import com.periodictable.elements.models.ElementDetails;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDbConfig {

        @Value("${aws.dynamodb.region}")
        private Region awsRegion;

        @Bean
        public DynamoDbClient dynamoDbClient() {
                return DynamoDbClient.builder()
                                .region(awsRegion)
                                .credentialsProvider(DefaultCredentialsProvider.create())
                                .build();
        }

        @Bean
        public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient) {
                return DynamoDbEnhancedClient.builder()
                                .dynamoDbClient(dynamoDbClient)
                                .build();
        }

        @Bean
        public TableSchema<Element> elementTableSchema() {
                return TableSchema.fromBean(Element.class);
        }

        @Bean
        public TableSchema<ElementDetails> elementDetailsTableSchema() {
                return TableSchema.fromBean(ElementDetails.class);
        }
}