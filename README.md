Selenium Automation Framework

Overview
This project is an automation testing framework built using Java, Selenium WebDriver, TestNG, and Maven.  
The framework follows the Page Object Model (POM) design pattern for better code maintenance and reusability.

Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- Extent Reports

Framework Features
1. Page Object Model (POM)
2. TestNG for test execution
3. Maven for dependency management
4. Extent Reports for reporting
5. Retry Analyzer for failed test cases
6. Base Test setup for reusable browser configuration
7. Utility classes for reading test data
8. Global properties file for environment configuration
9. Parallel test execution support

Project Structure
src/main/java
- PageObjects
  - LandingPage.java
  - Register.java
  - LoginToConfirmOrder.java
  - ProductDetails.java
  - CartPage.java
  - OrderConfirmation.java
  - CardDetails.java
  - AccountCreatedConfirmation.java
  - AccountDeleted.java

- resources
  - ExtentReportTesting.java
  - GlobalData.Properties

src/test/java
- AutomationExercise
  - StandAlone.java
  - StandAlone2.java
  - ErrorValidation.java

- data
  - DataReader.java
  - registerData.json

- testComponents
  - BaseTest.java
  - Listeners.java
  - RetryAnalyzer.java

Test Scenarios Covered
- User Registration
- Login Validation
- Product Search
- Add Product to Cart
- Cart Verification
- Order Placement
- Payment Details
- Account Creation Verification
- Account Deletion Verification
- Error Message Validation

Run the Project
Use the below command to run all tests:

```bash
mvn test
