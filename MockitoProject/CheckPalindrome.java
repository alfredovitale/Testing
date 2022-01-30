package de.vitale.mockitoproject;

public class CheckPalindrome {
    PalindromeLib palindromeLib;

    //Here we have added dependency for Palindrome class
    public CheckPalindrome(PalindromeLib palindromeLib) {
        this.palindromeLib = palindromeLib;
    }

    //Here using dependency calling actual method
    public Boolean validatePalindrome(String input) {
       return palindromeLib.isPalindrome(input);
    }
}
