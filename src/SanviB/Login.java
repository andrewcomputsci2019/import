package SanviB;

import java.util.Scanner;
import java.util.ArrayList;

//public class Login { }

class storeCredentials {
    ArrayList<Storage> credentialsList = new ArrayList<Storage>();
    public storeCredentials() {
        String[][] credentials;
        credentials = new String[][]{   // 2D array to transfer credentials into Storage objects
                {
                        "andrew", "1234" // [0][0] username, [0][1] password
                },
                {
                        "mhayes", "1800"
                },
                {
                        "jchang", "specs"
                },
                {
                        "dphung", "specs"
                },
                {
                        "dramsayer", "menus"
                }
        };
        for (int i = 0; i < credentials.length; i++) {
            Storage newCredential;
            newCredential = new Storage();
            newCredential.setter(credentials[i][0], credentials[i][1], Storage.Role.admin); // cycles through each credential in set, creating a new object and setting up its attributes
            credentialsList.add(newCredential);
        }
        /*
        String [][] credentials;
        credentials = new String[][] {
                {
                    // Credentials Set 1
                        "andrew", "1234" // [0][0](username) [0][1](password)
                },
                {
                    // Credentials Set 1
                        "mhayes", "1800" // [1][0](username) [1][1](password)
                }
        };*/
    }
    public void checkCredentials() {
        String givenCredentials[] = new String[2]; // Array for comparison of username and password in one loop
        boolean correctCredentials = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("|-------Please login to access shell-------|\n");
        while (correctCredentials != true){
            System.out.println("Username:");
            givenCredentials[0] = scan.next();
            System.out.println("Password:");
            givenCredentials[1] = scan.next();
            int credentialsSize = credentialsList.size(); // determines length of Array List
            int credentialColumns = 2; // sets value for column size
            int givenCredentialsSize = givenCredentials.length; // determines size of givenCredential array
            int matchNumber = 0; // counter to determine when both the username and password both match
            boolean result = false; // boolean to track when the username and password are correct
            for (int rowCount = 0; rowCount < credentialsSize; rowCount++){ // master cycle that goes through
                matchNumber = 0; // counts number of matched credentials -- needs two (username and password) to log in, if username
                for(int colCount = 0; colCount < credentialColumns; colCount++) {
                    for(int i = 0; i < givenCredentialsSize; i++){
                        if (matchNumber == 0){
                            result = givenCredentials[i].equals(credentialsList.get(rowCount).unamegetter()); // gives either a true result (credentials valid) or a false result (credentials incorrect)
                        } else if (matchNumber == 1){
                            result = givenCredentials[i].equals(credentialsList.get(rowCount).passwordgetter());
                        }
                        if (result == true){ // if either the username-username or password-password match, a value is given to matchNumber
                            matchNumber++;
                        }
                        if (matchNumber == 2){ // magic matchNumber = 2 as both a username and password need to match
                            correctCredentials = true; // exits loop (satisfies while loop)
                        }
                    }
                }
            }
        }
        int delay_time = 150;
        System.out.print("Loading");
        // fun loading animation of dots when log in is successful (difference between println and print)
        for (int j = 0; j < 7; j++){
            System.out.print(".");
            try {
                Thread.sleep(delay_time);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\n\n|-----Login Successful-----|\n");
    }
}
