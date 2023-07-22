# Employee Management Microservice Project


## Overview

The Employee Management Microservice Project is a comprehensive solution for efficiently managing employee records. It comprises three microservices: Department Service, Employee Service, and Organization Service. This project is designed to handle various aspects of employee management, including department details, employee information, and organization details. The microservices communicate with each other using a web client, and an API gateway is implemented to route client requests.

## Microservices

### 1. Department Service

The Department Service is responsible for managing department-related information. It stores the following details:

- **`id`**: Unique identifier for the department.
- **`departmentname`**: Name of the department.
- **`departmentdescription`**: Description of the department.
- **`departmentcode`**: Code representing the department.

### 2. Employee Service

The Employee Service handles the management of employee data. It stores the following information:

- **`id`**: Unique identifier for the employee.
- **`firstname`**: First name of the employee.
- **`lastname`**: Last name of the employee.
- **`email`**: Email address of the employee.

### 3. Organization Service

The Organization Service is responsible for storing organization-related details. It stores the following information:

- **`organizationname`**: Name of the organization.
- **`organizationcode`**: Code representing the organization.
- **`organizationdescription`**: Description of the organization.

## Distributed Tracing

The project supports distributed tracing using Zipkin and Spring Sleuth. Distributed tracing helps in tracking requests as they flow through different microservices, enabling better visibility and understanding of the system's behavior.

## Architecture

The architecture of the Employee Management microservice project consists of the following components:

- **Microservices**: Department Service, Employee Service, and Organization Service are individual microservices, each responsible for managing specific data.
- **Web Client Communication**: The microservices communicate with each other using a web client to exchange data and fulfill inter-service requests.
- **API Gateway**: The API Gateway is implemented to route client requests and provide a unified entry point to the microservices. It handles routing, load balancing, and can help in implementing security and authentication.
