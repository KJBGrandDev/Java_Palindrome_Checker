package Palindrome_Checker_OOP;

import java.util.Scanner;

public class program {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a category: \n");
        System.out.println("1. Check a word/phrase");
        System.out.println("2. Check an entire file\n");
        System.out.println("Your choice: ");
        int input = Integer.parseInt(scanner.nextLine());

        switch (input){
            case 1:{
                while (true){
                    System.out.println("\nInput a word or phrase, giving a blank space will end the program: ");
                    String wordInput = scanner.nextLine();

                    if(wordInput.isEmpty()){
                        System.out.println("You didn't give a word/phrase\n");
                        System.out.println("Program will now terminate..");
                        System.out.println("Goodbye!");
                        break;
                    }

                    palindromeChecker checker = new palindromeChecker(wordInput);
                    System.out.println("Answer: " + checker);
                }
                break;
            }
            case 2:{
                System.out.println("\nInput a file name: ");
                String fileNameInput = scanner.nextLine();
                System.out.println();

                filePalindromeChecker checker = new filePalindromeChecker(fileNameInput);
                checker.palindromeChecker();
                break;
            }
        }
    }
}
