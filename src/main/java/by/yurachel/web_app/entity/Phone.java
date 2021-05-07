package by.yurachel.web_app.entity;

import java.io.Serializable;
import java.util.Objects;

public class Phone implements Serializable {

    private long id;
    private String name;
    private double price;
    private String processor;

    private static final long serialVersionUID = 6295618226040646585L;

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

    public Phone(long id, String name, double price, String processor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.processor = processor;
    }

    public Phone() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return id == phone.id && Double.compare(phone.price, price) == 0 && name.equals(phone.name) && processor.equals(phone.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, processor);
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", price: " + price + ", processor: " + processor;
    }

}
