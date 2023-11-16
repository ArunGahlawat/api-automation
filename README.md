## Maven multi module project for REST api automation

### Sample report
https://arungahlawat.github.io/sample-report/test-report/index.html

### Pre-requisites
- Java 20+

### Installing dependencies
```
mvn clean compile install
```

### Running core module tests
```
mvn test
```

### Generating allure aggregate report for all modules
```
mvn site
```
- An aggregate report will be generated at `test-report/`
- Each module will have it's own independent report generated at `<module>/test-report/`
- Allure history and retry trends will be automatically copied to `allure-results` 
