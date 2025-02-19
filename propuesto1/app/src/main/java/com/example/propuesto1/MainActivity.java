package com.example.propuesto1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    protected TextView texto1;
    protected TextView texto2;
    protected EditText caja1;
    protected Button boton;
    protected String valueCaja;

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

        texto1 = (TextView) findViewById(R.id.texto1_main);
        texto2 = (TextView) findViewById(R.id.texto2_main);
        caja1 = (EditText) findViewById((R.id.caja1_main));
        boton = (Button) findViewById((R.id.boton1_main));

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueCaja = caja1.getText().toString();
                if(valueCaja.isEmpty()){
                    texto2.setText("Debes completar el campo..");
                }else {
                    if(valueCaja.equalsIgnoreCase("red")){
                        texto2.setText("Correcto!");
                    }else{
                        texto2.setText("Error");
                    }

                }
            }
        });
    }
}