import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConNguoi {
    private String ten;
    private date NgaySinh;
    private boolean GioiTinh; // nam(0), nữ(1)
    private Address DiaChi;
    private String SDT;
    static Scanner sc = new Scanner(System.in);

    public ConNguoi() {
        ten = null;
        NgaySinh = new date();
        GioiTinh = false;
        DiaChi = new Address();
        SDT = null;
    }

    public ConNguoi(String t, date ns, boolean gt, Address dc, String sdt) {
        this.ten = t;
        this.NgaySinh = new date(ns);
        this.GioiTinh = gt;
        this.DiaChi = new Address(dc);
        this.SDT = sdt;
    }

    public ConNguoi(ConNguoi orther) {
        this.ten = orther.ten;
        this.NgaySinh = new date(orther.NgaySinh);
        this.GioiTinh = orther.GioiTinh;
        this.DiaChi = new Address(orther.DiaChi);
        this.SDT = orther.SDT;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public void setNgaySinh(date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public date getNgaySinh() {
        return NgaySinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setDiaChi(Address diaChi) {
        DiaChi = diaChi;
    }

    public Address getDiaChi() {
        return DiaChi;
    }

    public void setSDT(String sDT) {
        SDT = sDT;
    }

    public String getSDT() {
        return SDT;
    }

    public void checkGioiTinh(int c) {
        int soLanLam = 1;
        do {
            if(soLanLam > 1) {
                c = Integer.parseInt(sc.nextLine());
            }
            if (c == 0) {
                setGioiTinh(false);
            } else if (c == 1) {
                setGioiTinh(true);
            } else {
                System.out.println("Nhap sai, moi nhap lai!");
                System.out.print("Gioi tinh (Nam[0], Nu[1]): ");
                soLanLam++;
            }
        } while (c < 0 || c > 1);
    }

    public void checkSDT(String s) {
        boolean trueInput = true;
        String ddsdt = "^0[3|5|7|8|9]\\d{8}$";
        Pattern pattern = Pattern.compile(ddsdt);
        Matcher matcher;
        do {
            matcher = pattern.matcher(s);
            if (matcher.find()) {
                trueInput = true;
                System.out.println("Nhap thanh cong");
                setSDT(s);
            } else {
                trueInput = false;
                System.out.println("Da nhap sai moi nhap lai: ");
                System.out.print("So dien thoai: ");
                s = sc.nextLine();
            }
        } while (trueInput == false);
    }

    public void nhap() {
        System.out.print("Ten: ");
        setTen(sc.nextLine());
        System.out.println("Ngay sinh: ");
        NgaySinh.NhapDate();
        System.out.print("Gioi tinh (Nam[0], Nu[1]): ");
        int c = Integer.parseInt(sc.nextLine());
        checkGioiTinh(c);
        System.out.println("Dia chi: ");
        DiaChi.inAddress();
        System.out.print("So dien thoai: ");
        checkSDT(sc.nextLine());
    }


}