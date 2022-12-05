package ru.geekbrains.seminar1;

import java.sql.Struct;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class Sample01 {

    // https://www.jetbrains.com/ru-ru/idea/download/#section=windows
    /// https://www.diagrams.net/
    /// https://github.com/jgraph/drawio-desktop/releases/tag/v20.3.0
    public static void main(String[] args) {
        Store store = new Store();

    }

}

class Store{
    private Collection<Order> orders = new HashSet<Order>();

    /**
     * Добавить новый заказ
     * @param order заказ
     * @return
     */
    public boolean addOrder(Order order){
        orders.add(order);
        return true;
    }

    /**
     * Удалить заказ по идентификатору
     * @param id идентификатор заказа
     * @return
     */
    public boolean cancelOrder(int id){
        return true;
    }

    /**
     * Оплатить заказ
     * @param id идентификатор заказа
     * @return
     */
    public boolean paymentOrder(int id){
        return true;
    }

}


/**
 * Покупатель
 */
class Buyer{

    static int counter = 0;
    private  int id;
    private String name;
    private String lastName;
    private String patronymic;
    private String gender;
    private Date birthday;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    {
        id = ++counter;
    }

}

/**
 * Продукт
 */
class Product{

    private static int counter = 0;
    private final int id;
    private String name;
    private double price;
    private String category;

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Product.counter = counter;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    {
        id = ++counter;
    }
}

/**
 * Позиция
 */
class OrderItem{

    private static int counter = 0;
    private final int id;
    private Product product;
    private int quantity;

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    {
        id = ++counter;
    }
}

/**
 * Заказ
 */
class Order{
    private static int counter = 0;
    private final int id;
    private Date orderDate;
    private String address;
    private String phone;
    private Buyer buyer;
    private Collection<OrderItem> items = new HashSet<>();

    public int getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Collection<OrderItem> getItems() {
        return items;
    }

    public void setItems(Collection<OrderItem> items) {
        this.items = items;
    }

    {
        id = ++counter;
    }
}