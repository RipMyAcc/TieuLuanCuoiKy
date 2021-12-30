
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class KhoHangHoaTestDrive {
    static Scanner kiTu = new Scanner(System.in);
    static Scanner so = new Scanner(System.in);
    static KhoHangHoa khoHangHoa;
    public static void main(String[] args) throws ParseException {
        khoHangHoa = new KhoHangHoa();
        menu();
    }
    static void menu() throws ParseException {
        System.out.println("> > > > MENU < < < <");
        System.out.println("1.  Xuất thông tin tất cả sản phẩm trong kho ");
        System.out.println("2.  Thêm sản phẩm vào kho ");
        System.err.println("3.  Xoá 1 sản phẩm trong kho");
        System.out.println("4.  Sửa thông tin 1 sản phẩm trong kho");
        System.out.println("5.  Tìm kiếm sản phẩm");
        System.out.println("6.  Sắp xếp danh sách sản phẩm trong kho");
        System.out.println("7.  Thống kê các sản phẩm trong kho");
        System.out.print("Nhập số: ");
        String number = kiTu.nextLine();
        switch(number){
            case "1": inThongTin(); break;
            case "2": them(); break;
            case "3": menuXoa(); break;
            case "4": menuSua(); break;
            case "5": menuTimKiem(); break;
            case "6": menuSapXep(); break;
            case "7": thongKe(); break;
            default: {
                System.out.println("Số nhập vào không hợp lệ");
                menu();
                break;
            }
        }
    }

    static void menuXoa()throws ParseException{
        System.out.println("> > > > Xoá < < < <");
        System.out.println("1.  Xoá theo tên");
        System.out.println("2.  Xoá theo mã");
        System.out.println("3.  Trở về menu");
        System.out.print("Nhập số: ");
        String number = kiTu.nextLine();
        switch(number){
            case "1": xoaTheoTen();; break;
            case "2": xoaTheoMa(); break;
            case "3": menu(); break;
            default: {
                System.out.println("Số nhập vào không hợp lệ");
                menuXoa();
                break;
            }
        }
    }

    static void menuSua()throws ParseException{
        System.out.println("> > > > Sửa < < < <");
        System.out.println("1.  Sửa theo tên");
        System.out.println("2.  Sửa theo mã");
        System.out.println("3.  Trở về menu");
        System.out.print("Nhập số: ");
        String number = kiTu.nextLine();
        switch(number){
            case "1": suaTheoTen();; break;
            case "2": suaTheoMa(); break;
            case "3": menu(); break;
            default: {
                System.out.println("Số nhập vào không hợp lệ");
                menuSua();
                break;
            }
        }
    }

    static void menuTimKiem()throws ParseException{
        System.out.println("> > > > Tìm kiếm < < < <");
        System.out.println("1.  Tìm kiếm theo loại");
        System.out.println("2.  Tìm kiếm theo giá");
        System.out.println("3.  Tìm kiếm theo khoảng giá");
        System.out.println("4.  Tìm kiếm theo ngày");
        System.out.println("5.  Tìm kiếm theo khoảng ngày");
        System.out.println("6.  Trở về menu");
        System.out.print("Nhập số: ");
        String number = kiTu.nextLine();
        switch(number){
            case "1": ketQuaTimTheoLoai(); break;
            case "2": ketQuaTimTheoGia(); break;
            case "3": ketQuaTimTheoKhoangGia(); break;
            case "4": ketQuaTimTheoNgay(); break;
            case "5": ketQuaTimTheoKhoangNgay(); break;
            case "6": menu(); break;
            default: {
                System.out.println("Số nhập vào không hợp lệ");
                menuTimKiem();
                break;
            }
        }
    }

    static void menuSapXep()throws ParseException{
        System.out.println();
        System.out.println("> > > > Sắp Xếp < < < <");
        System.out.println("1.  Tăng dần theo giá ");
        System.out.println("2.  Tăng dần theo giá và loại ");
        System.out.println("3.  Giảm dần theo giá");
        System.out.println("4.  Giảm dần theo giá và loại");
        System.out.println("5.  Tăng dần theo ngày");
        System.out.println("6.  Tăng dần theo ngày và loại");
        System.out.println("7.  Giảm dần theo ngày");
        System.out.println("8.  Giảm dần theo ngày và loại");
        System.out.println("9.  Trở về Menu");
        System.out.print("Nhập số: ");
        String number = kiTu.nextLine();
        switch(number){
            case "1": sapXepTangDanTheoGia(); break;
            case "2": sapXepTangDanTheoGiaVaLoai(); break;
            case "3": sapXepGiamDanTheoGia(); break;
            case "4": sapXepGiamDanTheoGiaVaLoai(); break;
            case "5": sapXepTangDanTheoNgay(); break;
            case "6": sapXepTangDanTheoNgayVaLoai(); break;
            case "7": sapXepGiamDanTheoNgay(); break;
            case "8": sapXepGiamDanTheoNgayVaLoai(); break;
            case "9": menu(); break;
            default: {
                System.out.println("Số nhập vào không hợp lệ");
                menuSapXep();
                break;
            }
        }
    }

    static void nhanEnter(){
        System.out.println("Nhấn Enter để trở về Menu");
        kiTu.nextLine();
    }

    static void inThongTin() throws ParseException {
        khoHangHoa.inThongTin();
        nhanEnter();
        menu();
    }

    static void them() throws ParseException {
        System.out.println("> > > Thêm sản phẩm vào kho < < <");
        while (true){
            khoHangHoa.them();
            System.out.println("Đã thêm sản phẩm vào trong kho");
            System.out.print("Thêm tiếp sản phẩm ? ( nhập N để thoát ): ");
            if(kiTu.next().equals("N")){
                break;
            }
        } 
        nhanEnter();
        menu();
    }

    static void sapXepTangDanTheoGia()throws ParseException{
        khoHangHoa.sapXepTangDanTheoGia();
        System.out.println("Đã sắp xếp");
        nhanEnter();
        menu();
    }

    static void sapXepTangDanTheoGiaVaLoai()throws ParseException{
        khoHangHoa.sapXepTangDanTheoGiaVaLoai();
        System.out.println("Đã sắp xếp");
        nhanEnter();
        menu();
    }

    static void sapXepGiamDanTheoGia()throws ParseException{
        khoHangHoa.sapXepGiamDanTheoGia();
        System.out.println("Đã sắp xếp");
        nhanEnter();
        menu();
    }

    static void sapXepGiamDanTheoGiaVaLoai()throws ParseException{
        khoHangHoa.sapXepGiamDanTheoGiaVaLoai();
        System.out.println("Đã sắp xếp");
        nhanEnter();
        menu();
    }

    static void sapXepTangDanTheoNgay()throws ParseException{
        khoHangHoa.sapXepTangDanTheoNgay();
        System.out.println("Đã sắp xếp");
        nhanEnter();
        menu();
    }

    static void sapXepTangDanTheoNgayVaLoai()throws ParseException{
        khoHangHoa.sapXepTangDanTheoNgayVaLoai();
        System.out.println("Đã sắp xếp");
        nhanEnter();
        menu();
    }

    static void sapXepGiamDanTheoNgay()throws ParseException{
        khoHangHoa.sapXepGiamDanTheoNgay();
        System.out.println("Đã sắp xếp");
        nhanEnter();
        menu();
    }

    static void sapXepGiamDanTheoNgayVaLoai()throws ParseException{
        khoHangHoa.sapXepGiamDanTheoNgayVaLoai();
        System.out.println("Đã sắp xếp");
        nhanEnter();
        menu();
    }

    static void xoaTheoMa() throws ParseException{
        System.out.print("Nhập mã: ");
        int ma=so.nextInt();
        khoHangHoa.xoaTheoMa(ma);
        nhanEnter();
        menu();
    }

    static void xoaTheoTen() throws ParseException{
        System.out.print("Nhập tên: ");
        String ten=kiTu.nextLine();
        khoHangHoa.xoaTheoTen(ten);
        nhanEnter();
        menu();
    }

    static void suaTheoMa() throws ParseException{
        System.out.print("Nhập mã: ");
        int ma=so.nextInt();
        khoHangHoa.suaTheoMa(ma);
        nhanEnter();
        menu();
    }

    static void suaTheoTen() throws ParseException{
        System.out.print("Nhập tên: ");
        String ten=kiTu.nextLine();
        khoHangHoa.suaTheoTen(ten);
        nhanEnter();
        menu();
    }

    static void ketQuaTimTheoLoai() throws ParseException{
        System.out.print("Nhập loại ( thuc pham / sanh su / dien may ): ");
        String loai=kiTu.nextLine();
        khoHangHoa.ketQuaTimTheoLoai(loai);
        nhanEnter();
        menu();
    }

    static void ketQuaTimTheoGia() throws ParseException{
        System.out.print("Nhập giá: ");
        double gia=so.nextDouble();
        khoHangHoa.ketQuaTimTheoGia(gia);
        nhanEnter();
        menu();
    }

    static void ketQuaTimTheoKhoangGia() throws ParseException{
        System.out.print("Nhập khoảng giá đầu: ");
        double giaDau=so.nextDouble();
        System.out.print("Nhập khoảng giá sau: ");
        double giaSau=so.nextDouble();
        khoHangHoa.ketQuaTimTheoKhoangGia(giaDau, giaSau);
        nhanEnter();
        menu();
    }

    static Date chuyenChuoiSangNgay(String chuoiNgay) throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat.parse(chuoiNgay);
        return date;
    }

    static void ketQuaTimTheoNgay() throws ParseException{
        System.out.print("Nhập ngày (dd/mm/yyyy ):");
        String chuoiNgay = kiTu.nextLine();
        khoHangHoa.ketQuaTimTheoNgay(chuyenChuoiSangNgay(chuoiNgay));
        nhanEnter();
        menu();
    }

    static void ketQuaTimTheoKhoangNgay() throws ParseException{
        System.out.print("Nhập khoảng ngày đầu (dd/mm/yyyy ): ");
        String ngayDau=kiTu.nextLine();
        System.out.print("Nhập khoảng ngày sau (dd/mm/yyyy ): ");
        String ngaySau=kiTu.nextLine();
        khoHangHoa.ketQuaTimTheoKhoangNgay(chuyenChuoiSangNgay(ngayDau), chuyenChuoiSangNgay(ngaySau));
        nhanEnter();
        menu();
    }

    static void thongKe() throws ParseException{
        System.out.println("> > > > Thống kê < < < <");
        khoHangHoa.thongKe();
        nhanEnter();
        menu();
    }
}
