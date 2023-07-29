

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

import java.util.Scanner;

public class XProcess {
    public static void main(String[] args) {
        // Create a new instance of BankBST
        BankBST bankBST = new BankBST();
        
        try{
            // Ask the user to input the file name
            Scanner inputScanner = new Scanner(System.in);
            System.out.print("Enter the file name: ");
            String fileName = inputScanner.nextLine();
            inputScanner.close();

            // Get the current directory
            String CurrDirect = System.getProperty("user.dir");
            System.out.println("Current Directory: " + CurrDirect);

            // Create a new file using the file name provided by the user
            File file = new  File(CurrDirect + "/" + fileName); 
            // Create a scanner to read the file
            Scanner scanner = new Scanner(file); 
            
            // Loop through each line in the file
            while(scanner.hasNextLine()){
                // Read the next line of the file
                String data = scanner.nextLine();
                // Split the line into an array of strings using spaces as the delimiter
                String[] FileArr = data.split(" ", 3);
                // Check if the array has three elements
                if(FileArr.length==3){
                    // Create a new Account object using the account number from the file
                    Account tempAccount = new Account(Integer.parseInt(FileArr[0]), 0);
                    // Search for the account in the binary search tree
                    Account one = bankBST.search(tempAccount);
                    // Check if the transaction is a deposit
                    if(Objects.equals(FileArr[1],"d")){
                        // If the account already exists, update the balance
                        if(one != null){
                            one.setBalance(Double.parseDouble(FileArr[2]));
                        }
                        // If the account does not exist, create a new account and set the balance
                        else{
                            bankBST.Addaccount(tempAccount);
                            tempAccount.setBalance(Double.parseDouble(FileArr[2]));
                        }
                        System.out.println("DEPOSIT");

                    }
                     // Check if the transaction is a withdrawal
                    else if(Objects.equals(FileArr[1],"w")){
                         // If the account already exists, update the balance with a negative amount
                        if(one != null){
                            one.setBalance(-Double.parseDouble(FileArr[2]));
                        }
                       // If the account does not exist, create a new account and set the balance with a negative amount
                        else{
                            bankBST.Addaccount(tempAccount);
                            tempAccount.setBalance(-Double.parseDouble(FileArr[2]));
                        }
                        System.out.println("WITHDRAW");
                    }
                     // Check if the transaction is a close account request
                    else if(Objects.equals(FileArr[1],"c")){
                         // If the account exists, remove it from the binary search tree
                        if(one != null){
                            bankBST.Remove(one);
                        }
                        System.out.println("CLOSE");
                    }
                }
            }
            // Close the scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // Print the result
        System.out.println("RESULT");
        bankBST.traverseBST();
    }   
}
