import java.util.Scanner;
import java.util.ArrayList;

public class DanhSachNhanVien 
{
    private ArrayList<NhanVien> NVList = new ArrayList<>();
    private int soLuongNV;
    Scanner scn = new Scanner(System.in);
    public DanhSachNhanVien()
    {
        soLuongNV=0;
    }
    public ArrayList<NhanVien> getNVList() {
        return NVList;
    }
    public void setNVList(ArrayList<NhanVien> nVList) {
        NVList = nVList;
    }
    public void ThemNV()
    {
        int choose;
        do{
        System.out.println("|-----------------------------------MENU-----------------------------------|");
        System.out.println("|1.Them vao he thong nhan vien Parttime                                    |");
        System.out.println("|2.Them vao he thong nhan vien Fulltime                                    |");
        System.out.println("|3.Them vao he thong Manager                                               |");
        System.out.println("|4.Thoat                                                                   |");
        System.out.println("|--------------------------------------------------------------------------|");
        System.out.print("Nhap lua chon: ");
        choose = scn.nextInt();
        switch (choose) 
        {
            case 1:
            NhanVien nvPT = new PartTime();
            nvPT.nhapNV();
            NVList.add(nvPT);
            break;
            case 2:
            NhanVien nvFT = new FullTime();
            nvFT.nhapNV();
            NVList.add(nvFT);
            break;
            case 3:
            NhanVien mng = new Manager();
            mng.nhapNV();
            NVList.add(mng);
            break;
            case 4: continue;
        }
            }while(choose != 4);
    }
    public static void main(String[] args) {
        DanhSachNhanVien a = new DanhSachNhanVien();
        a.ThemNV();
        a.TimKiemNV();
    }
    public void XuatNV()
    {
        if (NVList.size() == 0) {
            System.out.println("Khong co nhan vien trong danh sach!");
            return;
        }
        for (int i = 0; i < NVList.size(); i ++ ) 
        {
            NhanVien s = NVList.get(i);
            s.xuatNV();
        }
    }
    public void SuaNV()
    {
        System.out.println("Nhap ma nhan vien cua nhan vien can sua: ");
        String manv = scn.nextLine();
        int index = -1;
        for (int i = 0; i<NVList.size()  ; i++) 
            if (NVList.get(i).getMaNV().equals(manv))
            {
                index = i;
                break;
            }
        if (index == -1) {
            System.out.println("Khong tim thay nhan vien!!");
        } else {
            System.out.println("Chuc vu cua nhan vien:");
            System.out.println("1. Nhan vien part time");
            System.out.println("2. Nhan vien full time");
            System.out.println("3. Manager");
            int choose = scn.nextInt();
            switch (choose) 
            {
                case 1:
                    NhanVien PT = new PartTime();
                    PT.nhapNV();
                    NVList.set(index, PT);
                    break;
                case 2:
                    NhanVien FT = new FullTime();
                    FT.nhapNV();
                    NVList.set(index, FT);
                    break;
                case 3:
                    NhanVien mng = new Manager();
                    mng.nhapNV();
                    NVList.set(index, mng);
                    break;
                default:
                    break;
            }
        }
    }
    public void XoaNV()
    {
        System.out.println("Nhap ma nhan vien cua nhan vien can xoa: ");
        String manv = scn.nextLine();
        int index = -1;
        for (int i = 0; i<NVList.size()  ; i++) 
            if (NVList.get(i).getMaNV().equals(manv))
            {
                index = i;
                break;
            }
        if (index == -1) {
            System.out.println("Khong tim thay nhan vien!!");
        } else {
            NVList.remove(index);
        }
    }
    public void TimKiemNV()
    {
        System.out.println("Nhap ma nhan vien cua nhan vien can tim kiem: ");
        String manv = scn.nextLine();
        int index = -1;
        for (int i = 0; i<NVList.size()  ; i++)
            if (NVList.get(i).getMaNV().equals(manv))
            {
                index = i;
                break;
            }
        if (index == -1) {
            System.out.println("Khong tim thay nhan vien!!");
        } else {
            System.out.println("Chuc vu cua nhan vien:");
            System.out.println("1. Nhan vien part time");
            System.out.println("2. Nhan vien full time");
            System.out.println("3. Manager");
            int choose = scn.nextInt();
            switch (choose) 
            {
                case 1:
                    NhanVien PT = new PartTime();
                    PT.xuatNV();
                    break;
                case 2:
                    NhanVien FT = new FullTime();
                    FT.xuatNV();
                    break;
                case 3:
                    NhanVien mng = new Manager();
                    mng.xuatNV();
                   break;
                default:
                    break;
            }
        }
    }
    public void DocFile()
    {

    }
    public void GhiFile()
    {
        
    }
}

