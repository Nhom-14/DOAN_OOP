import java.util.Calendar;
import java.util.Scanner;

public class date  {
    private int ngay;
    private int thang;
    private int nam;
    static Scanner sc = new Scanner(System.in);

    public date() {
        ngay = 0;
        thang = 0;
        nam = 0;
    }

    public date(date orther) {
        this.ngay = orther.ngay;
        this.thang = orther.thang;
        this.nam = orther.nam;
    }

    public date(int d, int m, int y) {
        this.ngay = d;
        this.thang = m;
        this.nam = y;
    }

    public void Today() {
        Calendar t = Calendar.getInstance();
        nam = t.get(Calendar.YEAR);
        thang = t.get(Calendar.MONTH) + 1;
        ngay = t.get(Calendar.DAY_OF_MONTH);
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getNam() {
        return nam;
    }

    public int getNgay() {
        return ngay;
    }

    public int getThang() {
        return thang;
    }

    boolean checkYear(int year) {
        return (((year % 4 == 0) && (year % 100 != 0)) ||
                (year % 400 == 0));
    }

    void checkDay(boolean nn) {
        int DayinT2;
        if (nn == true) {
            DayinT2 = 29;
        } else {
            DayinT2 = 28;
        }
        switch (thang) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                do {
                    System.out.print("Nhap ngay: ");
                    setNgay(Integer.parseInt(sc.nextLine()));
                    if (ngay > 30 || ngay < 1) {
                        System.out.println("Ngay khong hop le, moi nhap lai!");
                    }
                } while (ngay > 30 || ngay < 1);
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11: {
                do {
                    System.out.print("Nhap ngay: ");
                    setNgay(Integer.parseInt(sc.nextLine()));
                    if (ngay > 31 || ngay < 1) {
                        System.out.println("Ngay khong hop le, moi nhap lai!");
                    }
                } while (ngay > 31 || ngay < 1);
                break;
            }
            default: {
                do {
                    System.out.print("Nhap ngay: ");
                    setNgay(Integer.parseInt(sc.nextLine()));
                    if (ngay > DayinT2 || ngay < 1) {
                        System.out.println("Ngay khong hop le, moi nhap lai!");
                    }
                } while (ngay > DayinT2 || ngay < 1);
            }
        }
    }

    public void NhapDate() {
        System.out.print("Nhap nam: ");
        setNam(Integer.parseInt(sc.nextLine()));
        do {
            System.out.print("Nhap thang: ");
            setThang(Integer.parseInt(sc.nextLine()));
            if (thang > 12 || thang < 1) {
                System.out.println("Thang khong hop le, moi nhap lai!");
            }
        } while (thang < 1 || thang > 12);
        checkDay(checkYear(nam));
    }

    public String toString() {
        return ngay + "/" + thang + "/" + nam;
    }
    
}