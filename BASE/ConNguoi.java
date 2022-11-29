package BASE;

import java.util.Scanner;

public class ConNguoi {
    protected String Ten;
    protected date NgaySinh;
    protected boolean GioiTinh; // nam(0), nữ(1)
    protected String DiaChi;
    protected String SDT;
    public static Scanner input = new Scanner(System.in);

    public ConNguoi() {
        Ten = null;
        NgaySinh = new date();
        GioiTinh = false;
        SDT = null;
    }

    public ConNguoi(String t, date ns, boolean gt, String dc, String sdt) {
        this.Ten = t;
        this.NgaySinh = new date(ns);
        this.GioiTinh = gt;
        this.DiaChi = dc;
        this.SDT = sdt;
    }

    public ConNguoi(ConNguoi orther) {
        this.Ten = orther.Ten;
        this.NgaySinh = new date(orther.NgaySinh);
        this.GioiTinh = orther.GioiTinh;
        this.DiaChi = orther.DiaChi;
        this.SDT = orther.SDT;
    }

    public void setTen(String ten) {
        this.Ten = ten;
    }

    public void setTen() {
        while (true) {
            System.out.print("Ten: ");
            String t = input.nextLine();
            if(error.checkKiTu(t)) {
                setTen(t);
                break;
            } else {
                System.out.println("Khong hop le, khong duoc chua ki tu dac biet hoac de trong.");
            }
        }
    }

    public String getTen() {
        return Ten;
    }

    public void setNgaySinh(date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public void setNgaySinh() {
        System.out.println("Ngay sinh: ");
        NgaySinh.NhapDate();
    }

    public date getNgaySinh() {
        return NgaySinh;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public void setDiaChi() {
        while (true) {
            System.out.print("Dia chi: ");
            String dc = input.nextLine();
            if(error.checkAddress(dc)) {
                setDiaChi(dc);
                break;
            } else {
                System.out.println("Khong hop le, khong duoc chua ki tu dac biet hoac de trong.");
            }
        }
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setGioiTinh(int gt) {
        if (gt == 1) {
            GioiTinh = true;
        } else {
            GioiTinh = false;
        }
    }

    public void setGioiTinh() {
        System.out.print("Gioi tinh (Nam[0], Nu[1]): ");
        int c = error.inputIntNumberError(input.nextLine());
        checkGioiTinh(c);
    }

    public boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setSDT(String sDT) {
        SDT = sDT;
    }

    public void setSDT() {
        while (true) {
            System.out.print("So dien thoai: ");
            String sdt = input.nextLine();
            if(error.checkSDT(sdt)) {
                setSDT(sdt);
                break;
            } else {
                System.out.println("So dien thoai khong hop le, moi nhap lai.");
            }
        }
    }

    public String getSDT() {
        return SDT;
    }

    public void checkGioiTinh(int c) {
        int soLanLam = 1;
        do {
            if (soLanLam > 1) {
                c = Integer.parseInt(input.nextLine());
            }
            if (c == 0 || c == 1) {
                setGioiTinh(c);
            } else {
                System.out.println("Nhap sai, moi nhap lai!");
                System.out.print("Gioi tinh (Nam[0], Nu[1]): ");
                soLanLam++;
            }
        } while (c < 0 || c > 1);
    }

    public void Nhap() {
        setTen();
        setNgaySinh();
        setGioiTinh();
        setDiaChi();
        setSDT();
    }

}
