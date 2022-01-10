package com.example.rxjavarxandroid18102021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arr = new ArrayList<>();
        arr.add("Tèo");
        arr.add("Tí");
        arr.add("Tủn");

        Iterator<String> data =  arr.iterator();

        while (data.hasNext()) {
            Log.d("BBB", data.next());
        }

    }
}