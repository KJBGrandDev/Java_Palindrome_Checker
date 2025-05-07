package Palindrome_Checker_OOP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class filePalindromeChecker {
    private final String fileName;

    public filePalindromeChecker(String fileName){
        this.fileName = fileName;
    }

    public void palindromeChecker(){
        try{
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);

            if(!fileReader.hasNextLine()){
                System.out.println("-------------------------------");
                System.out.println("This file is empty");
                System.out.println("File checker terminates..");
                System.out.println("-------------------------------\n");
                return;
            }

            System.out.println("Checking file contents: \n");

            while (fileReader.hasNextLine()){
                String nextLine = fileReader.nextLine();
                palindromeChecker checker = new palindromeChecker(nextLine);
                System.out.println(nextLine + " = " + checker);
            }

            System.out.println("\n-------------------------------");
            System.out.println("The program has fully scanned the file");
            System.out.println("No more lines had been detected");
            System.out.println("\nFile checker terminates..");
            System.out.println("-------------------------------\n");

        }catch(FileNotFoundException e){
            System.out.println("-------------------------------");
            System.out.println("File not found! Please try again");
            System.out.println("-------------------------------\n");
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
}
