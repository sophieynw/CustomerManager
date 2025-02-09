
# Customer Manager - Spring Boot App

A simple CRUD application for adding, updating, viewing and deleting customers.


## Run Locally

Clone the project

```bash
  git clone https://github.com/sophieynw/spring_customer_manager.git
```

Go to the project directory

```bash
  cd /spring_customer_manager
```

Install dependencies

```bash
  mvn clean install
```

Start the server

```bash
  mvn spring-boot:run
```

## Development

To access the h2 console, uncomment the following lines in src/main/resources/application.properties
```
# spring.h2.console.enabled=true
# spring.datasource.url=jdbc:h2:mem:testdb
```
