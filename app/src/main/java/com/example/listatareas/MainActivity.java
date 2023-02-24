package com.example.listatareas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private Button btn_add;
    private ViewGroup layout;
    private ScrollView scrollView;
    private EditText tv_tarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();

        layout = (ViewGroup) findViewById(R.id.content);
        scrollView = (ScrollView) findViewById(R.id.scrollView);

        tv_tarea = (EditText) findViewById(R.id.et_tarea);

        btn_add = (Button) findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarTarea();
            }
        });
    }


    public void agregarTarea(){


        if(tv_tarea.getText().toString().matches("")){
            Toast.makeText(this, "Ingrese la Tarea a Agregar", Toast.LENGTH_SHORT).show();
            return;
        }
        agregar();
        tv_tarea.setText("");
    }

    private void agregar(){
        LayoutInflater inflater = LayoutInflater.from(this);
        int id = R.layout.task;
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(id, null, false);

        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_tarea);
        textView.setText(tv_tarea.getText());

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        relativeLayout.setPadding(5, 0, 5, 10);
        relativeLayout.setLayoutParams(params);
        layout.addView(relativeLayout);

        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }
}