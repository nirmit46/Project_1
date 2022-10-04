package project1;

import java.util.Scanner;

class bankfunction{
    private String accno;  
    private String name;  
    private String acc_type;  
    private long balance;  
    Scanner sc=new Scanner(System.in);
    public void createacc() {
		System.out.println("Enter Account number");
		accno=sc.next();
		System.out.println("Enter Account Type");
		acc_type=sc.next();
		System.out.println("Enter Account Holder's Name");
		name=sc.next();
		System.out.println("Enter the amount you want to deposit");
		balance=sc.nextLong();
		System.out.println("Account Created Successfully\n");
	}
    public void showBalance() {  
    	
        System.out.println("Name of account holder: " + name);  
        System.out.println("Account no.: " + accno);  
        System.out.println("Account type: " + acc_type);  
        System.out.println("Balance: " + balance);  
    }  
    public boolean search(String ac_no) {  
        if (accno.equals(ac_no)) {  
            showBalance();  
            return (true);  
        }  
        return (false);  
    }  
 
    public void deposit() {  
        long amnt;  
        System.out.println("Enter the amount you want to deposit: ");  
        amnt = sc.nextLong();  
        balance = balance + amnt; 
        System.out.println(amnt+" deposited into your account");
        System.out.println("Balance after depositing: "+balance);
    }  
    public void withdrawal() {  
        long amt;  
        System.out.println("Enter the amount you want to withdraw: ");  
        amt = sc.nextLong();  
        if (balance >= amt) {  
            balance = balance - amt;  
            System.out.println("Balance after withdrawal: " + balance);  
        } else {  
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );  
        }  
    }  
    public int transfersend(long amount) {
    	if(amount>balance){
    		System.out.println("Insufficient funds");
    	}
    	else {
			balance=balance-amount;
		}
		return 0;
    }
    public int transfereceive(long amount) {
		System.out.println("Amount transferred successfully");
    	balance=balance+amount;
		return 0;
	}
}

public class bank {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	  System.out.println("How many number of customers do you want to input? ");  
      int n = sc.nextInt();  
      bankfunction C[] = new bankfunction[n];  
      for (int i = 0; i < C.length; i++) {  
          C[i] = new bankfunction();  
          C[i].createacc();  
      }  
      int ch;  
      do {  
          System.out.println("\n ***Banking Application***");  
          System.out.println("1. View your account details \n 2. Transfer amount to another account \n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Exit ");  
          System.out.println("Enter your choice: ");  
          ch = sc.nextInt();  
              switch (ch) {  
                  case 1:  
                	  System.out.print("Enter account no. you want to search: ");  
                      String ac_no = sc.next();  
                      boolean found = false;  
                      for (int i = 0; i < C.length; i++) {  
                          found = C[i].search(ac_no);  
                          if (found) {  
                              break;  
                          }  
                      }  
                      if (!found) {  
                          System.out.println("Search failed! Account doesn't exist..!!");  
                      }  
                      break; 
                  case 2:
                	  System.out.println("Enter Account no of Sender");
                	  String acc=sc.next();
                	  long amount = 0;
                	  found = false;  
                      for (int i = 0; i < C.length; i++) {  
                          found = C[i].search(acc);  
                          if (found) {  
                        	  System.out.println("Enter amount to be transferred");
                        	  amount=sc.nextLong();
                              C[i].transfersend(amount);  
                              break;
                          }  
                      }  
                      if (!found) {  
                          System.out.println("Search failed! Account doesn't exist..!!");  
                      }  
                	  System.out.println("Enter Account no. of the reciever : ");  
                      ac_no = sc.next();  
                      found = false;  
                      
                      for (int i = 0; i < C.length; i++) {  
                          found = C[i].search(ac_no);  
                          if (found) {  
                              C[i].transfereceive(amount);  
                              break;  
                          }  
                      }  
                      if (!found) {  
                          System.out.println("Search failed! Account doesn't exist..!!");  
                      }  
                      break;   
                  case 3:  
                      System.out.print("Enter Account no. : ");  
                      ac_no = sc.next();  
                      found = false;  
                      for (int i = 0; i < C.length; i++) {  
                          found = C[i].search(ac_no);  
                          if (found) {  
                              C[i].deposit();  
                              break;  
                          }  
                      }  
                      if (!found) {  
                          System.out.println("Search failed! Account doesn't exist..!!");  
                      }  
                      break;  
                  case 4:  
                      System.out.print("Enter Account No : ");  
                      ac_no = sc.next();  
                      found = false;  
                      for (int i = 0; i < C.length; i++) {  
                          found = C[i].search(ac_no);  
                          if (found) {  
                              C[i].withdrawal();  
                              break;  
                          }  
                      }  
                      if (!found) {  
                          System.out.println("Search failed! Account doesn't exist..!!");  
                      }  
                      break;  
                  case 5:  
                      System.out.println("See you soon...");  
                      break;  
                  default:
                	  System.out.println("Invalid Input");
                	  break;
              }  
              
          }  
          while (ch != 5);  
}
}
