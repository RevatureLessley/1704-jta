package tests;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import exercises.CharacterSwap;
import exercises.Factorial;
import exercises.Fibonacci;
import exercises.Palindrome;
import exercises.ReverseString;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

public class ExerciseTest {
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Starting new test");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Test finished");
  }
  
  @Test(dataProvider="palindromes")
  public void PalindromeTest(String p) {
	  assertTrue(Palindrome.isPalindrome(p));
  }
  
  @Test(dataProvider="strings")
  public void ReverseStringTest(String r,String s) {
	  assertTrue(r.equals(ReverseString.reverseString(s)));
  }
  
  @Test(dataProvider="fibonacci")
  public void iterativeTest(int solution, int num) {
	  assertEquals(solution, Fibonacci.iterative(num));
  }
  
  @Test(dataProvider="fibonacci")
  public void recursiveTest(int solution,int num) {
	  assertEquals(solution,Fibonacci.recursive(num));
  }
  
  @Test(dataProvider="factorial")
  public void factorialTest(int solution,int num) {
	  assertEquals(solution,Factorial.factorial(num));
  }
  
  @Test(dataProvider="modify")
  public void modifyStringTest(String result, String s) {
	  assertTrue(result.equals(CharacterSwap.modifyString(s)));
  }
  
  @DataProvider(name="modify")
  public Object[][] getString(){
	  return new Object[][] {
		  new Object[] {"iw ll ai m","william"},
		  new Object[] {"na yd","andy"},
		  new Object[] {"ad nn y","danny"},
		  new Object[] {"it m","tim"},
		  new Object[] {"ep et r", "peter"},
	  };
  }
  
  @DataProvider(name="factorial")
  public Object[][] getFactorials(){
	  return new Object[][] {
		  new Object[] {0,0},
		  new Object[] {1,1},
		  new Object[] {2,2},
		  new Object[] {6,3},
		  new Object[] {24,4},
		  new Object[] {120,5},
		  new Object[] {720,6},
	  };
  }
  
  @DataProvider(name="fibonacci")
  public Object[][] getItertive(){
	  return new Object[][] {
		  new Object[] {0,0},
		  new Object[] {1,1},
		  new Object[] {1,2},
		  new Object[] {2,3},
		  new Object[] {3,4},
		  new Object[] {5,5},
		  new Object[] {8,6},
		  new Object[] {13,7},
		  new Object[] {21,8},
		  new Object[] {34,9},
		  new Object[] {55,10},
	  };
  }
  
  @DataProvider(name="strings")
  public Object[][] getStrings() {
	  return new Object[][] {
		  new Object[] {"ippississim","mississippi"},
		  new Object[] {"taob","boat"},
		  new Object[] {"elttob","bottle"},
		  new Object[] {"potelbat","tabletop"},
		  new Object[] {"rac","car"},
	  };
  }
  
  @DataProvider(name="palindromes")
  public Object[][] getPalindromes(){
	  return new Object[][] {
		  new Object[] {"racecar"},
		  new Object[] {"A Santa at Nasa"},
		  new Object[] {"A Santa dog lived as a devil God at NASA"},
		  new Object[] {"A tin mug for a jar of gum Nita"},
		  new Object[] {"Animal loots foliated detail of stool lamina"},
		  new Object[] {"Wo Nemo toss a lasso to me now"},
		  };
	  }
  }
