import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactsManager {
    public static ContactFile contactFile = new ContactFile();
    public static ArrayList<Contacts> contacts = contactFile.readFile();

    public static void showAllContacts(){
        for (Contacts c: contacts
             ) {
            System.out.println(c);
        }
    }

    public static void addToContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại: ");
        int phoneNumber = scanner.nextInt();
        int check = -1;


        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber() == phoneNumber){
                check = i;
                break;
            }
        }
        if (check == -1){
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("nhập tên: ");
            String name = scanner1.nextLine();

            int check2 = -1;
            for (int i = 0; i < contacts.size() ; i++) {
                if (contacts.get(i).getName().equals(name)){
                    check2 = i;
                    break;
                }
            }

            if (check2 == -1){
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Nhập địa chỉ: ");
                String address = scanner2.nextLine();

                Scanner scanner3 = new Scanner(System.in);
                System.out.println("Nhập giớ tính: ");
                String sex = scanner3.nextLine();

                Scanner scanner4 = new Scanner(System.in);
                System.out.println("Nhập email: ");
                String email = scanner4.nextLine();

                Contacts contacts1 = new Contacts(phoneNumber, name, address, sex, email);
                contacts.add(contacts1);
                try {
                    contactFile.writeFile(contacts);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Tên này đã có trong danh bạ, mời bạn nhập lại");
            }
        } else
            System.out.println("Số này đã có trong danh bạ, mời bạn nhập lại");
    }

    public static void deleteContactByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên liên hệ muốn xóa: ");
        String name  = scanner.nextLine();
        int check = -1;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)){
                check = i;
                break;
            }
        }
        if (check != -1){
            contacts.remove(contacts.get(check));
            try {
                contactFile.writeFile(contacts);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("tên này không có trong danh bạ, mời bạn nhập lại");
        }
    }

    public static void deleteContactByPhoneNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại liên hệ muốn xóa: ");
        int phoneNumber  = scanner.nextInt();
        int check = -1;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber() == phoneNumber){
                check = i;
                break;
            }
        }

        if (check != -1){
            contacts.remove(contacts.get(check));
            try {
                contactFile.writeFile(contacts);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("số này không có trong danh bạ, mời bạn nhập lại");
        }
    }

    public static void editContactByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên liên hệ muốn chỉnh sửa: ");
        String name = scanner.nextLine();
        int check = -1;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)){
                check = i;
                break;
            }
        }

        if (check != -1){
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Nhập số điện thoại: ");
            int phoneNumber = scanner1.nextInt();

            Scanner scanner2 = new Scanner(System.in);
            System.out.println("nhập tên: ");
            String name1 = scanner2.nextLine();

            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Nhập địa chỉ: ");
            String address = scanner5.nextLine();

            Scanner scanner3 = new Scanner(System.in);
            System.out.println("Nhập giớ tính: ");
            String sex = scanner3.nextLine();

            Scanner scanner4 = new Scanner(System.in);
            System.out.println("Nhập email: ");
            String email = scanner4.nextLine();

            contacts.get(check).setName(name);
            contacts.get(check).setPhoneNumber(phoneNumber);
            contacts.get(check).setAddress(address);
            contacts.get(check).setSex(sex);
            contacts.get(check).setEmail(email);
            try {
                contactFile.writeFile(contacts);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("tên liên hệ bạn muốn chỉnh sửa không có trong danh bạ!!!");
        }
    }

    public static void searchContactByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên liên hệ muốn tìm: ");
        String name = scanner.nextLine();
        int check = -1;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)){
                check = i;
                break;
            }
        }
        if (check != -1){
            System.out.println(contacts.get(check).toString());
        } else{
            System.out.println("liên hệ này không có trong danh bạ");
        }
    }

    public static void searchContactByPhoneNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số điện thoại liên hệ muốn tìm: ");
        int phoneNumber = scanner.nextInt();
        int check = -1;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber() == phoneNumber){
                check = i;
                break;
            }
        }
        if (check != -1){
            System.out.println(contacts.get(check).toString());
        } else{
            System.out.println("số điện thoại này không có trong danh bạ");
        }
    }
}
