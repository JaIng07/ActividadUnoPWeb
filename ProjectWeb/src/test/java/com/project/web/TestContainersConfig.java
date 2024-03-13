package com.project.web;

import org.testcontainers.containers.PostgreSQLContainer;

public class TestContainersConfig {
    PostgreSQLContainer<?> postgreSQLContainer() {
        return new PostgreSQLContainer<>("postgres:16.2");
    }
}
