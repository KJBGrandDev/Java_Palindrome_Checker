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
            System.out.println("Select an option [1-3]: ");
            String input = scanner.nextLine();

            try{
                int inputTrial = Integer.parseInt(input);
                if(inputTrial < 1 || inputTrial > 3){
                    System.out.println("Invalid Choice. Please try again\n");
                }
                switch (inputTrial){
                    case 1:{
                        while (true){
                            System.out.println("\nInput a word or phrase (press Enter with no text to end): ");
                            String wordInput = scanner.nextLine();

                            if(wordInput.isEmpty()){
                                System.out.println("-------------------------------");
                                System.out.println("You didn't give a word/phrase");
                                System.out.println("Word checker terminates..");
                                System.out.println("-------------------------------\n");
                                break;
                            }
                            palindromeChecker checker = new palindromeChecker(wordInput);

                            if(wordInput.matches("[0-9]") || wordInput.matches("^[^a-zA-Z]+$")){
                                System.out.println(checker);
                            } else {
                                System.out.println("Answer: " + checker);
                            }
                        }
                        break;
                    }
                    case 2:{
                        System.out.println("\nInput a file name: ");
                        String fileNameInput = scanner.nextLine();

                        filePalindromeChecker checker = new filePalindromeChecker(fileNameInput);
                        checker.palindromeChecker();
                        break;
                    }
                    case 3:{
                        System.out.println("\n-------------------------------");
                        System.out.println("Program will now terminate..");
                        System.out.println("Goodbye!");
                        System.out.println("-------------------------------");
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
