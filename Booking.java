import java.util.*;
public class Booking {

public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	//GETTING THE INPUT OF NUMBER OF DELIVERY EXECUTIVES
	System.out.print("NUMBER OF DELIVERY EXECUTIVE : ");
	
	int Nde=sc.nextInt();
	
	//PASSING NUMBER OF EXECUTIVES TO Delivery_executive CLASS INORDER TO ALLOCATE MEMORY
	new Delivery_executive(Nde).setZero();
	
	
	//MAKING AN CONDITION ALWAYS TRUE INORDER TO PROVIDE THE DEVILERY INPUT INFINITELY
	
	while(true) {
		
	//GETTING CUSTOMER ID 
		
	System.out.print("Customer ID:");
	int cid=sc.nextInt();
	
	//GETTING PICK UP RESTARANT
	System.out.print("Restaurant :");
	char res=sc.next().charAt(0);
	
	//GETTING DROP OUT RESTARANT
	System.out.print("Destionation Point : ");
	char des=sc.next().charAt(0);
	
	
	//GETTING THE ORDER TIME
	System.out.print("Time :");
	String Time=sc.next();
	
	//PASSING ALL THE INFO TO Delivery_executive CLASS TO ASSIGN DELIVERY EXECUTIVE
	new Delivery_executive(cid,res,des,Time,Nde).map();
	
	}
	
	
	
}
}

	


