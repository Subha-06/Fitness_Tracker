# CPSC233W22A3

# Author: Amasil Rahim Zihad & Fabiha Fairuzz Subha

# UCID: 30164830

## Version: 5.7

### This is fitness tracking program that allows the user to input their information and get back various results from that

### Running  the jar file

- We will need [Java](https://www.oracle.com/java/technologies/downloads/) installed.
  (Recommended version is at least java 17)

### To check the version:

- Type "java -version" in terminal or cmd which will show the version.  
  We will also need [javafx-sdk](https://gluonhq.com/products/javafx/).

- After downloading javafx-sdk and extract it and note the path where it was extracted.

- To run the program navigate to its folder and then open a terminal or cmd windows there and write the following:

- > java --module-path "javafx-sdk path here\lib" --add-modules javafx.controls,javafx.fxml -jar CPSC233W22A3.jar

- So if javafx-sdk is in "C:\Program Files\Java\" the cmd command code would be:

- > java --module-path "C:\Program Files\Java\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml -jar CPSC233W22A3.jar

- Or on macOS if javafx-sdk is in "/Library/Java/JavaVirtualMachines/" the terminal command would be:

- > java --module-path "/Library/Java/JavaVirtualMachines/javafx-sdk-18/lib" --add-modules javafx.controls,javafx.fxml -jar CPSC233W22A3.jar

## Features

- Can Add multiple users and view their information.
- Can read information of a user from a file.
- Can write to a file with user information.
- Can add the calorie burnt of a user and display the highest amount burnt in a day or total calorie lost for that user.
- Display the bmi or the weight status of the users.
- Allows the user to enter a certain weight goal and provide information on how much exercise is needed to reach that
  goal.