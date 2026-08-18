class Drink {

    private final String name;
    private final String description;
    private final double price;

    Drink(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
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
}
