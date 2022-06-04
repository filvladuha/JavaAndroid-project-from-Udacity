 package com.example.justjava;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int numberOfCoffees = 0;

    public int getOneCupOfCoffeeCost() {
        return oneCupOfCoffeeCost;
    }

    public void setOneCupOfCoffeeCost(int oneCupOfCoffeeCost) {
        this.oneCupOfCoffeeCost = oneCupOfCoffeeCost;
    }

    private int oneCupOfCoffeeCost = 4;
    private String customer = "Vladislav Filimonov";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int getNumberOfCoffees() {
        return numberOfCoffees;
    }

    public void setNumberOfCoffees(int numberOfCoffees) {
        this.numberOfCoffees = numberOfCoffees;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void increment (View view){
        displayQuantity(++numberOfCoffees);
    }

    public void decrement (View view){
        if(getNumberOfCoffees() > 0) {
            displayQuantity(--numberOfCoffees);
        }
        else{
            displayMessage("0");
            Toast.makeText(getApplicationContext(),"Are u dumb, stupid or dumb, huh?", Toast.LENGTH_SHORT)
                    .show();
        }
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox creamCheckBox = (CheckBox) findViewById(R.id.checkbox_cream);
        boolean hasCream = creamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.checkbox_chocolate);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        displayMessage(orderSummary(getCustomer(), hasCream, hasChocolate, getNumberOfCoffees(), calculatePrice(getNumberOfCoffees(), getOneCupOfCoffeeCost())));
    }

    private int calculatePrice(int quantity, int pricePerCap){
        return quantity * pricePerCap;
    }

    // create final order
    private String orderSummary(String nameOfCustomer, boolean hasCream, boolean hasChocolate, int quantity, int price){
        return "Order Summary \nName: " + nameOfCustomer + "\nAdd whipped cream? " + hasCream + "\nAdd chocolate? " + hasChocolate +
                "\nQuantity: " + quantity +  "\nTotal cost: $" + price + "\nThank u ";
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int mNumber) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + mNumber);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.price_text_view);
        orderSummaryTextView.setText(message);
    }

    private String orderSummary(String nameOfCustomer, boolean hasCream, int quantity, int price){
        return "Order Summary \nName: " + nameOfCustomer + "\nAdd whipped cream? " + hasCream +
                "\nQuantity: " + quantity +  "\nTotal cost: $" + price + "\nThank u ";
    }
}