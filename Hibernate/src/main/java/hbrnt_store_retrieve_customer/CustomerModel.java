package hbrnt_store_retrieve_customer;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    String name;
    String mobile;
    String address;

    public CustomerModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
