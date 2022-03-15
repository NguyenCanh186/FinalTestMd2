import java.io.Serializable;

public class Contacts implements Serializable {
    public String name;
    public int phoneNumber;
    public String address;
    public String sex;
    public String email;

    public Contacts() {
    }

    public Contacts(int phoneNumber,String name, String address, String sex, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.sex = sex;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "tên: " + name +
                ", số điện thoại: " + phoneNumber +
                ", địa chỉ: " + address +
                ", giới tính" + sex +
                ", email: " + email;
    }
}
