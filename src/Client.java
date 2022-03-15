import java.util.Scanner;
import java.util.regex.Pattern;

public class Client {
    public static void main(String[] args) {
        int loop = 0;
        while (loop == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Menu");
            System.out.println("1. xem liên hệ");
            System.out.println("2. thêm mới");
            System.out.println("3. sửa liên hệ");
            System.out.println("4. xóa liên hệ");
            System.out.println("5. tìm kiếm liên hệ");
            System.out.println("nhấn phím 0 để thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            Pattern p = Pattern.compile("^[0-5]$");
            String choose = scanner.nextLine();
            if (p.matcher(choose).find()){
                switch (choose){
                    case "1":
                        System.out.println("Danh sách liên hệ:");
                        ContactsManager.showAllContacts();
                        break;
                    case "2":
                        ContactsManager.addToContact();
                        break;
                    case "3":
                        ContactsManager.editContactByName();
                        break;
                    case "4":
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("1. xóa liên hệ theo tên ");
                        System.out.println("2. xóa liên hệ theo số điện thoại");
                        System.out.println("Nhập lựa chọn của bạn: ");
                        int choose1 = scanner1.nextInt();
                        switch (choose1){
                            case 1:
                                ContactsManager.deleteContactByName();
                                break;
                            case 2:
                                ContactsManager.deleteContactByPhoneNumber();
                                break;
                        }
                        break;
                    case "5":
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("1. tìm kiếm liên hệ theo tên ");
                        System.out.println("2. tìm kiếm liên hệ theo số điện thoại");
                        System.out.println("Nhập lựa chọn của bạn: ");
                        int choose2 = scanner2.nextInt();
                        switch (choose2){
                            case 1:
                                ContactsManager.searchContactByName();
                                break;
                            case 2:
                                ContactsManager.searchContactByPhoneNumber();
                                break;
                        }
                        break;
                    case "0":
                        System.exit(0);
                        break;
                }
            }
        }
    }
}
