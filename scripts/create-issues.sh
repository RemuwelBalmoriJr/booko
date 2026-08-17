#!/usr/bin/env bash
# Creates the six workshop issues on GitHub. Safe to re-run: skips any
# issue whose title already exists, and only creates the label once.
set -euo pipefail

LABEL="good first issue"

if ! gh label list --json name -q '.[].name' | grep -qx "$LABEL"; then
    gh label create "$LABEL" --color 7057ff --description "Good for newcomers"
fi

existing_titles="$(gh issue list --state all --limit 200 --json title -q '.[].title')"

create_issue() {
    local title="$1"
    local body="$2"

    if grep -qxF "$title" <<< "$existing_titles"; then
        echo "Skipping (already exists): $title"
        return
    fi

    gh issue create --title "$title" --body "$body" --label "$LABEL"
    echo "Created: $title"
}

create_issue "Add a quantity prompt to the order" \
"Right now every order is fixed at one drink. Ask the customer how many they want and use that quantity in the confirmation message.

Acceptance: The booking flow prompts for quantity and the confirmation reflects the number ordered."

create_issue "Add a fourth flavor to the menu" \
"Booko only sells three flavors today. Add one more buko flavor to the seed list in BookingService.

Acceptance: The menu lists four flavors and all four can be booked."

create_issue "Show the total price in the confirmation" \
"The confirmation message currently only shows the unit price. Multiply price by quantity and show the total.

Acceptance: Booking two or more drinks shows a total price, not just the per-drink price."

create_issue "Reject a delivery date in the past" \
"Booko currently accepts any valid date, including ones before today. Validate the parsed date against today's date and reject past dates.

Acceptance: Entering a past date shows an error and does not book the order; today or a future date still works."

create_issue "Add a \"cancel order\" menu option" \
"Once a customer starts booking, there's no way to back out. Add a way to cancel mid-booking and return to the main menu.

Acceptance: From the booking flow, the customer can cancel and land back at the main menu without a confirmation being printed."

create_issue "Add a size option (regular / large) with different prices" \
"All drinks are one size today. Let the customer choose regular or large, with large costing more.

Acceptance: Choosing large changes the price used in the confirmation; regular keeps the original price."
