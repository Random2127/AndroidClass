package com.example.ejerciciopropuesto1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    protected TextView texto1;
    protected TextView texto2;
    protected EditText caja1;
    protected Button button1;

    protected String valueCaja1;

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

        // Referenciamos para evitar nullPointer
        texto1 = (TextView) findViewById(R.id.texto1_main);
        texto2 = (TextView) findViewById(R.id.texto2_main);
        button1 = (Button) findViewById(R.id.button1_main);
        caja1 = (EditText) findViewById(R.id.caja1_main);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valueCaja1 = caja1.getText().toString();
                if(valueCaja1.isEmpty()){
                    texto2.setText("Debe escribir alguna respuesta.");
                    Toast.makeText(MainActivity.this, "Completa la caja ", Toast.LENGTH_SHORT).show();
                }else
                {
                    if(valueCaja1.equalsIgnoreCase("blanco")){
                        texto2.setText("Bien hecho!!");
                    }else{
                        texto2.setText("Ese no es el color correcto");
                    }
                }
            }
        });

    }
}