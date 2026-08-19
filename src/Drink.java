class Drink {

    private final String name;
    private final String description;
    private final double price;
    private final int quantity;

    Drink(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    String name() {
        return name;
    }

    String description() {
        return description;
    }

    double price() {
        return price;
    }

    String priceLabel() {
        return String.format("PHP %.2f", price);
    }

    int quantity() {
        return quantity;
    }
}
