package com.example.rxjavarxandroid18102021;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        1 + 2 - 3
        try {
            int total = sum(1,2).get();
            int result = minus(total,3).get();

            Log.d("BBB","Total : " + total);
            Log.d("BBB","Result : " + result);
            Log.d("BBB","Done");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private CompletableFuture<Integer> sum(int a, int b) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    int c = a + b;
                    completableFuture.complete(c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        return completableFuture;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private CompletableFuture<Integer> minus(int a, int b) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                int c = a - b;
                completableFuture.complete(c);
            }
        });
        return completableFuture;
    }
}