    package com.example.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends  AppCompatActivity {

    int numberOfCoffees = 1;
    int quantity = numberOfCoffees;
    private int calculatePrice(boolean addWhippedCream , boolean addChocolate) {
        int basePrice = 5;
        if (addWhippedCream){
            basePrice=basePrice+1;
        }
        if ( addChocolate)
        {
            basePrice = basePrice +2;
        }

        return quantity* basePrice;
    }



    private String createOrderSummary(int price , boolean hasWhippedCream , boolean hasChocolate , String name)
    {
        String summary = ""+getString(R.string.name)+name + "\n"+getString(R.string.quantity) +quantity+ "\n"+getString(R.string.wipped_cream) + hasWhippedCream + "\n "+getString(R.string.chocolate)
                + hasChocolate +"\n"+getString(R.string.total) + price + "\n" + getString(R.string.thank_you);
        return summary;

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view)
    {

        //String priceMessage = "Total: $" + calculatePrice(quantity) + "\n Thank you!";
        CheckBox whippedCheckBox= (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream =  whippedCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        int price = calculatePrice(hasWhippedCream , hasChocolate);

        String priceMessage = createOrderSummary(price , hasWhippedCream , hasChocolate , name);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " +name);
        intent.putExtra(Intent.EXTRA_TEXT,  priceMessage );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

//        displayMessage(priceMessage);
    }
    public void increment(View view)
    {
        if (quantity == 100) {
            Toast.makeText(this , "You can not select more than 100 cups of coffess" , Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);

    }
    public void decrement(View view)
    {
        if(quantity==1){
            Toast.makeText(this , "You can not select less than 1 cups of coffess" , Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity-1;
        display(quantity);

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
//    private void displayMessage(String message) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(message);
//    }

}