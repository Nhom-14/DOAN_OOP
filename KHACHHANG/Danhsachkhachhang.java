/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhsachkhachhang;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author ADMIN
 */
public class Danhsachkhachhang extends Khachhang {
    private Khachhang[] kh;
    private ArrayList<Khachhang> KHlist = new ArrayList<>();
    public static int stt;
    public Danhsachkhachhang(){
        this.KHlist=null;
        stt =0;
        
    }
    public ArrayList<Khachhang> getKHlist(){
        return KHlist;
    }
    public void setKHlist(ArrayList<Khachhang> KHlist){
        this.KHlist = KHlist;
    }
    public void DocFIle(){

    }
    public void GhiFile(){
        
    }
    public void ThemKhachhang(){
            Khachhang kh = new Khachhang();
            System.out.printf("Nhap thong tin khach hang: ");
            kh.input();
            KHlist.add(kh);
            
       
        
    }
    public void XoaKhachhang(){    
       int index = -1;
           System.out.printf("Nhap ma khach hang can xoa: ");
           String id = sc.nextLine();
        for(int j=0;j<KHlist.size();j++){
            if(KHlist.get(j).getmakh().equalsIgnoreCase(id)){
                index = j;
           
        }
        if(index == -1)
            System.out.println("Khong tim thay khach hang");
        else KHlist.remove(index);
       }
       
       
    }
    public void TimKhachhang(){
         System.out.printf("Nhap ma khach hang can xoa: ");
         String id = sc.nextLine();
         int index = -1;
        for(int i=0;i<KHlist.size();i++){
            if(KHlist.get(i).getmakh().equalsIgnoreCase(id)){
                    index = i;
            }
        }
        if (index==-1)
            System.out.println("Khong tim thay khach hang.");
        else KHlist.get(index).output();
    }
    public Khachhang Timkh(){
        Khachhang timkiem = new Khachhang();
          System.out.printf("Nhap ma khach hang can xoa: ");
         String id = sc.nextLine();
         int index = -1;
        for(int i=0;i<KHlist.size();i++){
            if(KHlist.get(i).getmakh().equalsIgnoreCase(id)){
                    index = i;
                    timkiem = KHlist.get(i);
                    
            }
        }
            return timkiem;
    }
    
    
    public void SuaKhachhang(){
        System.out.println("Nhap ma khach hang can sua: ");
        String id = sc.nextLine();
        int index = -1;
        for(int i = 0; i<KHlist.size();i++){
            index = i;
        }
        if(index == -1){
            System.out.println("Khong tim thay khach hang.");
        }
        else KHlist.get(index).input();
    }
    public void XuatDanhsach(){
        if(KHlist.size()==0){
            System.out.println("Khong co khach hang trong danh sach.\n");
            return;
        }
        for(int i = 0 ; i< KHlist.size() ; i++){
            Khachhang kh = KHlist.get(i);
            kh.output();
        }
    }
    public void menu(){
        int k;
        do{
              System.out.println("|----------------------------MENU----------------------------|");
              System.out.println("1.Them khach hang.");
              System.out.println("2.Xoa khach hang.");
              System.out.println("3.Tim khach hang.");
              System.out.println("4.Sua thong tin khach hang.");
              System.out.println("5.Xuat danh sach khach hang.");
              System.out.println("6.Exit");
              System.out.println("Nhap lua chon: ");
              k= sc.nextInt();
              switch(k){
                      case(1):
                          ThemKhachhang();
                          break;
                      case(2):
                          XoaKhachhang();
                          break;
                      case(3):
                          TimKhachhang();
                          break;
                     case(4):
                         SuaKhachhang();
                         break;
                     case(5):
                         XuatDanhsach();
                         break;
                            
                          
                
                      }        
    }while(k !=6);
}
}


