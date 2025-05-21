package Palindrome_Checker_OOP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        //A for loop that extracts the parts of a string one by one using the charAt(i) position

        //We start at the count of 0 which is equivalent to the first character of the string then it increment the value until it reaches the condition of "i less than input.length() which had the value of "last character position + 1" value and serves as a gate

        //It also checks whether the current "char" is an alphabet between a-z or if it's a capital, A-Z, using the regular Expression method (regEx)
        for(int i = 0; i < input.length(); i++){
            if(String.valueOf(input.charAt(i)).matches(regEx)){
                originalInput.add(String.valueOf(input.charAt(i)));
            }
        }
    }

    public void reverseRegexChecker(){
        String regEx = "^[a-zA-Z]+$";
        //A for loop that extracts the characters of a string in reverse manner
        //The loop starts at the end side of the string by using the string.length() value minus 1

        //Why minus 1? it's because input.length counts the literal count of the string starting from 1 while charAt(i) values count starting from 0 so there's a discrepancy of 1 unit. To solve it, we must decrease the value of the string.length() by 1 so that we can call the last character of the string perfectly

        //It also checks whether the current "char" is an alphabet between a-z or if it's a capital, A-Z, using the regular Expression method (regEx)
        for(int i = input.length() - 1; i >= 0; i--){
            if(String.valueOf(input.charAt(i)).matches(regEx)){
                reverseInput.add(String.valueOf(input.charAt(i)));
            }
        }
    }

    public void isPalindrome() {
        //This will return an "error" if the input only contains numbers
        //This is just a regEx example of manually checking input based on its data types and can be erased due to the more robust 2nd regEx checker in line 45
        if(input.matches("[0-9]+$")){
            isPalindrome = "Error: Input must contain at least one letter";
            return;
        }

        //This if-statement will return an "error" if the input does not contain an alphabet from "a to z or A to Z" (case-sensitive checker)
        if(input.matches("^[^a-zA-Z]+$")){
            isPalindrome = "Error: Input must contain at least two letters";
            return;
        }

        /*Based on research, the shortest palindrome is "aa"
        This will return an "error" if the "input" is less than two letters
        */
        if(input.length() == 1){
            isPalindrome = "Error: Input must contain at least two letters";
            return;
        }
        //Calls and run inputRegExChecker() method.. Check line 16
        inputRegexChecker();

        //Calls and run reverseRegExChecker() method.. Check line 26
        reverseRegexChecker();

        //originalInput are then compared to the reverseInput.
        //equalsIgnoreCase makes small or capital letters have the same value as long as they are the "same letter/alphabet"
        if ((originalInput.toString()).equalsIgnoreCase(reverseInput.toString())) {
            isPalindrome = "is a palindrome";

            File file = new File("palindromeList.txt");
            String absolutePath = file.getAbsolutePath();

            //If the word is a palindrome, the program will then save the palindrome word inside the "palindromeList" using FileWriter method
            try{
                FileWriter writer = new FileWriter(absolutePath, true);
                writer.write(input + "\n");
                writer.flush();
                writer.close();
            } catch(IOException e){
                System.out.println("Error: " + e);
            }

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