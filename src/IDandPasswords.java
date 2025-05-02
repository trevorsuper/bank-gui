import java.util.HashMap;
public class IDandPasswords{
	HashMap<String,String> logininfo = new HashMap<String,String>(); //initiates the HashMap of name logininfo with a Key and a Value
	IDandPasswords() { //the first piece of the HashMap is the Key the second piece of the HashMap is the Value
		logininfo.put("814K2398","Bologna1"); //sets the account number and password
		logininfo.put("1","f"); //the "key" in the HashMap is the account number, the "value" in the HashMap is the password
		
	}
	 @SuppressWarnings("rawtypes")
	protected HashMap getLoginInfo() { //protected is so that not just any class can get access to the account information
		 return logininfo; //a function that calls getLoginInfo() will get the logininfo HashMap
	 }
}