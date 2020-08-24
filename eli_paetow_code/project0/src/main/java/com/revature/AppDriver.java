package com.revature;

import com.revature.util.AppState;

public class AppDriver {

    public static AppState app = new AppState();

    public static void main(String[] args) {

        while(app.isAppRunning()) {
            System.out.println(app.isAppRunning());
            System.out.println("-----------------");
            app.getRouter().navigate("/home");
            System.out.println("-----------------");
            System.out.println(app.isAppRunning());
        }

    }
}
