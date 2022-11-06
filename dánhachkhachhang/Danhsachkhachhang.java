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
public class Danhsachkhachhang extends Khachhang {
    private Khachhang[] kh;
    public static int stt;
    public Danhsachkhachhang(){
        kh=null;
        stt =0;
        kh = new Khachhang[100];
    }
    public void DocFIle(){

    }
    public void GhiFile(){
        
    }
    public void ThemKhachhang(){
        int n;
        System.out.println("Nhap so luong khach hang can them: ");
        n = Integer.parseInt(sc.nextLine());
        Khachhang[] newkh = new Khachhang[n];
        for(int i = 0; i <n;i++){
            newkh[i] = new Khachhang();
            System.out.printf("Nhap thong tin cua khach hang %d",i+1);
            newkh[i].input();
        }
        
    }
    public void XoaKhachhang(){
       int n;
       System.out.println("Nhap so luong khach hang can xoa: ");
       n = Integer.parseInt(sc.nextLine());
       for(int i = 0;i<n;i++){
           System.out.printf("Nhap ma khach hang cua khach hang %d de xoa: ", i+1);
           String id = sc.nextLine();
        for(int j=0;j<stt;j++){
            if(kh[j].getmakh().equalsIgnoreCase(id)){
                for(int k = j;k<stt-1;k++){
                    kh[k]=kh[k+1];
                }
                stt--;
            }
        }   
       }
       
       
    }
    public void TimKhachhang(String id){
        int count = 0;
        for(int i=0;i<stt;i++){
            if(kh[i].getmakh().equalsIgnoreCase(id)){
                kh[i].output();
                count++;
            }
        }
        if (count==0)
            System.out.println("Khong tim thay khach hang.");
    }
    public void XuatDanhsach(){
        for(int i = 0; i < stt;i++){
            System.out.printf("Khach hang thu %d:\n", i+1);
            kh[i].output();
        }
    }
}

