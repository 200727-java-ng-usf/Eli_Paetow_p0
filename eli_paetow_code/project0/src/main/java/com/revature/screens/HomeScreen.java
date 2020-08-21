package com.revature.screens;

public class HomeScreen extends Screen{

    public HomeScreen(){
        super("HomeScreen" , "/home");
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());
    }
    @Override
    public void render() {
        System.out.println("Welcome to Eli's Bank");
        System.out.println("1) Login");
        System.out.println("2) Register");

        System.out.println("3) Exit Application");
        console.read

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
