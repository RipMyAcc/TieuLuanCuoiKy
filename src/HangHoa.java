
import java.text.SimpleDateFormat;
import java.util.Date;

public class HangHoa {
    String type;
    int id;
    String name;
    double price;
    int amount;
    Date date;

    HangHoa(){
    }

    HangHoa(String loai, int ma, String ten, double gia, int soluong, Date ngay){
        type=loai;
        id=ma;
        name=ten;
        price=gia;
        amount=soluong;
        date=ngay;
    }

    public void inThongTin(){
        System.out.println("-------------------");
        System.out.println("Loại: "+type);
        System.out.println("Mã: "+id);
        System.out.println("Tên: "+name);
        System.out.println("Giá: "+price);
        System.out.println("Số lượng: "+amount);
        System.out.println("Ngày: "+chuyenNgaySangChuoi(date));
    }

    public String chuyenNgaySangChuoi(Date date){
        String chuoiNgayViet = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        chuoiNgayViet =  simpleDateFormat.format(date);
        return chuoiNgayViet;
    }
}
