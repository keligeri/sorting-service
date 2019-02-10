package com.practice.sortingservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "sorting.supported.names")
public class SortingName {

    private String fruits;
    private String numbers;
    private String colors;
}
