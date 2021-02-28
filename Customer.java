import java.util.Objects;

public class Customer {
private String tel,name,address,email;



    public Customer(String tel, String name, String address, String email) {
        this.tel = tel;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return tel.equals(customer.tel) &&
                name.equals(customer.name) &&
                address.equals(customer.address) &&
                email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tel, name, address, email);
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "tel='" + tel + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
