package com.example.dell.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    int quantity = 0,price = 0;

    String name = "Anonymous";

    boolean chocolateAdded = false,toppingsAdded = false;

    public void checkBoxesChecked (View view)
    {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId())
        {
            case R.id.toppings_checkbox:
                if(checked)
                {
                    toppingsAdded = true;
                }
                else ;
                break;

            case R.id.chocolate_checkbox:
                if(checked)
                {
                    chocolateAdded = true;
                }
                else ;
                break;
        }
    }

    public String getCreateOrderSummary(View view) {
        EditText fullName = (EditText) findViewById(R.id.name_text);
        name = fullName.getText().toString();
        String createOrderSummary = "Dear "+name+",";
        createOrderSummary += "\nQuantity : "+quantity;
        createOrderSummary += "\nPrice : $"+price;
        createOrderSummary += "\nToppingsAdded : "+toppingsAdded;
        createOrderSummary += "\nChocolateAdded : "+chocolateAdded;
        createOrderSummary += "\nThank You!";
        return createOrderSummary;
    }

    public void submitOrder (View view)
    {

        TextView orderSummary = (TextView) findViewById(R.id.order_summary_view);
        orderSummary.setText(getCreateOrderSummary(view));
    }

    public void subtractQuantity(View view){
        if(quantity!=0){quantity = quantity-1;
        }

        else;
        display(quantity);
    }

    public void addQuantity (View view)
    {
         quantity++;
         display(quantity);
    }

    public void display (int quantity)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+quantity);

    }
}
