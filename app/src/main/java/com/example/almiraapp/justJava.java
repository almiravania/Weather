package com.example.almiraapp;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */

public class justJava extends AppCompatActivity {

    int quantity = 2;
    private String name;
    private int price;
    private boolean addHujan;
    private boolean addCerah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.just_java);
    }


    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this,"You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this,"You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //Find the user's name
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();



        //Information
        EditText nameinformation = (EditText) findViewById(R.id.name_information);
        String information = nameinformation.getText().toString();

        // Figure out if the user wants Male Gender
        CheckBox HujanCheckBox = (CheckBox) findViewById(R.id.Hujan_checkbox);
        boolean hasHujan = HujanCheckBox.isChecked();

        // Figure out if the user wants Female Gender
        CheckBox CerahCheckBox = (CheckBox) findViewById(R.id.Cerah_checkbox);
        boolean hasCerah = CerahCheckBox.isChecked();

        int price = calculatePrice(hasHujan,hasCerah);
        String priceMessage = createOrderSummary(name,information ,hasHujan,hasCerah);

        Intent intent = new Intent(Intent.ACTION_SENDTO); // ACTION_SENDTO adalah konstanta
        intent.setData(Uri.parse("mailto:info@bmkg.go.id")); // only email apps should han dle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Report Weather for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    private int calculatePrice(boolean addHujan, boolean addCerah) {
        // price of 1 cup of coffee
        int basePrice = 5;

        // add $1 if the user wants whipped cream
        if (addHujan){
            basePrice = basePrice + 1;
        }

        // add $2 if the user wants chocolate
        if (addCerah){
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }

    @SuppressLint("StringFormatInvalid")
    private String createOrderSummary (String name, String information ,boolean addHujan, boolean addCerah) {
        getString(R.string.order_summary_name, name);
        String priceMessage = getString(R.string.order_summary_information, information);

        if(addHujan == true) {
            priceMessage += "\n Cuaca sedang Hujan";
        } else {
            priceMessage += "\n Cuaca sedang Cerah";
        }
        priceMessage += "\n" + getString(R.string.order_summary_pukul, quantity);
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */




}




