# Snapper Backend Technical Interview

The expected time allocation for this test is between 1.5-2hours, please do not invest more time then this.

### Getting Started
This project has been auto generated by start.spring.io and then modified to have a basic structure stubbed out.\
This project uses Spring Boot 2 and Java 17.\
Please check this project out from Github and complete the requirements as outlined in this README.md file.\
Please commit and push all your work as you go. 

### Contact
If you have any questions please email Kieran with the subject: Snapper Backend Technical Interview\
*Note: may not reply outside of business hours*

### Scenario
When people need cash, they often use an ATM to withdraw money from their bank account. \
After a user has entered their card into the ATM, authenticated and requested to withdraw a valid amount of money in their account, a variety of bank notes are returned.

You have been asked to set up an ATM server which implements a new algorithm for determining what notes the user will receive.

### Create an ATM Service
You will create a service in the class ATMService to return specific notes when a user enters their required amount into an ATM.\
The service should have one parameter, the amount of money a user has entered.\
The service should return which notes the user will receive in a format that is easy to understand.

### Assumptions
* The ATM is using NZD and valid notes are: 5, 10, 20, 50, 100
* The user will always have enough money in their account to get any amount of cash out
* The ATM can be assumed to have infinite amount of all notes

### Restrictions
The response must never provide notes which sum an amount greater then what was asked for by the user.

### Primary Requirement: Unique Notes
The response must contain as many unique notes as possible

### Secondary Requirement: Minimal Notes
After satisfying the primary requirement, the response must return as few notes as possible

### Create an API 
Now that we have a service set up to handle the ATM functionality we want to make this available through an API\
Set up a RESTful API endpoint in the ATMController class.
This endpoint should handle a http request the ATM Server, pass on the work to the service method you have created in the ATMService class, then return the response back over http