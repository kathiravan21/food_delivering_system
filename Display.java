import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Display {
	//CREATING A OBJECT (ARRAYLIST) FOR PRINTING THE EARNING OF DELIVERY EXECUTIVE
  ArrayList<Integer> s;
  int ind;
  //CONSTRUCTOR FOR TOTAL EARNING AND WHICH DELIVERY EXECUTIVE IS ASSIGNED
  Display(ArrayList<Integer> h,int n){
	  s=h;
	  ind=n;
  }
  //DISPLAYING THE ALL EARNINGS AND WHICH DELIVERY EXECUTIVE IS ASSIGNED
	void display() {
		System.out.println("Available Executives :");
		System.out.println("Executive     Delivery Charge Earned");
		for(int i=0;i<s.size();i++) {
			System.out.println("DE"+(i+1)+"\t\t\t"+s.get(i));
		}
		System.out.println("Allotted Delivery Executive: DE"+(ind+1));
		
	}
	
}

	