
public class FullTime extends NhanVien{
    private int NgayCong;
    private int LuongCoBan;

    public FullTime()
    {
        super();
        NgayCong = 0;
        LuongCoBan = 0;
    }
    public FullTime(String t, date ns, boolean gt, Address dc, String sdt,String MaNV, int SoNgayNghi,int NgayCong,int LuongCoBan)
    {
        super(t, ns, gt, dc, sdt, MaNV, SoNgayNghi);
        this.NgayCong = NgayCong;
        this.LuongCoBan = LuongCoBan;
    }
    public int getLuongCoBan() {
        return LuongCoBan;
    }
    public void setLuongCoBan(int luongCoBan) {
        System.out.println("Nhap luong theo gio: ");
        luongCoBan = scn.nextInt();
        this.LuongCoBan = luongCoBan;
    }
    public int getNgayCong() {
        return NgayCong;
    }
    public void setNgayCong(int ngayCong) {
        System.out.println("Nhap gio lam: ");
        NgayCong = scn.nextInt();
        this.NgayCong = ngayCong;
    }
    @Override
    public void nhapNV()
    {
        super.nhapNV();
        setNgayCong(NgayCong);
        setLuongCoBan(LuongCoBan);
    }
    @Override
    public void xuatNV()
    {
        super.xuatNV();
        System.out.println("\tNgay Cong: "+getNgayCong()+"\tLuong co ban: "+getLuongCoBan());
    }
    @Override
    public double TinhLuong()
    {
        return LuongCoBan/27*(NgayCong);
        //Lương phải trả = Mức lương tháng : Số ngày phải đi làm quy định x số ngày đi làm thực tế
    }
    @Override
    public String toString() {
        return super.toString() + ";" + getNgayCong() + "," + getLuongCoBan();
    }
}

