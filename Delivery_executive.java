//IMPORTING ALL NECESSARY PACKAGES

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*; 

public class Delivery_executive extends Booking{
	
	
	//DECLARING ARRAYLIST DExe TO STORE THE EARNING OF DELIVERY EXECUTIVE
	
	static ArrayList<Integer> DExe=new ArrayList<Integer>();
	
	//DECLARING ARRAYLIST Allowance TO STORE THE ALLOWANCE OF DELIVERY EXECUTIVE
	static ArrayList<Integer> Allowance=new ArrayList<Integer>();;
	
	//DECLARING THE HASHMAP INORDER TO MAINTAIN THE RESTAURANT,DESTINATION AND TIME INFORMATION
	static HashMap<Integer,String> total=new HashMap<Integer,String>();; 

	//cid-->CustomerId
	//Res-->Restaurant pick up
	//Des-->Destination drop down
	//Time-->TIme of ordering
	//Nde-->Number of delivery Executive
	//ind-->used for indexing in below code
 	
	int cid;
	char Res;
	char Des;
	String Time;
	int Nde;
	int ind;
	
	
	//constructor with number of delivery executive 
	public Delivery_executive(int Nde ) {
		this.Nde=Nde;
	}
	
	//constructor with CustomerId,Restaurant pick up,Destination,Time,number of delivery executive
	public Delivery_executive(int cid,char Res,char Des,String Time,int Nde) {
		this.cid=cid;
		this.Des=Des;
		this.Res=Res;
		this.Time=Time;
		this.Nde=Nde;
	}
	//getter for all variable
	public int getCid() {
		return cid;
	}
	public char getRes() {
		return Res;
	}
	public char getDes() {
		return Des;
	}
	public String getTime() {
		return Time;
	}
	
	//method to assign zero earning and allowance for all delivery executives 
	public void setZero() {
		
		for(int i=0;i<Nde;i++) {
			DExe.add(0);
			Allowance.add(0);
		}
		
		
	}
	
	//method to assign or map the delivery to delivery executive
	public void map() {
		
		//when the first customer arrives 
		if(cid==1) {
		//finding the minimum earning delivery executive
	    ind=DExe.indexOf(Collections.min(DExe));
	    //storing the previous earning of delivary executive
	    int pval=DExe.get(ind);
	    
	 // printing the currently total earning of delivery executive and which delivery executive is assigned for delivery
	    new Display(DExe,ind).display();
	  //updating the delivary executive earning
	   DExe.remove(ind);
	   DExe.add(ind,pval+50);
	  
	  
	  
	   //storing the previous allowance of delivary executive
	   int pall=Allowance.get(ind);
	   ////updating the delivary executive allowance 
	   Allowance.remove(ind);
	   Allowance.add(ind,pall+10);
	   
	   //converting the time (since we got time in the form of string) double format from string
	   double  ss=Double.parseDouble(Time.substring(0,Time.length()-2));
		String m_n=Time.substring(Time.length()-3);
		//converting the IST to Railway time for easy processing
		if(m_n.equals("PM")) {
			ss+=(double)12;
		}
		
	   // MAINTAINING THE RESTAURANT,DESTINATION AND TIME INFORMATION
	   String tt=""+Res+Des+ss;
	   total.put(ind+1,tt);
	   
	  
		}
		else {
			//with the help of flag we are just going to find whether a single delivery executive can take more than a single order 
			int flag=0;
			//with the help of map we have maintained an info about RESTAURANT,DESTINATION AND TIME 
			for (Map.Entry<Integer,String> me : total.entrySet()) {
				
				//comparing the RESTAURANT,DESTINATION location are same
	            if(me.getValue().charAt(0)==Res && me.getValue().charAt(1)==Des ) {
	            	 //converting the time (since we got time in the form of string) double format from string
	            	double  ss=Double.parseDouble(Time.substring(0,Time.length()-2));
	        		String m_n=Time.substring(Time.length()-3);
	        		//converting the IST to Railway time for easy processing
	        		if(m_n.equals("PM")) {
	        			ss+=(double)12;
	        		}
	        		//comparing the time whether the order is placed with in the gap of 15 minutes
	            	if((Double.parseDouble(me.getValue().substring(2))+0.15)>=ss) {
	            		// printing the currently total earning of delivery executive and which delivery executive is assigned for delivery
	            		 new Display(DExe,me.getKey()-1).display();
	            	flag=1;
	            	  //like previous steps we assigning the delivery
	            		int pval=DExe.get(me.getKey()-1);
	            		   DExe.remove(me.getKey()-1);
	            		   DExe.add(me.getKey()-1,pval+5);
	            		   ss=Double.parseDouble(me.getValue().substring(2));
	            		  
	            		   //updating to map
	            		   String tt=""+Res+Des+ss;
	            		   total.put(me.getKey(), tt);
	            		
	            	}
	            }
	        }
			//assigning new delivery 
			if(flag==0) {
				//finding the minimum earning delivery executive
				ind=DExe.indexOf(Collections.min(DExe));
				// printing the currently total earning of delivery executive and which delivery executive is assigned for delivery
				 new Display(DExe,ind).display();
				 
				 //updating the earning of delivery executive
			    int pval=DExe.get(ind);
			   DExe.remove(ind);
			   DExe.add(ind,pval+50);
			   
			   //updating the allowance of delivery executive
			   int pall=Allowance.get(ind);
			   Allowance.remove(ind);
			   Allowance.add(ind,pall+10);
			   
			   
			   //converting the time (since we got time in the form of string) double format from string and converting the IST to Railway time for easy processing
			   double  ss=Double.parseDouble(Time.substring(0,Time.length()-2));
				String m_n=Time.substring(Time.length()-3);
				if(m_n.equals("PM")) {
					ss+=(double)12;
				}
				
			   //updation in map 
			   String tt=""+Res+Des+ss;
			   total.put(ind+1,tt);
			}
	   

			  
	   //################################################### FILE STORATION FOR DELIVERY HISTORY ################################################### 
	   
				//MAKING A FILE INSTANCE WITH THE PARTICULAR LOCATION 
			   File Hfile = new File("C:\\Users\\KATHIR\\Dropbox\\My PC (LAPTOP-H0ARTAJ3)\\Desktop\\food_delivery\\History.txt"); 
			   //CHECKING WHETHER THE FILE EXIST THEN DELETING THE FILE INORDER TO MAINTAIN THE RECENT HISTORY
			   if(Hfile.exists()) {
				   Hfile.delete();
			   }
			   
			   try {
				   //CREATING A NEW FILEWRITER TO WRITE THE DATA ON FILE 
				   int k=1;
				   FileWriter myWriter = new FileWriter("C:\\Users\\KATHIR\\Dropbox\\My PC (LAPTOP-H0ARTAJ3)\\Desktop\\food_delivery\\History.txt");
				   //MAKING A HEADER FOR THE FILE
			myWriter.write("TRIP           EXECUTIVE          RESTAURANT          DESTINATION            PICK-UP_TIME               DELIVERY_TIME         DELIVERY_CHARGE\n");
		
			//WITH THE HELP OF MAP WE  ARE IN STORE OF RECENT DELIVERY HISTORY AND ITERATE ALL INFO AND STORING INTO THE FILE
			/* FOR EXAMPLE 
			 Customer ID: 1
			 Restaurant: A
			 Destionation Point : D
			Time : 9.00 AM
			
			AFTER MAPPING :
			
			 O/P---->{1,"AD9.00""}

			 */
			
			
			
			 for (Map.Entry<Integer,String> me : total.entrySet()) {
				 
				   myWriter.write(""+k++);
				   myWriter.write("\t\t");
				   
				   //FEEDING  THE DELIVERY EXECUTIVE ID TO A FILE
				   myWriter.write("DE"+me.getKey());
				   myWriter.write("\t\t\t");
				   
				 //FEEDING  THE RESTAURANT ID TO A FILE
				   
				   myWriter.write(me.getValue().charAt(0));
				   myWriter.write("\t\t\t");
				   
				 //FEEDING  THE DESTINATION ID TO A FILE
				   
				   myWriter.write(me.getValue().charAt(1));
				   myWriter.write("\t\t\t");
				   
				   //FEEDING THE PICKUP AND DELIVERY TIME TO A FILE
				   double pick_up=Double.parseDouble(me.getValue().substring(2))+0.15;
				   double delivery=Double.parseDouble(me.getValue().substring(2))+0.45;
				   myWriter.write(""+pick_up);
				   myWriter.write("\t\t\t");
				   myWriter.write((""+delivery));
				   myWriter.write("\t\t\t");
				   
				   //FEEDING THE EARNING OF DELIVERY EXECUTIVE
				   myWriter.write(""+DExe.get(me.getKey()-1));
				   myWriter.write("\n");
			 }
			 //CLOSING THE FILE
			 myWriter.flush();
			myWriter.close();
			   
			   
			   }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			 //MAKING A FILE INSTANCE WITH THE PARTICULAR LOCATION FOR TOTAL EARNING
			   File Efile = new File("C:\\Users\\KATHIR\\Dropbox\\My PC (LAPTOP-H0ARTAJ3)\\Desktop\\food_delivery\\Total_Earned.txt"); 
			   if(Efile.exists()) {
				   Efile.delete();
			   }
			   
			   try {
				
				 //CREATING A NEW FILEWRITER TO WRITE THE DATA ON FILE 
				   FileWriter myWriter = new FileWriter("C:\\Users\\KATHIR\\Dropbox\\My PC (LAPTOP-H0ARTAJ3)\\Desktop\\food_delivery\\Total_Earned.txt");
				   myWriter.write("Executive\tAllowance\tDeliver\tCharges\tTotal\n");
				   
				   for(int i=0;i<Nde;i++) {
					   
					   //FEEDING THE DELIVERY EXECUTIVE ID
					 myWriter.write("DE"+(i+1)); 
					 myWriter.write("\t\t");
					 //FEEDING THE ALLOWANCE EARNED
					 myWriter.write(""+Allowance.get(i));
					 myWriter.write("\t\t");
					 //FEEDING THE AMOUNT EARNED
					 myWriter.write(""+DExe.get(i));
					 myWriter.write("\t\t");
					 
					 //FEEDING THE TOTAL AMOUNT EARNED ---> EARNING + ALLOWANCE
					 myWriter.write(""+(Allowance.get(i)+DExe.get(i)));
					 myWriter.write("\n");
				   }
				   
				   //CLOSING THE FILE
				   myWriter.flush();
					myWriter.close();
			   } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}   
	
		
}
	public static void main(String[] args) {
		
		 
		
		}

		
	}

