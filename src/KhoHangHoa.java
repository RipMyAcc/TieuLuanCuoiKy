
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class KhoHangHoa {
    KhoHangHoa() throws ParseException{
        
        trongKho("thuc pham", 1001, "ga", 20000, 6, "21/1/2021");
        trongKho("thuc pham", 1005, "thit bo", 22200, 15, "1/1/2021");
        trongKho("thuc pham", 1003, "ca", 17300, 85, "13/1/2000");
        trongKho("thuc pham", 1002, "thit heo", 21500, 53, "1/4/2021");
        trongKho("thuc pham", 1004, "rau muong", 3000, 91, "1/6/2021");
        trongKho("thuc pham", 1006, "khoai tay", 3000, 78, "7/5/2021");
        trongKho("sanh su", 2007, "to", 10080, 19, "5/7/2000");
        trongKho("sanh su", 2008, "dia", 12099, 28, "15/3/2000");
        trongKho("sanh su", 2009, "lo", 9067, 20, "1/3/2000");
        trongKho("sanh su", 2010, "dua", 3333, 100, "1/3/2000");
        trongKho("sanh su", 2011, "muong", 5678, 80, "29/8/2000");
        trongKho("dien may", 3012, "tivi", 20100000, 19, "5/7/2002");
        trongKho("dien may", 3013, "tu lanh", 32000000, 19, "1/7/2019");
        trongKho("dien may", 3014, "quat", 350000, 19, "5/3/2021");
        trongKho("dien may", 3015, "may lanh", 15000000, 19, "19/12/2020");
        trongKho("dien may", 3016, "lo vi song", 19000000, 19, "7/7/2021");
        trongKho("dien may", 3017, "noi com", 3000000, 19, "13/1/2000");
        trongKho("dien may", 3018, "bep dien", 13000000, 19, "5/7/2005");
        trongKho("dien may", 3019, "may ep", 2700000, 19, "21/7/2014");
        trongKho("dien may", 3020, "may giat", 17000000, 19, "5/1/2016");
        
    }

    Node head=null;
    Node tail=null;
    Scanner kiTu = new Scanner(System.in);
    Scanner so = new Scanner(System.in);

    Node dienThongTin() throws ParseException{
        System.out.print("Nhập loại ( thuc pham/sanh su/dien may ): ");
        String loai = kiTu.nextLine();
        System.out.print("Nhập mã: ");
        int ma = so.nextInt();
        System.out.print("Tên: ");
        String ten = kiTu.nextLine();
        System.out.print("Giá: ");
        double gia = so.nextDouble();
        System.out.print("Số lượng: ");
        int soluong = so.nextInt();
        System.out.print("Ngày nhập kho ( dd/mm/yyyy ): ");
        String chuoiNgay = kiTu.nextLine();
        Date ngay = chuyenChuoiSangNgay(chuoiNgay);
        HangHoa duLieu = new HangHoa(loai, ma, ten, gia, soluong, ngay);
        Node node = new Node(duLieu);
        return node;
    }

    Date chuyenChuoiSangNgay(String chuoiNgay) throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat.parse(chuoiNgay);
        return date;
    }

    void trongKho(String loai,int ma,String ten,double gia,int soluong,String chuoiNgay) throws ParseException{
        Date ngay = chuyenChuoiSangNgay(chuoiNgay);
        HangHoa duLieu = new HangHoa(loai, ma, ten, gia, soluong, ngay);
        Node node = new Node(duLieu);
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            tail.next=node;
            tail=node;
        }
    }

    void them() throws ParseException{
        Node node = dienThongTin();
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            tail.next=node;
            tail=node;
        }
    }

    boolean khoRong(){
        boolean rong = false;
        if(head==null){
            System.out.println("Kho rỗng");
            rong=true;
        }
        return rong;
    }

    void inThongTin(){
        if(khoRong()==true){
        }
        else{
            Node current=head;
            while(current!=null){
                current.data.inThongTin();
                current=current.next;
            }
        }
    }

    void doiCho(Node mot, Node hai){
        Node ba= new Node();
        ba.data=mot.data;
        mot.data=hai.data;
        hai.data=ba.data;

    }

    void sapXepTangDanTheoGiaVaLoai(){
        Node current = head;
        Node check;
        Node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if((check.data.price<save.data.price) && (check.data.type.equals(save.data.type))){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void sapXepTangDanTheoGia(){
        Node current = head;
        Node check;
        Node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if(check.data.price<save.data.price){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void sapXepGiamDanTheoGiaVaLoai(){
        Node current = head;
        Node check;
        Node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if((check.data.price>save.data.price) && (check.data.type.equals(save.data.type))){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void sapXepGiamDanTheoGia(){
        Node current = head;
        Node check;
        Node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if(check.data.price>save.data.price){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void sapXepTangDanTheoNgayVaLoai(){
        Node current = head;
        Node check;
        Node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if((check.data.date.before(save.data.date)) && (check.data.type.equals(save.data.type))){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void sapXepTangDanTheoNgay(){
        Node current = head;
        Node check;
        Node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if(check.data.date.before(save.data.date)){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void sapXepGiamDanTheoNgayVaLoai(){
        Node current = head;
        Node check;
        Node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if((check.data.date.after(save.data.date)) && (check.data.type.equals(save.data.type))){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void sapXepGiamDanTheoNgay(){
        Node current = head;
        Node check;
        Node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if(check.data.date.after(save.data.date)){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    Node timKiemTheoTen(String ten){
        Node current = head;
        if(khoRong()==true){

        }
        else{
            while(current!=null){
                if(current.data.name.equals(ten)){
                    current.data.inThongTin();
                    return current;
                }
                current=current.next;
            }
        }
        System.out.println("Không tìm thấy");
        return null;
    }

    void sapXepTangDanTheoMa(){
        Node current = head;
        Node check;
        Node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if(check.data.id<save.data.id){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    Node timKiemTheoMa(int ma){
        sapXepTangDanTheoMa();
        Node left=head;
        Node right=tail;
        Node current;
        int dem;
        while(left!=right){
            current=left;
            dem=1;
            while(current!=right){
                dem++;
                current=current.next;
            }
            dem=(dem-1)/2;
            current=left;
            for(int i=1;i<=dem;i++){
                current=current.next;
            }
            if(current.data.id==ma){
                current.data.inThongTin();
                return current;
            }
            if(current.data.id<ma){
                left=current.next;
            }
            else{
                current=left;
                while(current.next!=right){
                    current=current.next;
                }
                right=current;
            }
        }
        current=left;
        if(current.data.id==ma){
            current.data.inThongTin();
            return current;
        }
        System.out.println("Không tìm thấy");
        return null;
    }

    void xoa(Node current){
        if(current==head){
            head=head.next;
        }
        else if(current==tail){
            current = head;
            while(current!=null){
                if(current.next==tail){
                    tail=current;
                    tail.next=null;
                    break;
                }
                current=current.next;
            }
        }
        else{
            Node previous=head;
            while(previous!=null){
                if(previous.next==current){
                    break;
                }
                previous=previous.next;
            }
            current=current.next;
            previous.next=current;
        }
        System.out.println("Đã xoá sản phẩm trên");
    }

    void xoaTheoMa(int ma){
        Node current = timKiemTheoMa(ma);
        if(current==null){

        }
        else{
            xoa(current);
        }
    }

    void xoaTheoTen(String ten){
        Node current=timKiemTheoTen(ten);
        if(current==null){

        }
        else{
            xoa(current);
        }
    }

    void sua(Node current)throws ParseException{
        System.out.print("Nhập loại ( thuc pham/sanh su/dien may ): ");
        String loai = kiTu.nextLine();
        System.out.print("Tên: ");
        String ten = kiTu.nextLine();
        System.out.print("Giá: ");
        double gia = so.nextDouble();
        System.out.print("Số lượng: ");
        int soluong = so.nextInt();
        System.out.print("Ngày nhập kho ( dd/mm/yyyy ): ");
        String chuoiNgay = kiTu.nextLine();
        Date ngay = chuyenChuoiSangNgay(chuoiNgay);
        current.data.type=loai;
        current.data.name=ten;
        current.data.price=gia;
        current.data.amount=soluong;
        current.data.date=ngay;
        System.out.println("Đã sửa thông tin");
        current.data.inThongTin();
    }

    void suaTheoMa(int ma) throws ParseException{
        Node current = timKiemTheoMa(ma);
        if(current==null){

        }
        else{
            sua(current);
        }
    }

    void suaTheoTen(String ten) throws ParseException{
        Node current = timKiemTheoTen(ten);
        if(current==null){

        }
        else{
            sua(current);
        }
    }

    void ketQuaTimTheoLoai(String loai){
        Node current = head;
        if(khoRong()==true){

        }
        else{
            boolean co=false;
            while(current!=null){
                if(current.data.type.equals(loai)){
                    current.data.inThongTin();
                    co=true;
                }
                current=current.next;
            }
            if(co==false){
                System.out.println("Không tìm thấy");
            }
        }
    }
    /*
    Node timTheoGia(double gia){
        Node left=head;
        Node right=tail;
        Node current;
        int dem;
        while(left!=right){
            current=left;
            dem=1;
            while(current!=right){
                dem++;
                current=current.next;
            }
            dem=(dem-1)/2;
            current=left;
            for(int i=1;i<=dem;i++){
                current=current.next;
            }
            if(current.data.price==gia){
                return current;
            }
            if(current.data.price<gia){
                left=current.next;
            }
            else{
                current=left;
                while(current.next!=right){
                    current=current.next;
                }
                right=current;
            }
        }
        current=left;
        if(current.data.id==gia){
            return current;
        }
        return null;
    }
        */

    void ketQuaTimTheoGia(double gia){
        Node current=head;
        boolean co=false;
        while(current!=null){
            if(current.data.price==gia){
                current.data.inThongTin();
                co=true;
            }
            current=current.next;
        }
        if(co==false){
            System.out.println("Không tìm thấy");
        }
    }

    void ketQuaTimTheoKhoangGia(double giaDau, double giaSau){
        Node current=head;
        boolean co=false;
        while(current!=null){
            if(current.data.price>=giaDau&&current.data.price<=giaSau){
                current.data.inThongTin();
                co=true;
            }
            current=current.next;
        }
        if(co==false){
            System.out.println("Không tìm thấy");
        }
    }
        /*
    Node timTheoNgay(Date ngay){
        Node left=head;
        Node right=tail;
        Node current;
        int dem;
        while(left!=right){
            current=left;
            dem=1;
            while(current!=right){
                dem++;
                current=current.next;
            }
            dem=(dem-1)/2;
            current=left;
            for(int i=1;i<=dem;i++){
                current=current.next;
            }
            if(current.data.date.equals(ngay)){
                return current;
            }
            if(current.data.date.before(ngay)){
                left=current.next;
            }
            else{
                current=left;
                while(current.next!=right){
                    current=current.next;
                }
                right=current;
            }
        }
        current=left;
        if(current.data.date.equals(ngay)){
            return current;
        }
        return null;
    }
        */
    void ketQuaTimTheoNgay(Date ngay){
        Node current=head;
        boolean co=false;
        while(current!=null){
            if(current.data.date.equals(ngay)){
                current.data.inThongTin();
                co=true;
            }
            current=current.next;
        }
        if(co==false){
            System.out.println("Không tìm thấy");
        }
    }


    void ketQuaTimTheoKhoangNgay(Date ngayDau, Date ngaySau){
        Node current=head;
        boolean co=false;
        while(current!=null){
            if((current.data.date.equals(ngayDau)||current.data.date.after(ngayDau))&&(current.data.date.equals(ngaySau)||current.data.date.before(ngaySau))){
                current.data.inThongTin();
                co=true;
            }
            current=current.next;
        }
        if(co==false){
            System.out.println("Không tìm thấy");
        }
    }

    void thongKe(){
        Node current=head;
        int tongHangHoa=0;
        double tongGiaTri=0;
        int tongThucPham=0;
        int tongSanhSu=0;
        int tongDienMay=0;
        if(head==null){

        }
        else{
            while(current!=null){
                tongHangHoa++;
                tongGiaTri=tongGiaTri+(current.data.price*current.data.amount);
                if(current.data.type.equals("thuc pham")){
                    tongThucPham++;
                }
                if(current.data.type.equals("sanh su")){
                    tongSanhSu++;
                }
                if(current.data.type.equals("dien may")){
                    tongDienMay++;
                }
                current=current.next;
            }
        }
        System.out.println("Tổng số lượng hàng hoá: "+tongHangHoa);
        System.out.println("Tổng giá trị nhập kho: "+tongGiaTri);
        System.out.println("Số lượng loại hàng thực phẩm: "+tongThucPham);
        System.out.println("Số lượng loại hàng sành sứ: "+tongSanhSu);
        System.out.println("Số lượng loại hàng điện máy: "+tongDienMay);
    }
}
