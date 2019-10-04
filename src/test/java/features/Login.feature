Feature: Application Login


Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And navigate to the "http://qaclickacademy.com" site 
And Click on Login link in homepage to land on secure sign-in page 
When User enters valid <username> and <password> and logs in
Then Verify that the User is successfully logged in
And close browsers 

  
  
  Examples:
  | username  | password | 
  | test99@gmail.com | 123456 | 
  | test123@gmail.com | 654321 | 






