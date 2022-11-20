package NHANVIEN;

import java.util.Scanner;

public class Account {
    Scanner scn = new Scanner(System.in);
    private String userName;
    private String password;
    private int access;

    public Account(){
        userName = null;
        password = null;
        access = 0;
    }
    public Account(String userName, String password, int access){
        this.userName = userName;
        this.password = password;
        this.access = access;
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
        System.out.println("Password: ");
        setPassword(scn.nextLine());
    }
    

    public int getAccess() {
        return access;
    }
    public void setAccess(int access) {
        this.access = access;
    }
    public void NhapTK()
    {
        setUserName();
        setPassword();
    }
}