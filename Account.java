// Student name : Aditya Sharma
// Student ID: 1616591

public class Account {
    private int key; // field to hold the account number
    private double balance; // field to keep track of the account balance.

    public Account(int key, double balance){ //constructor //add _ 
        this.key = key;
        this.balance = balance;
    }


    public int getKey(){ // returns the values of their respected feilds

        return key;
    }

    public double getBalance(){ // returns the values of their respected feilds
        return balance;
    }

    /*method is a public setter method that updates 
    the account balance based on the type and value of a transaction, taking a double value as an argument indicating how much the balance should be changed by. */
    public void setBalance(double amount){
        balance += amount;


    }
}