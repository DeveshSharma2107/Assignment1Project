
Feature: An E-commerce  Project candere Homepage validation

Background: navigation to application base Url
				#	Given User opened the browser

@TitleValidation
		Scenario: user is able to open the browser, navigate to the URL and validate the title
		#	Given User opened the browser
			Given User navigated to the home Application url
			When title page is displayed
			Then page title is validated as "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
			
			
@SearchProduct
		Scenario: user is able to open the browser,navigate to the Url and Search for the product
		#	Given user is able to open the browser
			Given navigate to the application Url
			When user search for the product "majestic solitaire diamond ring"
			Then product is displayed as searched result "majestic solitaire diamond ring"
			
@SelectProductSize
		Scenario: user is able to open the browser,navigate to the Url validate the title,and select ring size from dropdown
		#	Given user is able to open the browser
			Given navigate to the application Url
			When user search for the product as "majestic solitaire diamond ring"
			And product is displayed as  "majestic solitaire diamond ring"
			Then user click on the product and title should contain "Majestic Solitaire Diamond Ring"
			And select ring size from dropdown as "20"
			And again select the ring size from the drop down as "17" and popup should be displayed as "Price updated"
			
			
@AboutusOptionList
		Scenario: user is able to open the browser,navigate to the Url ,scroll down to the about us section and Validate the footer about us section
	#	Given User is able to open the browser
		Given navigate to the application Url
		When User scroll down to the footer about us section
		Then under footer section following about us options will be available
		|About Our Company   |
		|Terms and Conditions|
		|Privacy Policy      |
		|FAQ                 |
		|Offers T&Cs         |
		|Customer Reviews    |
		
		
@MultisearchFollowUs
		Scenario Outline: user is able to open the browser,navigate to the Url,Scroll down to the footer section and opened every social media handle in new tab
	#	Given User is able to open the browser
		Given navigate to the application Url
		When user scroll down to the footer follow us section
		And User click on follows us section "<Social_media_handle_Name>"
		Then new Tab should be opened containing social media handle name "<Social_Media_Handle_Name>"
		 Examples: 
      | Social_media_handle_Name 		|	Social_Media_Handle_Name  |
      | facebook       							| facebook       						|
      | Instagram     							| Instagram   							|
      | twitter     								| twitter   								|		 
		
		
			

