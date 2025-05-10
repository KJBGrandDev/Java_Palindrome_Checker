package Palindrome_Checker_OOP;

import java.util.ArrayList;
public class palindromeChecker {
    private final String input;
    private String isPalindrome;
    private final ArrayList<String> originalInput;
    private final ArrayList<String> reverseInput;

    public palindromeChecker(String input){
        this.input = input;
        this.originalInput = new ArrayList<>();
        this.reverseInput = new ArrayList<>();
    }

    public void inputRegexChecker(){
        String regEx = "^[a-zA-Z]+$";

        for(int i = 0; i < input.length(); i++){
            if(String.valueOf(input.charAt(i)).matches(regEx)){
                originalInput.add(String.valueOf(input.charAt(i)));
            }
        }
    }

    public void reverseRegexChecker(){
        String regEx = "^[a-zA-Z]+$";

        for(int i = input.length() - 1; i >= 0; i--){
            if(String.valueOf(input.charAt(i)).matches(regEx)){
                reverseInput.add(String.valueOf(input.charAt(i)));
            }
        }
    }

    public void isPalindrome() {

        try {
            if (input.matches("[0-9]*")) {
                isPalindrome = "Error: Input is an integer";
                return;
            }

            inputRegexChecker();
            reverseRegexChecker();

            if ((originalInput.toString()).equalsIgnoreCase(reverseInput.toString())) {
                isPalindrome = "Answer: is a palindrome";
            } else {
                isPalindrome = "Answer : is NOT a palindrome";
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    @Override
    public String toString() {
        isPalindrome();
        return isPalindrome;
    }
}