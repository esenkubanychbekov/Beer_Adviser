package com.example.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickFindBeer(View view) {

        BeerExpert expert = new BeerExpert();

        TextView brands = findViewById(R.id.brands);
        Spinner colors = findViewById(R.id.color);

        String beerType = String.valueOf(colors.getSelectedItem());
        List<String> brandList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand: brandList){
            brandsFormatted.append(brand).append('\n');
        }

        brands.setText(brandsFormatted);

    }

    public class BeerExpert{
        List<String> getBrands (String color){
            List<String> brands = new ArrayList<>();
            if (color.equals("amber")){
                brands.add("Jack Amber");
                brands.add("Red Moose");
            }

            else {
                brands.add("Jail Pale ale");
                brands.add("Gout Stout");
            }
            return brands;
        }
    }
}
