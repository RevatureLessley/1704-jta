
Feature: A user finds a flight

	@smoke
	Scenario:
		Given 2 passengers depart from "Seattle"
		And the passengers leave on "May" 24
		And the passengers arrive at "Frankfurt"
		But the passengers return "May" 29
		When the passengers choose "Business Class" on "Unified Airlines"
		Then the passengers see the proper information 