package Palindrome_Checker_OOP;

import java.util.Scanner;

public class program {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        boolean palindromeSystem = true;
        while(palindromeSystem){
            System.out.println("Choose a category: \n");
            System.out.println("1. Check a word/phrase");
            System.out.println("2. Check an entire file");
            System.out.println("3. Exit\n");
            System.out.println("Your choice: ");
            String input = scanner.nextLine();

            try{
                int inputTrial = Integer.parseInt(input);
                if(inputTrial < 1 || inputTrial > 3){
                    System.out.println("Invalid Choice. Please try again\n");
                }
                switch (inputTrial){
                    case 1:{
                        while (true){
                            System.out.println("\nInput a word or phrase, giving a blank space will end the program: ");
                            String wordInput = scanner.nextLine();

                            if(wordInput.isEmpty()){
                                System.out.println("You didn't give a word/phrase");
                                System.out.println("Word checker terminates..\n");
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
                    case 3:{
                        System.out.println("\nProgram will now terminate..");
                        System.out.println("Goodbye!");
                        palindromeSystem = false;
                        break;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("\nInvalid Choice. Please try again\n");
            }
        }
    }
}
