package com.example.propuesto1img;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    protected TextView text1;
    protected TextView text2;
    protected EditText caja1;
    protected Button button1;
    protected ImageView image1;
    protected String input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        text1 = (TextView) findViewById(R.id.text1_main);
        text2 = (TextView) findViewById(R.id.text2_main);
        caja1 = (EditText) findViewById(R.id.edit1_main);
        button1 = (Button) findViewById(R.id.button1_main);
        image1 = (ImageView) findViewById(R.id.image1_main);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = caja1.getText().toString();
                if(input.isEmpty()){
                    text2.setText("Introduce un valor");
                    image1.setImageResource(R.drawable.wrong);

                }else {
                    if(input.equalsIgnoreCase("blue")){
                        text2.setText("Well done!!");
                        image1.setImageResource(R.drawable.right);
                        button1.setEnabled(false);
                        button1.setBackgroundColor(Color.GRAY);
                    }else {
                        text2.setText("Wrong option :(");
                        image1.setImageResource(R.drawable.wrong);
                        // This will make image disappear after 1000(end)
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // remove pic
                                image1.setImageResource(0);
                            }
                        },1000); //ms
                    }
                }

            }
        });
    }
}