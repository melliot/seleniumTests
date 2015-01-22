package com.uitest.ss.location;

public class Users {
    public static String mainUserButton = "//a[@href = '#users']";
    public static String newButton = "//*[contains (@href, '#users/new')]";
    public static String editButton = "//a[contains(@data-original-title, 'Edit')]";
    public static String removeButton = "//button[contains(@data-button, 'remove')]";
    public static String usernameField = "//*[@id='username']";
    public static String emailField = "//*[@id='email']";
    public static String passwordField = "//*[@id='password']";
    public static String confirmPassField = "//*[@id='confirm_password']";
    public static String role = "//*[@id='roles']";
    public static String submitButton = "//button[@data-action='submit']";
    public static String cancelButton = "//a[@href='#users' and contains(text(), 'Cancel')]";
}
