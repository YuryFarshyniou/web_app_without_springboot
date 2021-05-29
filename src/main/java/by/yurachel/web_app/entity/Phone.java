package by.yurachel.web_app.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "phones")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Phone implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    private String name;
    private double price;
    private String processor;
    private String img;

    private static final long serialVersionUID = 6295618226040646585L;

    public Phone(String name, double price, String processor, String img) {
        this.name = name;
        this.price = price;
        this.processor = processor;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Phone(long id, String name, double price, String processor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.processor = processor;
    }

    public Phone(String name, double price, String processor) {
        this.name = name;
        this.price = price;
        this.processor = processor;
    }

    public Phone(long id, String name, double price, String processor, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.processor = processor;
        this.img = img;
    }

    public Phone() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return id == phone.id && Double.compare(phone.price, price) == 0
                && Objects.equals(name, phone.name) && Objects.equals(processor, phone.processor)
                && Objects.equals(img, phone.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, processor, img);
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", price: " + price + ", processor: " + processor;
    }

}
