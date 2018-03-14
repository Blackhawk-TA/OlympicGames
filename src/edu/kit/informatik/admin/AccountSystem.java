package edu.kit.informatik.admin;

import java.util.ArrayList;
import java.util.List;

public class AccountSystem {
    private List<Admin> accounts = new ArrayList<>();

    /**
     * Login into an admin account
     * @param userName The account's user name
     * @param password The account's password
     * @return String, OK if successful, else error message
     */
    public String login(String userName, String password) {
        boolean alreadyLoggedIn = adminActive();

        if (!alreadyLoggedIn) {
            boolean loginSuccess = false;
            for (Admin account: accounts) {
                if (account.getUserName().equals(userName) && account.getPassword().equals(password)) {
                    account.setLoggedIn(true);
                    loginSuccess = true;
                }
            }
            if (loginSuccess) {
                return "OK";
            } else {
                return "Error, wrong user data, account not found.";
            }
        } else {
            return "Error, there is already an admin logged in.";
        }
    }

    /**
     * Add admin account to the system
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @param userName The account user name
     * @param password The password of the account
     * @return String output. OK if successful, else error message
     */
    public String addAccount(String firstName, String lastName, String userName, String password) {
        accounts.add(new Admin(firstName, lastName, userName, password));
        return "OK";
    }

    /**
     * Check if an admin is logged in at the moment
     * @return true if admin is logged in, else false
     */
    public boolean adminActive() { //TODO improve performance if possible
        boolean alreadyLoggedIn = false;
        for (Admin account: accounts) {
            if (account.isLoggedIn()) {
                alreadyLoggedIn = true;
            }
        }
        return alreadyLoggedIn;
    }
}
