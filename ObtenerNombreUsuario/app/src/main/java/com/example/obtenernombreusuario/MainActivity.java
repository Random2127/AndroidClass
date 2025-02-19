package com.example.obtenernombreusuario;

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
    protected EditText caja1;
    protected Button boton1;
    protected String valorCaja1 = "";

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

        caja1 = (EditText) findViewById(R.id.editText1_main);
        texto1 = (TextView) findViewById(R.id.textView1_main);
        boton1 = (Button) findViewById(R.id.button1_main);

        caja1.setHint("Input name.. ");
        boton1.setText("Boton");
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando clickemos sucederá..
                // Toast.makeText(MainActivity.this, "Botonazo!!", Toast.LENGTH_SHORT).show();

                valorCaja1= caja1.getText().toString();
                if(valorCaja1.isEmpty()){
                    Toast.makeText(MainActivity.this, "Complete the field.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Has introducido: " + valorCaja1, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "In pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "I'm back", Toast.LENGTH_SHORT).show();
    }
}