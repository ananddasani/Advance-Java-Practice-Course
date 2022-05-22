package hbrnt_2_annotations;

import javax.persistence.*;
import java.util.Date;

@Entity //Enable this class to be inserted into the table
@Table(name = "hibernate_annotations") // changing the table name Annotations -> hibernate_annotations
public class Annotations {

    @Id // making id column as primary key
    @Column(name = "id") //changing column name addressId -> id
    @GeneratedValue(strategy = GenerationType.AUTO) //auto increment id
    private int addressId;

    @Temporal(TemporalType.DATE) //formatting
    @Column(name = "date_added")
    private Date addedDate;

    private String city;

    @Transient //Ignore this while making table
    private double x;

    public Annotations() {
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Annotations{" +
                "addressId=" + addressId +
                ", addedDate=" + addedDate +
                ", city='" + city + '\'' +
                ", x=" + x +
                '}';
    }
}
