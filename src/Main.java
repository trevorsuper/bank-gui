/*Filip Cvetkovski and Trevor Super
 * Dec 1 2022
 * JavaSE-17
 */
public class Main {
	public static void main(String[] args) {
		runProgram();
	 /*if you create a new project and don't name the package, you will not be required to include package graphing; to each class to connect them
	I.E. the classes with automatically be connected
	*/

}
	public static void runProgram(){
		IDandPasswords AccNumAndPasswords = new IDandPasswords(); //instantiates the IDandPasswords class and IDandPasswords()
		//passes the logininfo HashMap values through to the LoginPage function
		//AccountScreen1 ac1 = new AccountScreen1(null);
		@SuppressWarnings({ "unused", "unchecked" })
		LoginPage bankProgram = new LoginPage(AccNumAndPasswords.getLoginInfo());
	}
}
