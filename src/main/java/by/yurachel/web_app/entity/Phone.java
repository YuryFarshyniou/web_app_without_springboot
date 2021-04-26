package by.yurachel.web_app.entity;

import java.io.Serializable;
import java.util.Objects;

public class Phone implements Serializable {
    private String name;
    private double price;
    private String processor;

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

    public Phone(String name, double price, String processor) {
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
        return Double.compare(phone.price, price) == 0 && Objects.equals(name, phone.name) && Objects.equals(processor, phone.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, processor);
    }

    @Override
    public String toString() {
        return "name: " + name + ", price: " + price + ", processor: " + processor;
    }

}
