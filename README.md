
Phone Number Interpreter
The Phone Number Interpreter is a Java project that interprets a sequence of natural numbers as potential valid phone numbers. It takes into account ambiguities such as when two or three numbers could be combined or taken as individual numbers and validates the resultant interpretations against specified valid phone number patterns.

Features:
GUI based interpretation using Swing.
Console application for those who prefer command-line interaction.
Validates the interpreted phone numbers against a pre-defined format.
Handles ambiguity of sequences.
Uses Maven for dependency management and build automation.
Getting Started:
Prerequisites:
Ensure you have Java JDK 11 and Maven installed on your machine.
Clone the repository:
Copy code
git clone https://github.com/[your-github-username]/Phone-Number-Interpreter.git
Running the Application in Eclipse:
Importing the Project:
Open Eclipse.
Click on File -> Import.
Choose Maven -> Existing Maven Projects.
Browse to the directory where you cloned the repository and select the project to import.
Running the GUI Version:

In the Package Explorer, navigate to com.company.phonenumberinterpretation.PhoneNumberInterpreterGUI.
Right-click on the file and choose Run As -> Java Application.
Running the Console Version:

Navigate to com.company.phonenumberinterpretation.PhoneNumberInterpreter in the Package Explorer.
Right-click on the file and choose Run As -> Java Application.
In either mode, you'll be prompted to enter a sequence of natural numbers. In the console mode, these should be separated by spaces. In GUI mode, enter the numbers in the input area and press the "Interpret" button.

Understanding the Output:
The program will interpret the sequence of numbers you provide and output possible valid phone number interpretations. Each interpretation is also checked against specific validation criteria and marked as VALID or INVALID.

Maven Dependencies:
JUnit (4.12): Used for unit testing.
