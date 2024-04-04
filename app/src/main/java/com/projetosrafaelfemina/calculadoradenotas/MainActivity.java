package com.projetosrafaelfemina.calculadoradenotas;

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

    private EditText n1;
    private EditText n2;
    private EditText n3;
    private EditText n4;
    private EditText numeroFaltas;
    private Button btCalcular;
    private TextView txtResultado;

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

        n1 = findViewById(R.id.nota1);
        n2 = findViewById(R.id.nota2);
        n3 = findViewById(R.id.nota3);
        n4 = findViewById(R.id.nota4);
        numeroFaltas = findViewById(R.id.numeroFaltas);
        btCalcular = findViewById(R.id.bt_calcular);
        txtResultado = findViewById(R.id.txt_resultado);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int nota1 = Integer.parseInt(n1.getText().toString());
                int nota2 = Integer.parseInt(n2.getText().toString());
                int nota3 = Integer.parseInt(n3.getText().toString());
                int nota4 = Integer.parseInt(n4.getText().toString());
                int numero_Faltas = Integer.parseInt(numeroFaltas.getText().toString());
                int mediaFinal = ((nota1 + nota2 + nota3 + nota4) / 4);

                if (mediaFinal >= 5 && numero_Faltas <= 20) {
                    txtResultado.setText("Aluno foi Aprovado \n " + "Média final: " + mediaFinal);
                    txtResultado.setTextColor(getColor(R.color.green));
                } else if (numero_Faltas > 20) {
                    txtResultado.setText("Aluno foi Reprovado por Faltas \n " + "Média final: " + mediaFinal);
                    txtResultado.setTextColor(getColor(R.color.red));
                } else if (mediaFinal < 5) {
                    txtResultado.setText("Aluno foi Reprovado por Nota \n " + "Média final: " + mediaFinal);
                    txtResultado.setTextColor(getColor(R.color.red));
                }
            }
        });
    }
}