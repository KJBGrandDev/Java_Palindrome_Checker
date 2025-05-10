package Palindrome_Checker_OOP;

import java.io.*;
import java.util.Scanner;

public class filePalindromeChecker {
    private String fileName;

    public filePalindromeChecker(String fileName) {
        this.fileName = fileName;
    }

    private InputStream getFileStream() {
        // First try to load as resource (works in JAR)
        InputStream is = getClass().getResourceAsStream("/File/" + fileName);
        if (is != null) {
            return is;
        }
        return null;
    }

    public boolean isFileEmpty(InputStream is) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            if (br.readLine() == null) {
                System.out.println("\n-------------------------------");
                System.out.println("The file is empty.");
                System.out.println("-------------------------------");
                return true;
            }
            System.out.println("\n-------------------------------");
            System.out.println("Checking file contents..");
            System.out.println("-------------------------------\n");
            System.out.println("-------------------------------");
            System.out.println("Results:");
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkAnotherFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWould you like to scan another file?");
        System.out.print("Pick an option [Y/N]: ");
        String input = scanner.nextLine().toLowerCase();

        switch (input) {
            case "y":
                System.out.print("\nEnter the filename: ");
                this.fileName = scanner.nextLine();
                palindromeChecker();
                break;
            case "n":
                System.out.println("\n-------------------------------");
                System.out.println("File checker terminated");
                System.out.println("-------------------------------\n");
                break;
            default:
                System.out.println("\n-------------------------------");
                System.out.println("Invalid choice. File checker terminated");
                System.out.println("-------------------------------\n");
        }
    }

    public void palindromeChecker() {
        InputStream is = getFileStream();

        if (is == null) {
            System.out.println("-------------------------------");
            System.out.println("Error: File '" + fileName + "' not found!");
            System.out.println("Please follow this checklist:");
            System.out.println("1. File must exists in the 'File' folder");
            System.out.println("2. You might misspelled the filename");
            System.out.println("3. File has .txt extension if needed ex. [file.txt]");
            System.out.println("-------------------------------");
            checkAnotherFile();
            return;
        }

        if (isFileEmpty(is)) {
            checkAnotherFile();
            return;
        }

        try(InputStream newIs = getClass().getResourceAsStream("/File/" + fileName)) {
            assert newIs != null;
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(newIs));

            String line;
            while ((line = fileReader.readLine()) != null) {
                if(!line.trim().isEmpty()){
                    palindromeChecker checker = new palindromeChecker(line);
                    System.out.println(line + " = " + checker);
                }
            }

            System.out.println("-------------------------------");
            System.out.println("\n-------------------------------");
            System.out.println("File scan completed");
            System.out.println("-------------------------------");

            checkAnotherFile();
        } catch (Exception e) {
            System.out.println("\n-------------------------------");
            System.out.println("Error reading file: " + e.getMessage());
            System.out.println("-------------------------------\n");
        }
    }
}
