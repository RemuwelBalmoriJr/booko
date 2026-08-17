# Issues

Fallback list of workshop tasks, in case GitHub Issues aren't available.
Each one is a small, independent change to `src/Main.java` or
`src/BookingService.java`.

## 1. Add a quantity prompt to the order

Right now every order is fixed at one drink. Ask the customer how many
they want and use that quantity in the confirmation message.

**Acceptance:** The booking flow prompts for quantity and the
confirmation reflects the number ordered.

## 2. Add a fourth flavor to the menu

Booko only sells three flavors today. Add one more buko flavor to the
seed list in `BookingService`.

**Acceptance:** The menu lists four flavors and all four can be booked.

## 3. Show the total price in the confirmation

The confirmation message currently only shows the unit price. Multiply
price by quantity and show the total.

**Acceptance:** Booking two or more drinks shows a total price, not
just the per-drink price.

## 4. Reject a delivery date in the past

Booko currently accepts any valid date, including ones before today.
Validate the parsed date against today's date and reject past dates.

**Acceptance:** Entering a past date shows an error and does not book
the order; today or a future date still works.

## 5. Add a "cancel order" menu option

Once a customer starts booking, there's no way to back out. Add a way
to cancel mid-booking and return to the main menu.

**Acceptance:** From the booking flow, the customer can cancel and land
back at the main menu without a confirmation being printed.

## 6. Add a size option (regular / large) with different prices

All drinks are one size today. Let the customer choose regular or large,
with large costing more.

**Acceptance:** Choosing large changes the price used in the
confirmation; regular keeps the original price.
