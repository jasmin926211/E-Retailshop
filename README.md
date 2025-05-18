# E-Retail Shop System (Java CLI Application)

This is a command-line based Java application that simulates an e-retail shop system. It includes core functionalities such as product management, cart operations, order processing, and flexible payment strategies using the **Strategy Pattern**. The system demonstrates object-oriented principles and is structured for easy future expansion.

## Requirements

- Java Development Kit (JDK) 11 or higher
- IDE such as **NetBeans**, **IntelliJ IDEA**, or **Eclipse**
- Alternatively, terminal/command prompt for compilation and execution

## Features

- Command-Line Interface (CLI) based interaction
- Core classes: `Cart`, `Order`, `Product`, `Payment`
- Uses **Strategy Pattern** for payment method flexibility
- Strong error handling and user input validation
- Modular and maintainable code with inline comments and Javadoc

## Running the Project in NetBeans

Follow these steps to run the application using **NetBeans**:

1. **Open NetBeans**  
   Launch NetBeans and go to:  
   `File > Open Project`, then navigate to and select your project folder.

2. **Set the Main Class**

   - Right-click on the project in the Project Explorer
   - Select: `Properties > Run`
   - Set the **Main Class** to: `ERetailShop.java`  
     _(Ensure this file contains the `public static void main(String[] args)` method.)_

3. **Clean and Build the Project**

   - Right-click on the project
   - Select: `Clean and Build`  
     This will compile your source files and package them if needed.

4. **Run the Project**
   - Right-click on the project
   - Select: `Run`  
     The CLI interface will launch in the **NetBeans Output Console**.

## Project Structure
