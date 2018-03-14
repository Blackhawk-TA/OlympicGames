package edu.kit.informatik.admin;

class Admin {
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String password;
    private boolean loggedIn = false;

    /**
     * Constructor for a new admin account
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @param userName The account user name
     * @param password The password of the account
     */
    Admin(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    /**
     * Get the user name of an admin account
     * @return The user name
     */
    String getUserName() {
        return userName;
    }

    /**
     * Get the password of an admin account
     * @return The password
     */
    String getPassword() {
        return password;
    }

    /**
     * Check if the current account is logged in
     * @return true if logged in, else false
     */
    boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * Set if an admin account is logged in or not
     * @param loggedIn True if account should be logged in, false if not
     */
    void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
