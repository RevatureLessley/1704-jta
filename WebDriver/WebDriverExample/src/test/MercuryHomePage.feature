#First line in any Cucumber file is the Feature keyword, simply designates it as such 
Feature: Logging into Mercuty Tours


	#Backgrounds provide a set of preconditions for every Scenario
	Background:
		Given a user opens a web browser
		And navigates to the Mercury Tours website 
		
	#Scenario outlines are used to parameterize Scenarios
	Scenario Outline:
		When a user inputs their "<username>" and "<password>"
		And clicks the sign in button
		Then a user sees the Flight Reservation Page
		Given <num> passengers depart from "<departure>" 
		And the passengers leave "<fromMonth>" <fromDay>
		And the passengers arrive in "<arrival>"
		But the passengers return "<toMonth>" <toDay>
		When the passengers choose "<flightType>" on "<airline>"
		Then the passengers see the proper information
		
		#Examples table is used to provide the parameters to the Scenario Outline, where each row 
		#runs a new Scenario
		Examples:
			|username|password|num|departure|fromMonth|fromDay|arrival|toMonth|toDay|flightType|airline|
			|mercury|mercury|2|Seattle|June|6|Frankfurt|July|4|First class|Pangea Airlines|
			|tropicana|tropicana|3|London|November|13|New York|December|25|Economy class|Unified Airlines|
			

		
		
		
		