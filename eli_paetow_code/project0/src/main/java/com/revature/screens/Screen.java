package com.revature.screens;

public abstract class Screen {
    /**
     * Displays a particular menu depending on the screen implementation.
     */

    private String name;
    private String route;


    protected Screen(String name, String route){
        this.name = name;
        this.route = route;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public abstract void render();

}


