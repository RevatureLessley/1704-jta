# Feature is the first keyword in a feature file, which simply designates it as such
Feature: Adding functionality to our calculator

  # Use the Background keyword to create pre-conditinons that run BEFORE EVERY scenario in a feature file.
  # This is useful for situations where we have multiple scenarios in a feature file
  # that has a specific set up scenario to run before hand.
  # Think of TestNg's or jUnit's @BeforeMethod or @Before.
  Background: 
    Given a user powers up the calculator

  # Scenario keyword to designate a single test.
  # This is a tag. Tags are just like groups in TestNG.
  @smoke
  Scenario: A user adds 2 to 3
    When a user adds 2 and 3
    Then a user sees 5

  # Scenario Outline is used for parameterized tests.
  # It MUST be paired with an examples table.
  @regression @addition
  Scenario Outline: A user adds two numbers
    When a user adds <num1> and <num2>
    Then a user sees <sum>

    # Examples is in tabular format where each row provides the arguments to our Scenario Outline.
    Examples: 
      | num1 | num2 | sum |
      |    1 |    5 |   6 |
      |   10 |   20 |  30 |
      |   15 |    5 |  20 |

  @regression @subtraction
  Scenario Outline: A user subtracts two numbers
    When a user subtracts <a> from <b>
    Then a user sees <c>

    Examples: 
      | a   | b  | c  |
      |  10 |  5 |  5 |
      |  25 | 25 |  0 |
      | 100 |  1 | 99 |

  @regression @multiplication
  Scenario Outline: A user multiplies two numbers
    When a user multiplies <x> and <y>
    Then a user sees <z>

    Examples: 
      | x   | y  | z   |
      |  10 |  5 |  50 |
      |  12 | 12 | 144 |
      | 100 |  1 | 100 |
      
  @regression @divide
  Scenario Outline: A user divides two numbers
  	When a user divides <p> by <q>
  	Then a user sees <quot>
  	
  	Examples:
  		|p|q|quot|
  		|15|3|5|
  		|20|9|2|
  		|121|12|10|
  		
  @regression @divide
  Scenario Outline: A user divides by zero
  	When a user divides <num> by 0
  	Then an IllegalArgumentException is thrown
  	
  	Examples:
  		|num|
  		|1|
  		|32|
  		|4|
      
