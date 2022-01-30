package de.vitale.mockitoproject;

public class PalindromeLib {

    // This method is taking a string.
    // Once we receive the string we are checking if the string is palindrome or not
    // if that string is palindrome then return true else return false.

    public Boolean isPalindrome(String input) {
        StringBuilder sb = new StringBuilder();
        return sb.reverse().equals(input);
    }

}
