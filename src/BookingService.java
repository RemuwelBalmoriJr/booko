import java.util.ArrayList;
import java.util.List;

class BookingService {

    private final List<Drink> drinks = new ArrayList<>();

    BookingService() {
        drinks.add(new Drink("Classic Buko", "Fresh coconut water and young coconut meat", 45.00));
        drinks.add(new Drink("Buko Pandan", "Coconut juice infused with pandan", 55.00));
        drinks.add(new Drink("Buko Lychee", "Coconut juice with lychee bits", 60.00));
        drinks.add(new Drink("Buko Melon", "Coconut juice with melon bits", 60.00));
    }

    List<Drink> listDrinks() {
        return drinks;
    }

    Drink getDrink(int index) {
        return drinks.get(index);
    }

    String book(String customerName, Drink drink, int quantity, boolean large, String deliveryDate) {
        double unitPrice = large ? drink.price() + 15.00 : drink.price();
        double total = unitPrice * quantity;
        String size = large ? "large" : "regular";
        return String.format(
                "Booked! %s (%s) x%d for %s, total %s, delivering on %s.",
                drink.name(), size, quantity, customerName, String.format("₱%.2f", total), deliveryDate);
    }
}
