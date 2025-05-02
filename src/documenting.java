import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class documenting {
	private double totalAmt = 0;
	private double difference = 0;
	private double finalTotal = 0;
	private String stringTot;
	private String lastNumber;
	private int transactionNumber = 0;
	AccountScreen1 screenOne = new AccountScreen1(null);
	
	//method for file input/output. deals with the deposit and withdrawl functions in the program
	@SuppressWarnings({ "resource", "unused" })
	public void fileIO(double depositAmt, double withdrawlAmt, String someDoc) {
		FileWriter docWriter; //creates a new fileWriter called docWriter
			 try {
			 File dataDoc = new File("data.txt"); //starts new text doc
			 if( ! (dataDoc.exists()) ) { 
				 //if the text doc doesnt exist
			    System.out.println("File doesn't exist, data.txt was made.");
			    dataDoc.createNewFile(); //creates text document
			    docWriter = new FileWriter("data.txt");//creates a file writer for data.txt
			   
			    //StringTot gets the double totalAmt as a string so that it can be written into data.txt 
			    stringTot = Double.toString(totalAmt);  	
			    docWriter.write(stringTot); //writes the initial totalAmt which is 0
			    docWriter.write("\n");
			    docWriter.close();
			 }
			 //runs once the file has been made or already exists
			 //System.out.println("File data.txt exists");
			 
			 //gets the difference between the deposit/withdrawl and adds it to the total amoount
			 difference = depositAmt - withdrawlAmt;
			 totalAmt += difference;
			Scanner scnr = new Scanner(dataDoc); //the first scanner scnr is used to find out the number of transactions.
			Scanner reScan = new Scanner(dataDoc); //this scanner is used to get the last transaction number.
			
			//scans throught the document and prints each value
			String getNum = "";
			while(scnr.hasNext()) {
				getNum = scnr.next();
			    transactionNumber++;	
			    //System.out.println(getNum);
			}
			
			//goes to the last number in the file to get its value
			for(int i=0; i< transactionNumber ; i++) {
				lastNumber = reScan.next();
				
			}
			
			//double finalTotal gets string lastNumber
			finalTotal = Double.parseDouble(lastNumber);
		    //the new number is added to the total amount
			finalTotal += totalAmt;
			//System.out.println("amount after transaction: " +finalTotal);
			//turn double into string so it can be written back into the file
			String lastTotalString = Double.toString(finalTotal);
			docWriter = new FileWriter("data.txt", true);
			docWriter.write(lastTotalString+"\n"); //writes the number
			docWriter.close(); 
			
			Scanner finalScan = new Scanner(dataDoc); //last scan for printing to the jtextfield
			String getNewNum = "";
			System.out.println("transaction number: "+transactionNumber);
			int rowNumber = 0;
			while(finalScan.hasNext()) {
				getNewNum = finalScan.next();
				screenOne.checkingLabel.setText("Checking Account: $"+getNewNum); //prints to the checking amt label
				if(rowNumber<24) {
			    screenOne.ReceiptField.setText(screenOne.ReceiptField.getText() +getNewNum +"\n"); //prints to the text area
				}
				if(rowNumber>=24 && rowNumber<48) {
				screenOne.ReceiptFieldTwo.setText(screenOne.ReceiptFieldTwo.getText() +getNewNum +"\n"); //prints to the second text area
				}
			    rowNumber++;
			}
			screenOne.frame.setVisible(true);
			
			
			} 
		    catch (IOException e){
				e.printStackTrace();
			}
			
	}
	
}
