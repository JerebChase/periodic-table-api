package com.periodictable.elements.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.periodictable.elements.models.Element;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDbConfig {

        @Value("${aws.dynamodb.region}")
        private Region awsRegion;

        @Value("${aws.dynamodb.accessKey}")
        private String dynamodbAccessKey;

        @Value("${aws.dynamodb.secretKey}")
        private String dynamodbSecretKey;

        @Bean
        public DynamoDbClient dynamoDbClient() {
                return DynamoDbClient.builder()
                                .region(awsRegion)
                                .credentialsProvider(StaticCredentialsProvider.create(
                                                AwsBasicCredentials.create(dynamodbAccessKey, dynamodbSecretKey)))
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
}