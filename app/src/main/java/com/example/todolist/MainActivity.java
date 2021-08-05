package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
    }

    public void add(View v){
        String input = ((EditText)findViewById(R.id.input)).getText().toString();

        Intent going = new Intent(MainActivity.this, ListPage.class);
        going.putExtra("input", input  ) ;
        startActivity(going);
        Log.d("input", input);
    }

    public void goToList(View v ){
        Intent going = new Intent(MainActivity.this, ListPage.class);
        startActivity(going);
    }
}