
public class PartTime extends NhanVien{
    private int GioLam;
    private int LuongCoBanTheoGio;

    public PartTime()
    {
        super();
        GioLam = 0;
        LuongCoBanTheoGio = 0;
    }
    public PartTime(String t, date ns, boolean gt, Address dc, String sdt,String MaNV, int SoNgayNghi,int GioLam,int LuongCoBanTheoGio)
    {
        super(t, ns, gt, dc, sdt, MaNV, SoNgayNghi);
        this.GioLam = GioLam;
        this.LuongCoBanTheoGio = LuongCoBanTheoGio;
    }
    public int getLuongCoBanTheoGio() {
        return LuongCoBanTheoGio;
    }
    public void setLuongCoBanTheoGio(int luongCoBanTheoGio) {
        System.out.println("Nhap luong theo gio: ");
        luongCoBanTheoGio = scn.nextInt();
        this.LuongCoBanTheoGio = luongCoBanTheoGio;
    }
    public int getGioLam() {
        return GioLam;
    }
    public void setGioLam(int gioLam) {
        System.out.println("Nhap gio lam: ");
        GioLam = scn.nextInt();
        this.GioLam = gioLam;
    }
    @Override
    public void nhapNV()
    {
        super.nhapNV();
        setGioLam(GioLam);
        setLuongCoBanTheoGio(LuongCoBanTheoGio);
    }
    @Override
    public void xuatNV()
    {
        super.xuatNV();
        System.out.println("\tGio Lam: "+getGioLam()+"\tLuong theo gio : "+getLuongCoBanTheoGio());
    }
    public double TinhLuong()
    {
        return GioLam*LuongCoBanTheoGio;
    }
    @Override
    public String toString() {
        return super.toString() + "," + getGioLam() + ","  + getLuongCoBanTheoGio();
    }
}
