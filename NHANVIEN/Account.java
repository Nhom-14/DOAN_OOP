package NHANVIEN;

import java.util.Scanner;

public class Account {
    Scanner scn = new Scanner(System.in);
    private String userName;
    private String password;

    public Account() {
        userName = null;
        password = null;
    }

    public Account(String userName, String password, int access) {
        this.userName = userName;
        this.password = password;
    }

    public Account(Account orther) {
        this.userName = orther.userName;
        this.password = orther.password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserName() {
        System.out.println("Username: ");
        setUserName(scn.nextLine());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public void setPassword() {
        System.out.print("Password: ");
        setPassword(scn.nextLine());
    }

    public void NhapTK() {
        setUserName();
        setPassword();
    }
}