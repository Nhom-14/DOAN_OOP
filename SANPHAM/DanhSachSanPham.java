package DoAnHDT;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachSanPham {
    private ArrayList<SanPham> sp;
    public DanhSachSanPham(){
        this.sp=new ArrayList<>();
    }
    public DanhSachSanPham(ArrayList<SanPham> sp){
        this.sp=sp;
    }
    public ArrayList<SanPham> getarrsp(){
        return sp;
    }
    public void ThemSP(){
        Scanner input= new Scanner(System.in);
        System.out.print("Loai san pham:\n");
        System.out.print("1.Food\n");
        System.out.print("2.Drink\n");
        System.out.print("3.Combo\n");
        int choice=input.nextInt();
        switch(choice){
            case 1:{
                Food a=new Food();
                a.nhapSP();
                sp.add(a);
            }
            case 2:{
                Drink a=new Drink();
                a.nhapSP();
                sp.add(a);
            }
            case 3:{
                Combo a=new Combo();
                a.nhapSP();
                sp.add(a);
            }
        }
    }
    public void SuaSPbyMaSP(String masp){
        for(int i=0;i<sp.size();i++){
            SanPham a=new SanPham();
            a=sp.get(i);
            if(a.getMaSP().equals(masp)){
                a.nhapSP();
                sp.set(i,a);
            }
        }         
    }
    public void SuaSPbyTenSP(String tensp){
        for(int i=0;i<sp.size();i++){
            SanPham a=new SanPham();
            a=sp.get(i);
            if(a.getTenSP().equals(tensp)){
                a.nhapSP();
                sp.set(i,a);
            }
        }         
    }
    public void XoaSPbyMaSP(String masp){
        for(int i=0;i<sp.size();i++){
            SanPham a=new SanPham();
            a=sp.get(i);
            if(a.getMaSP().equals(masp)){
                sp.remove(i);
            }
        }
    }
    public void XoaSPbyTenSP(String tensp){
        SanPham a=new SanPham();
        for(int i=0;i<sp.size();i++){
            a=sp.get(i);
            if(a.getTenSP().equals(tensp)){
                sp.remove(i);
            }
        }
    }
    public void XuatSP(){
       //khó vãi loz 
    }
    public void DocGhiFile(){
       //khó vãi loz
    }
    public void TimKiemSPbyMaSP(String masp){
        for(int i=0;i<sp.size();i++){
            SanPham a=new SanPham();
            a=sp.get(i);
            if(a.getMaSP().contains(masp)){
                a.xuatSP();
                System.out.print("\n");
            }
        }
    }
    public void TimKiemSPbyTenSP(String tensp){
        for(int i=0;i<sp.size();i++){
            SanPham a=new SanPham();
            a=sp.get(i);
            if(a.getTenSP().contains(tensp)){
                a.xuatSP();
                System.out.print("\n");
            }
        }
    }
    public static void Menu(){
        Scanner input=new Scanner(System.in);
        System.out.print("-------Quan ly san pham-------");
        System.out.print("\n--------1.Them san pham-------");
        System.out.print("\n--------2.Sua san pham--------");
        System.out.print("\n--------3.Xoa san pham--------");
        System.out.print("\n--------4.Tim kiem------------");
        System.out.print("\n--------5.Xuat san pham-------");
        System.out.print("\n--------6.Doc ghi san pham----");
        System.out.print("\n--------7.Menu chinh----------");
        System.out.print("\nNhap lenh(1-7): ");
        int choice=input.nextInt();
        switch(choice){
            case 1:{
                
            }  
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
        }
    }
    public static void main(String[] args){
        Menu();
    }
}
