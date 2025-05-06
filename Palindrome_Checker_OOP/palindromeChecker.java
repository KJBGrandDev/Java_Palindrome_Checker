package Palindrome_Checker_OOP;

import java.util.ArrayList;
public class palindromeChecker {
    private String input;
    private String isPalindrome;
    private String stringOriginalInput;
    private String stringReverseInput;
    private ArrayList<String> originalInput;
    private ArrayList<String> reverseInput;

    public palindromeChecker(String input){
        this.input = input.toLowerCase();
        this.originalInput = new ArrayList<>();
        this.reverseInput = new ArrayList<>();
    }

    public void inputRegexChecker(){
        String regEx = "^[a-z]+$";

        for(int i = 0; i < input.length(); i++){
            if(String.valueOf(input.charAt(i)).matches(regEx)){
                originalInput.add(String.valueOf(input.charAt(i)));
            }
        }
    }

    public void reverseRegexChecker(){
        String regEx = "^[a-z]+$";

        for(int i = input.length() - 1; i >= 0; i--){
            if(String.valueOf(input.charAt(i)).matches(regEx)){
                reverseInput.add(String.valueOf(input.charAt(i)));
            }
        }
    }

    public void isPalindrome(){
        inputRegexChecker();
        reverseRegexChecker();

        if(originalInput.isEmpty()){
            System.out.println("An empty space");
            return;
        }

        if(originalInput.equals(reverseInput)){
            isPalindrome = "is a palindrome";
        } else {
            isPalindrome = "is NOT a palindrome";
        }
    }

    @Override
    public String toString() {
        isPalindrome();
        return isPalindrome;
    }
}
