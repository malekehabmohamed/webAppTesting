# Automation Tests for E-commerce Website

This repository contains a set of automated test cases for an e-commerce website. The tests are written in Java using TestNG and Selenium WebDriver. The goal of these tests is to validate various scenarios related to purchasing a book from the website.

## Test Cases

### 1. Purchase Thinking in HTML Book - Directly Go to Cart (Happy Scenario)

- Open the home page.
- Verify the book details on the home page.
- Add the book to the cart.
- Verify the product details in the cart.
- Proceed to checkout.
- Fill in billing details.
- Place the order.
- Verify the order is placed successfully.

### 2. Purchase Thinking in HTML Book - Go to Product First, Direct Bank Transfer

- Open the home page.
- Navigate to the product page for the Thinking in HTML book.
- Verify the product details on the product page.
- Add the book to the cart.
- Verify the product details in the cart.
- Proceed to checkout.
- Fill in billing details.
- Pay by direct bank transfer.
- Place the order.
- Verify the order is placed successfully.

### 3. Purchase Thinking in HTML Book - Go to Product First, Check Payments

- Open the home page.
- Navigate to the product page for the Thinking in HTML book.
- Verify the product details on the product page.
- Add the book to the cart.
- Verify the product details in the cart.
- Proceed to checkout.
- Fill in billing details.
- Check available payment methods.
- Place the order.
- Verify the order is placed successfully.

### 4. Purchase Thinking in HTML Book - Go to Product First, Cash on Delivery

- Open the home page.
- Navigate to the product page for the Thinking in HTML book.
- Verify the product details on the product page.
- Add the book to the cart.
- Verify the product details in the cart.
- Proceed to checkout.
- Fill in billing details.
- Pay by cash on delivery.
- Place the order.
- Verify the order is placed successfully.

### 5. Purchase Thinking in HTML Book - Go to Product First, Paypal Express Checkout

- Open the home page.
- Navigate to the product page for the Thinking in HTML book.
- Verify the product details on the product page.
- Add the book to the cart.
- Verify the product details in the cart.
- Proceed to checkout.
- Fill in billing details.
- Pay using Paypal Express Checkout.
- Place the order.
- Verify the order is placed successfully.

## Test Environment

- URL: https://practice.automationtesting.in/
- Browser: Microsoft Edge
- Added Class to accept all browsers (Chrome, Firefox ..)

## Tools and Frameworks

- Java
- TestNG
- Selenium WebDriver
- ExtentReports

## How to Run the Tests

1. Clone the repository.
2. Open the project in IntelliJ IDEA or any preferred Java IDE.
3. Set up the necessary dependencies (TestNG, Selenium WebDriver).
4. Run the test cases using TestNG.
