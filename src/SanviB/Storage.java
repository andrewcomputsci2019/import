package SanviB;

import java.util.Scanner;

public class Storage {
    public static enum Role{guest, admin, user} // different levels of enum for privileges
    private static int UserId=100;//sets up a static id var
    private int Id; // creates a var for data structure
    private String pword; // password
    private String username;//username
    protected Role role;

    public Storage() // default constructor
    {
        this.role = Role.guest;
        this.Setuserid();

    }
    protected void Setuserid()
    {
        this.Id = ++UserId;
    } //creates unique userid
    protected void setter( String uname, String pname, Role role){// setter  for user
        this.pword = pname;
        this.username = uname;
        this.role = role;

    }
    protected String unamegetter()
    {
        return this.username;
    } //getter
    protected String passwordgetter()
    {
        return this.pword;
    } // getter

    @Override
    public String toString() { // override for tostring prints out user information
        return "Storage{" +
                "Id=" + Id +
                ", pword='" + pword + '\'' +
                ", username='" + username + '\'' +
                ", role=" + role +
                '}';
    }
    //obj1 = data parameters
    //obj1 has uname with password and role
}
 class Start{

    public static void main(String[] args) {
        // write your code here
        System.out.println("welcome to bitcoin shell cridtinals check ");
        System.out.println("Please enter a username");
        Scanner uwordinput = new Scanner(System.in);
        String uword = new String(uwordinput.nextLine());
        Scanner pwordinput = new Scanner(System.in);
        String pword = new String(pwordinput.nextLine());
        Storage credentials = new Storage(); // makes an object of Storage class
        credentials.setter(uword,pword, Storage.Role.admin); //sets username and password as well as role
        System.out.println(credentials); // prints out user info



    }
}