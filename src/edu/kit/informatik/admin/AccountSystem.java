package edu.kit.informatik.admin;

import java.util.ArrayList;
import java.util.List;

public class AccountSystem {
    private final List<Admin> accounts = new ArrayList<>();

    /**
     * Login into an admin account
     * @param userName The account's user name
     * @param password The account's password
     * @return String, OK if successful, else error message
     */
    public String login(String userName, String password) {
        if (!adminActive()) {
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
     * Logout from an account
     * @return String, OK if successful, else error message
     */
    public String logout() {
        if (adminActive()) {
            for (Admin account : accounts) {
                if (account.isLoggedIn()) {
                    account.setLoggedIn(false);
                    return "OK";
                }
            }
            return "Error, there is currently no user logged in.";
        } else {
            return "Error, there is currently no user logged in.";
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
        if (getIndex(userName) == -1) {
            accounts.add(new Admin(firstName, lastName, userName, password));
            return "OK";
        } else {
            return "Error, this account already exists.";
        }
    }

    /**
     * Check if an admin is logged in at the moment
     * @return true if admin is logged in, else false
     */
    public boolean adminActive() {
        boolean alreadyLoggedIn = false;
        for (Admin account: accounts) {
            if (account.isLoggedIn()) {
                alreadyLoggedIn = true;
            }
        }
        return alreadyLoggedIn;
    }

    /**
     * Get the index of the item where the requested id is located
     * @param id The id to search for
     * @return The id if found, else -1
     */
    private int getIndex(String id) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
