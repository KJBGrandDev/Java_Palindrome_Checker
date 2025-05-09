package Palindrome_Checker_OOP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class filePalindromeChecker {
    private String fileName;

    public filePalindromeChecker(String fileName) {
        this.fileName = fileName;
    }

    public boolean fileEmpty() {
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);

            if (!fileReader.hasNextLine()) {
                System.out.println("This file is currently empty");
                System.out.println("\n-------------------------------");
                System.out.println("File checker terminates..");
                System.out.println("-------------------------------\n");
                return true;
            } else {
                System.out.println("Checking file contents: \n");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return false;
    }
    public void checkAnotherFile(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to scan an another file? [Y/N]");
        System.out.println("Your choice: ");
        String input = scanner.nextLine().toLowerCase();

        switch (input){
            case "y":{
                System.out.println("\nInput the filename: ");
                this.fileName = scanner.nextLine();
                palindromeChecker();
                break;
            }
            case "n":{
                System.out.println("\n-------------------------------");
                System.out.println("File checker terminates..");
                System.out.println("-------------------------------\n");
                break;
            }
            default:{
                System.out.println("\n-------------------------------");
                System.out.println("Invalid Choice\nFile checker terminates..");
                System.out.println("-------------------------------\n");
            }
        }
    }

    public void palindromeChecker(){
        try{
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);

            if(fileEmpty()){
                checkAnotherFile();
            } else {
                while (fileReader.hasNextLine()){
                    String nextLine = fileReader.nextLine();
                    palindromeChecker checker = new palindromeChecker(nextLine);
                    System.out.println(nextLine + " = " + checker);
                }

                System.out.println("\n-------------------------------");
                System.out.println("The program has fully scanned the file");
                System.out.println("No more lines had been detected");
                System.out.println("-------------------------------\n");

                checkAnotherFile();
            }
        }catch(FileNotFoundException e){
            System.out.println("\n-------------------------------");
            System.out.println("File not found! Please try again");
            System.out.println("-------------------------------\n");
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
}
