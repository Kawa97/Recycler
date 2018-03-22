package com.example.corsista.recycler;

/**
 * Created by corsista on 19/03/2018.
 */

public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private String activeManager;

    public String getActiveManager() {
        return activeManager;
    }

    public void setActiveManager(String activeManager) {
        this.activeManager = activeManager;
    }
}

