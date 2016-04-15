package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
    	// login
    	int usrcode = 0;
    	String user = "";
        System.out.println("Hello there, welcome to the library.\n"
        		+ "Press 1 to login as customer and press other characters to login as librarian.");
        Scanner inp =new Scanner(System.in);
        String str = inp.nextLine();
        usrcode = Integer.parseInt(str);
        while(usrcode == 1){
	        	System.out.println("Please Enter your username.");
	        	inp =new Scanner(System.in);
	            String uname = inp.nextLine();
	            System.out.println("Please Enter your password.");
	        	inp =new Scanner(System.in);
	            String upwd = inp.nextLine();
	            //if uname/pwd in database or not
	            if(uname.equals("Hanmeimei") && upwd.equals("Lilei")){
	            	System.out.println("Welcome, Hanmeimei.\n"
	            			+ "Press 1 to enter the Menu Opinon: \'List Books\' "
	            			+ "Press 2 to enter the Menu Opinon: \'List Movies\'.");
	            	user = uname;
	            	break;
	            }else{
	            	System.out.println("Wrong Username or Password.");
	            }
	            
        	}
       if(usrcode != 1){
        		System.out.println("Welcome, librarian.\n"
        			+ "Press 1 to enter the Menu opinon: \'List Books\'.");
        		user = "librarian";
        	}
        // to see the main menu
        int menucode = 0;
        while(menucode != 1 && menucode != 2){
	        inp =new Scanner(System.in);
	        str = inp.nextLine();
	        menucode =  Integer.parseInt(str);
	        if(menucode != 1 && menucode != 2)
	        	System.out.println("Please select a valid option!.");
	        };
        // init the book list or movie list.
	    int[] books = new int[10];
	    int[] bookstatus = new int[10];
	    String[] bookusr = new String[10];
	    int[] mvs = new int[10];
	    int[] mvstatus = new int[10];
	    String[] mvusr = new String[10];
	    for(int i = 1;i<=10;i++){
	    	books[i-1] = i;
	    	bookstatus[i-1] = 0; // 0 means not checkout
	    	bookusr[i-1] = "None";
	    	mvs[i-1] = i;
	    	mvstatus[i-1] = 0;
	    	mvusr[i-1] = "None";
	    }
	    //book or movie that be borrowed
	    bookstatus[5] = 1; // 1 means checkout
    	bookusr[5] = "Hanmeimei";
    	mvstatus[4] = 1;
    	mvusr[4] = "Hanmeimei";
	    //show the books
	    if(menucode == 1){
	    	for(int i = 0;i < 10; i++){
	    		System.out.println("Book name: Book"+books[i]+". Status: "+(bookstatus[i]==0?"In Library":"Borrowed by "+bookusr[i])+".");
	    	}
		    menucode = 11;
			System.out.println("Press the book No. if you want to check-out the book.");
	    	}
	    if(menucode == 2){
	    	for(int i = 0;i < 10; i++){
	    		System.out.println("Movie name: Movie"+mvs[i]+". Status: "+(mvstatus[i]==0?"In Library":"Borrowed by "+mvusr[i])+".");
	    	}
		    menucode = 21;
			System.out.println("Press the book No. if you want to check-out the book.");
	    }
	    // check out 
	    int checkcode = 0; //see the book check out?
	    while(checkcode == 0){
		    inp =new Scanner(System.in);
	        str = inp.nextLine();
	        int num =  Integer.parseInt(str);
	        int tstatus = (menucode==11?bookstatus[num-1]:mvstatus[num-1]);
	        if(tstatus != 0)
	        	System.out.println("Sorry, the "+(menucode==11?"book":"movie")+" had already beed checked by "+(menucode==11?bookusr[num-1]:mvusr[num-1])+".");
	        else{
	        	//
	        	System.out.println("Thank you! Enjoy the "+(menucode==11?"book":"movie")+".");
	        	System.out.println("The detail info of "+(menucode==11?"book":"movie")+num+"."); //ext...
	        	if(menucode == 11){
	        		bookstatus[num-1] = 1;
	        		bookusr[num-1] = user;
	        	}else{
	        		mvstatus[num-1] = 0;
	    	    	mvusr[num-1] = user;
	        	}
	        	checkcode = 1;
	        }
        }
	    //quitcode to see if quit.
	    int quitcode = 0;
	    while(quitcode == 0){
	    	System.out.println("Press 101 to quit the system, otherwise move to the Menu list.");
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
