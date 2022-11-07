import java.util.Scanner;

public class Address {
    private String SoNha;
    private String Duong;
    private String Phuong_xa;
    private String Quan_Huyen;
    private String Tinh_TP;
    static Scanner sc = new Scanner(System.in);

    public Address() {
        SoNha = null;
        Duong = null;
        Phuong_xa = null;
        Quan_Huyen = null;
        Tinh_TP = null;
    }

    public Address(String sn, String d, String p, String q, String tp) {
        this.SoNha = sn;
        this.Duong = d;
        this.Phuong_xa = p;
        this.Quan_Huyen = q;
        this.Tinh_TP = tp;
    }

    public Address(Address orther) {
        this.SoNha = orther.SoNha;
        this.Duong = orther.Duong;
        this.Phuong_xa = orther.Phuong_xa;
        this.Quan_Huyen = orther.Quan_Huyen;
        this.Tinh_TP = orther.Tinh_TP;
    }

    public void setSoNha(String soNha) {
        SoNha = soNha;
    }

    public String getSoNha() {
        return SoNha;
    }

    public void setDuong(String duong) {
        Duong = duong;
    }

    public String getDuong() {
        return Duong;
    }

    public void setPhuong_xa(String phuong_xa) {
        Phuong_xa = phuong_xa;
    }

    public String getPhuong_xa() {
        return Phuong_xa;
    }

    public void setQuan_Huyen(String quan_Huyen) {
        Quan_Huyen = quan_Huyen;
    }

    public String getQuan_Huyen() {
        return Quan_Huyen;
    }

    public void setTinh_TP(String tP) {
        Tinh_TP = tP;
    }

    public String getTinh_TP() {
        return Tinh_TP;
    }

    public void inAddress() {
        System.out.print("So nha: ");
        setSoNha(sc.nextLine());
        System.out.print("Ten duong: ");
        setDuong(sc.nextLine());
        System.out.print("Phuong, xa: ");
        setPhuong_xa(sc.nextLine());
        System.out.print("Quan, huyen: ");
        setQuan_Huyen(sc.nextLine());
        System.out.print("Tinh, thanh pho: ");
        setTinh_TP(sc.nextLine());
    }

    public String toString() {
        return SoNha + " " + Duong + " " + Phuong_xa + " " + Quan_Huyen + " " + Tinh_TP;
    }
}