package de.vitale.mockitoproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CheckPalindromeTest {

    @Test
    public void testPalindromeFalse() {

        //Mock the PalindromeLib class
        PalindromeLib palindromeLib = Mockito.mock(PalindromeLib.class);
        //Mock the PalindromeLib  class isPalindrome method
        Mockito.when(palindromeLib.isPalindrome("data")).thenReturn(false);
        //Create the CheckPalindrome class and pass  PalindromeLib as dependency.
        CheckPalindrome checkPalindrome = new CheckPalindrome(palindromeLib);
        //Assert the actual result.
        Assertions.assertEquals(false, checkPalindrome.validatePalindrome("data"));
    }

    @Test
    public void testIsPalindromeTrue() {
        //Mock the PalindromeLib class
        PalindromeLib palindromeLib = Mockito.mock(PalindromeLib.class);
        //Mock the PalindromeLib  class isPalindrome method
        Mockito.when(palindromeLib.isPalindrome("aba")).thenReturn(true);
        //Create the CheckPalindrome class and pass  PalindromeLib as dependency.
        CheckPalindrome checkPalindrome = new CheckPalindrome(palindromeLib);
        //Assert the actual result.
        Assertions.assertEquals(true, checkPalindrome.validatePalindrome("aba"));
    }

}
