package com.example.clothify;

public class HomeActivityInstance {
    private static Home_Activity homeActivity;

    public static Home_Activity getHomeActivity() {
        return homeActivity;
    }

    public static void setHomeActivity(Home_Activity activity) {
        homeActivity = activity;
    }
}
