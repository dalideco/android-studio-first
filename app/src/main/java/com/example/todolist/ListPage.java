package com.example.todolist;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class list_element {

    public static int nbr = 0 ;
    public int id ;
    public String message;

    public list_element(String message){
        this.message = message;
        this.id = nbr;
        nbr ++ ;
    }
}

public class ListPage extends AppCompatActivity {

    static ArrayList<list_element> list = new ArrayList<list_element>();

    static{
        list.add(new list_element("take out the trash"));
        list.add(new list_element("do homework"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);

        addingInput();

        //selecting layout
        ViewGroup layout = (ViewGroup) findViewById(R.id.list_space);

        //pushing layout
        for (list_element element : list){
            TextView tv = new TextView(this);
            Button button = new Button(this);

            tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            tv.setTextSize(24);
            button.setTextSize(20);
            tv.setText(element.message);
            button.setText("remove");

            button.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View view) {
                    list.removeIf(el-> el.id==element.id);
                    Intent reload = new Intent(ListPage.this, ListPage.class);
                    startActivity(reload);
                }

            });
            layout.addView(tv);
            layout.addView(button);
        }
    }

    public void addingInput (){
        //getting intent input
        String input = ((Intent)getIntent()).getStringExtra("input");

        if(input == null ) return ;
        list.add(new list_element(input));
    }

}