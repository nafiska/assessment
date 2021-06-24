Feature: Amazon Assessment Test

@UI
Scenario Outline: Verify User Able To Search Book & Add To Cart Successfully

	Given I Select Chrome Browser To Launch "<URL>" For Test Execution
	Then I Verify Amazon Home Page is Loaded Successfully
	When I Set Bookname as "<BookName>" in Search Text Field
	Then I Verify Price of Book as "47" from the Search Result
	When I Select First Option from Result
	Then I Verify Price of Book Price as "$47.49" After Selecting Book from Search Result
	When I Click On Add To Cart
	Then I Verify Price of Book Price as "$47.49" Before Proceed To Checkout in Cart Page

@UITest
Examples:
| URL                     | BookName								 |
| https://www.amazon.com/ | qa testing for beginners |