package com.example.aileen.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class FindCoffeeActivity extends AppCompatActivity{

    private CoffeeShop myCoffeeShop = new CoffeeShop();

    public void findCoffee(View view){
        //get spinner
        Spinner crowdSpinner = (Spinner)findViewById(R.id.spinner);
        //get spinner item array position
        Integer crowd = crowdSpinner.getSelectedItemPosition();
        //set the coffee shop
        myCoffeeShop.setCoffeeShop(crowd);
        //get suggested coffee shop
        String suggestedCoffeeShop = myCoffeeShop.getCoffeeShop();
        //get URL of suggested coffee shop
        String suggestedCoffeeShopURL = myCoffeeShop.getCoffeeShopURL();
        System.out.println(suggestedCoffeeShop);
        System.out.println(suggestedCoffeeShopURL);

        //create an intent
        Intent intent = new Intent(this, ReceiveCoffeeActivity.class);

        //pass data
        intent.putExtra("coffeeShopName", suggestedCoffeeShop);
        intent.putExtra("coffeeShopURL", suggestedCoffeeShopURL);

        //start the intent
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_coffee);
        //get button
        final Button button = (Button) findViewById(R.id.button);
        //create listener
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                findCoffee(view);
            }
        };
        //add listener to the button
        button.setOnClickListener(onclick);
    }
}
