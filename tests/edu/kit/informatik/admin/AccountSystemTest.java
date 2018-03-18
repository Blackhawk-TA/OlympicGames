package edu.kit.informatik.admin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountSystemTest {
    private AccountSystem system;

    @Before
    public void setUp() {
        system = new AccountSystem();
        system.addAccount("firstName1", "lastName1", "user1", "password1");
        system.addAccount("firstName2", "lastName2", "user2", "password2");
        system.addAccount("firstName3", "lastName3", "user3", "password3");
        system.addAccount("firstName4", "lastName4", "user4", "password4");
    }

    @After
    public void tearDown() {
        system = null;
    }

    @Test
    public void login() {
        String ex1 = "Error, wrong user data, account not found.";
        String ex2 = "Error, there is already an admin logged in.";
        assertEquals("Failed login", ex1, system.login("test0", "password1"));
        assertEquals("Failed login", ex1, system.login("test1", "wrong"));
        assertEquals("Successful login", "OK", system.login("user1", "password1"));
        assertEquals("Failed login", ex2, system.login("test2", "password2"));
    }

    @Test
    public void logout() {
        String ex = "Error, there is currently no user logged in.";
        assertEquals("Failed logout", ex, system.logout());

        assertEquals("Successful login", "OK", system.login("user4", "password4"));
        assertEquals("Successful logout", "OK", system.logout());

        assertEquals("Failed logout", ex, system.logout());
    }

    @Test
    public void addAccount() {
        String ex = "Error, this account already exists.";
        assertEquals("Create failed", ex, system.addAccount("abc", "def", "user3", "thisIsATest1"));
        assertEquals("Create failed", ex, system.addAccount("firstName3", "lastName3", "user3", "password3"));
        assertEquals("Create successful", "OK", system.addAccount("firstName3", "lastName3", "user5", "password3"));
        assertEquals("Create failed", ex, system.addAccount("abc", "def", "user4", "password32"));
    }

    @Test
    public void adminActive() {
        assertFalse(system.adminActive());

        system.login("user3", "password3");
        assertTrue(system.adminActive());

        system.logout();
        assertFalse(system.adminActive());
    }
}