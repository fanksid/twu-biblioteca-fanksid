package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
    	// login
    	int usrcode = 0;
        System.out.println("Hello there, welcome to the library.\n"
        		+ "Press 1 to login as customer and press other characters to login as librarian.");
        Scanner inp =new Scanner(System.in);
        String str = inp.nextLine();
        usrcode = Integer.parseInt(str);
        if(usrcode == 1)
        	System.out.println("Welcome, customer.\n"
        			+ "Press 1 to enter the Menu opinon: \'List Books\'.");
        else
        	System.out.println("Welcome, librarian.\n"
        			+ "Press 1 to enter the Menu opinon: \'List Books\'.");
        // to see the main menu
        int menucode = 0;
        while(menucode != 1){
	        inp =new Scanner(System.in);
	        str = inp.nextLine();
	        menucode =  Integer.parseInt(str);
	        if(menucode != 1)
	        	System.out.println("Please select a valid option!.");
	        };
        // to see the book list
	    int[] books = new int[10];
	    int[] bookstatus = new int[10];
	    for(int i = 1;i<=10;i++){
	    	books[i-1] = i;
	    	bookstatus[i-1] = 0; // 0 means not checkout
	    }
	    //show the books
	    if(menucode == 1){
	    	for(int i = 0;i < 10; i++){
	    		System.out.println("Book name: Book"+books[i]+". Status: "+(bookstatus[i]==0?"In Library":"Not in")+".");
	    		}
	    	menucode = 11;
	    	}
	    System.out.println("Press the book No. if you want to check-out the book.");
	    // check out 
	    int checkcode = 0; //see the book check out?
	    while(checkcode == 0){
		    inp =new Scanner(System.in);
	        str = inp.nextLine();
	        int booknum =  Integer.parseInt(str);
	        if(bookstatus[booknum-1] != 0)
	        	System.out.println("Sorry, the book had already beed checked out.");
	        else{
	        	//
	        	System.out.println("Thank you! Enjoy the book.");
	        	System.out.println("The detail book info of Book"+booknum+".");
	        	bookstatus[booknum-1] = 1;
	        	checkcode = 1;
	        }
        }
	    //quitcode to see if quit.
	    int quitcode = 0;
	    while(quitcode == 0){
	    	System.out.println("Press 101 to quit the system, otherwise move to the book list.");
	    	inp =new Scanner(System.in);
	        str = inp.nextLine();
	        int quitnum =  Integer.parseInt(str);
	        if (quitnum == 101)
	        	quitcode = 1;
	        else
	        	for(int i = 0;i < 10; i++){
		    		System.out.println("Book name: Book"+books[i]+". Status: "+(bookstatus[i]==0?"In Library":"Not in")+".");
		    		}
	    }
	    System.out.println("Goodbye.");
    }
}
