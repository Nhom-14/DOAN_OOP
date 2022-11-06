/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khachhang;

import java.util.Scanner;
/**
 *
 * @author ADMIN
 */
public class Khachhang {
       private String makh;
       private String tenkh;
       private String sdt;
       private String diachi;
       private int namsinh;

    public Scanner sc = new Scanner(System.in);
    public Khachhang(){}
    
    public Khachhang(String makh, String tenkh, String sdt, String diachi,int namsinh){
        this.makh = makh;
        this.tenkh = tenkh;
        this.sdt = sdt;
        this.diachi = diachi;
        this.namsinh = namsinh;
    }
    
    public String getmakh(){
        return makh;}
    public void setmakh(String makh){
        System.out.println("Nhap ma khach hang: ");
        makh = sc.nextLine();
        this.makh = makh;
    }
    public String gettenkh(){
        return tenkh;
    }
    public void settenkh(String tenkh){
        System.out.println("Nhap ten khach hang: ");
        tenkh = sc.nextLine();
        this.tenkh = tenkh;
    }
    public String getsdt(){
        return sdt;}
    public void setsdt(String sdt){
        System.out.println("Nhap so dien thoai: ");
        sdt = sc.nextLine();
        this.sdt = sdt;
    }
    public String getdiachi(){
        return diachi;}
    public void setdiachi(String diachi){
        System.out.println("Nhap dia chi: ");
        diachi = sc.nextLine();
        this.diachi = diachi;
    }
    public int getnamsinh(){
        return namsinh;}
    public void setnamsinh(int namsinh){
        System.out.println("Nhap nam sinh: ");
        namsinh = sc.nextInt();
        this.namsinh = namsinh;
    }
    
    public void input(){
        setmakh(makh);
        settenkh(tenkh);
        setsdt(sdt);
        setdiachi(diachi);
        setnamsinh(namsinh);
    }
    public void output(){
        System.out.printf("%-15s%-15s%-15s%-15s%-15s","Ma khach hang", "Ten khach hang", "So dien thoai","Dia chi", "Nam sinh" );
        System.out.printf("%-15s%-15s%-15s%-15s%-15d", getmakh(),gettenkh(),getsdt(),getdiachi(),getnamsinh());
        
    

    
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
