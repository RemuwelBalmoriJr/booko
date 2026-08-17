record Drink(String name, String description, double price) {

    String priceLabel() {
        return String.format("₱%.2f", price);
    }
}
