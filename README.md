# Selenium TestNG Automation Framework

This repository contains a Selenium-based test automation framework integrated with TestNG for running automated tests. The project is designed to test the functionalities of an e-commerce application. It includes utilities for managing test execution, generating reports, and taking screenshots in case of failures.

## **Project Structure**

```
selenium-testng-maven/
|-- e-commerce/
    |-- src/
        |-- main/
            |-- java/
                |-- com.support/
                    |-- baseTest/    # Base setup for tests
                    |-- listeners/   # TestNG listeners for reporting
                    |-- pageobjects/ # Page Object Model files
                    |-- utilities/   # Helper classes (e.g., ExtentManager)
        |-- test/
            |-- java/
                |-- com.test.testcases/ # Test cases
            |-- resources/              # Test data and configurations
    |-- target/ # Directory for generated artifacts like reports
|-- pom.xml   # Maven configuration file
|-- testng.xml # TestNG configuration file
|-- Jenkinsfile # CI/CD pipeline configuration
|-- README.md # Documentation
```

## **Technologies Used**
- **Programming Language:** Java
- **Testing Framework:** TestNG
- **Build Tool:** Maven
- **Reporting Tool:** Extent Reports
- **Version Control:** Git
- **CI/CD Tool:** Jenkins

## **Pre-requisites**
- **Java**: Ensure JDK 8 or above is installed.
- **Maven**: Ensure Maven is installed and configured.
- **ChromeDriver**: Download and set up the correct version of ChromeDriver that matches your browser version.
- **Jenkins**: Installed and configured to execute builds.
- **Git**: Repository cloned locally or available in Jenkins.

## **Setup Instructions**

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/rshah160487/selenium-testng-maven.git
   cd selenium-testng-maven/e-commerce
   ```

2. **Configure Maven:**
   Ensure Maven is properly installed and the `pom.xml` dependencies are resolved.
   ```bash
   mvn clean install
   ```

3. **Run Tests Locally:**
   To execute tests locally, use the following Maven command:
   ```bash
   mvn test -f pom.xml
   ```

4. **Generate Reports:**
   To generate Extent Reports, run:
   ```bash
   mvn site -f pom.xml
   ```

   The report will be generated under:
   ```
   target/extent-reports/ExtentReport.html
   ```

## **Jenkins Integration**

### **Jenkinsfile Overview**
The `Jenkinsfile` contains the CI/CD pipeline configuration with the following stages:
1. **Setup**: Creates directories for reports and screenshots.
2. **Build**: Compiles the project.
3. **Test**: Runs the TestNG test cases.
4. **Generate Reports**: Generates Extent Reports.
5. **Archive Artifacts**: Archives the test reports and screenshots for analysis.

### **Jenkins Configuration**
1. **Install Plugins**:
    - **HTML Publisher**: For publishing reports.
    - **Maven Integration**: For running Maven builds.

2. **Pipeline Configuration**:
    - Script Path: Ensure the `Jenkinsfile` path is correctly set (e.g., `e-commerce/Jenkinsfile`).

3. **Git Configuration**:
    - Set up the repository URL and branch in the Jenkins pipeline.

4. **Build Execution**:
    - Trigger a build in Jenkins. Ensure `ChromeDriver` and other dependencies are correctly configured on the Jenkins server.

## **Key Features**
- **Page Object Model (POM)**: Enhances maintainability and readability of tests.
- **TestNG Listeners**: Enables better control over test execution and reporting.
- **Extent Reports**: Generates detailed HTML reports for test results.
- **Screenshots on Failure**: Captures screenshots for failed test cases.

## **Extent Reports**
Reports are generated in the following directory:
```
target/extent-reports/ExtentReport.html
```
These reports provide detailed insights into test execution, including pass/fail status, execution time, and screenshots for failed tests.

## **Common Issues**
1. **ChromeDriver Not Found**:
   Ensure `chromedriver` is added to the `PATH` environment variable and matches the installed Chrome version.

2. **Failed to Generate Reports**:
   Verify that the `mvn site` command runs successfully and generates the report.

3. **Jenkins Pipeline Errors**:
    - Check that the `Jenkinsfile` is correctly configured for your environment.
    - Ensure all environment variables and file paths are accurate.

## **Contributing**
1. Fork the repository.
2. Create a feature branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit your changes and push to your forked repository.
4. Create a pull request to the `main` branch.

## **Contact**
For issues or contributions, please create a GitHub issue or contact the repository owner.

---

