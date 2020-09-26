package SanviB;
//fixed main

import  java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        int x;
        Scanner Switch = new Scanner(System.in);
        
        boolean exit = false;
        while(!exit)
        {
            System.out.println("\u001B[31m"+"------menu----------------");
            System.out.println("1-----Gen new profile-----");
            System.out.println("2----parse existing profile");
            System.out.println("0----exit program----------");
            x=Switch.nextInt();

            switch(x)
            {
                case 1:
                    new storeCredentials().checkCredentials();
                    //put gen class here
                    System.out.println(" place holder text");
                break;
                case 2:
                    System.out.println("place holder text");
                break;
                case 0:
                    System.out.println("program will now exit");
                    exit=true;
                    break;
                default:
                    System.out.println("sorry what you enter did not match any know input ");

            }
        }




    }

}
// Todo finish login class
// Todo Specs class and login class able to pass data back to main
// Todo fail safes and error catches