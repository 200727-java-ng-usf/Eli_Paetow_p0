package com.revature.screens;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HomeScreen extends Screen{

    public HomeScreen(){
        super("HomeScreen" , "/home");
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
    }
    @Override
    public void render() {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Welcome to Eli's Bank");
        System.out.println("1) Login");
        System.out.println("2) Register");

        System.out.println("3) Exit Application");


        try {
            System.out.println("> ");
            String userSelection = console.readLine();

            switch (userSelection) {
                case "1":
                    //login
                    break;
                default:
                    System.out.println("invalid selcection");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
