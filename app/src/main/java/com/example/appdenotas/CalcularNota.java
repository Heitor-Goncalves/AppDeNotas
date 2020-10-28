package com.example.appdenotas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CalcularNota extends AppCompatActivity {

    public Button btnCalcularNota;
    public EditText edtNota1;
    public EditText edtNota2;
    public TextView txtNotaFinal;
    public TextView txtSituacao;
    public Button btnCalcularAf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_nota);


        btnCalcularNota = (Button) findViewById(R.id.btnCalcularNota);
        btnCalcularAf = (Button) findViewById(R.id.btnCalcularAf);

            btnCalcularAf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent notaAf = new Intent(CalcularNota.this, CalcularNotaAf.class);
                startActivity(notaAf);
            }
             });

        btnCalcularNota.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View v) {

                edtNota1 = (EditText) findViewById(R.id.edtNota1);
                edtNota2 = (EditText) findViewById(R.id.edtNota2);
                txtNotaFinal = (TextView) findViewById(R.id.txtNotaFinal);
                txtSituacao = (TextView) findViewById(R.id.txtSituacao);

                Double nota1 = Double.parseDouble(edtNota1.getText().toString());
                Double nota2 = Double.parseDouble(edtNota2.getText().toString());

                Double notaFinal = nota1 + nota2;
                txtNotaFinal.setText(notaFinal.toString());

                if (nota1 < 0 && nota1 > 5 || nota2 < 0 && nota2 > 5) {
                    Toast.makeText(getApplicationContext(), "Digite uma nota Válida", Toast.LENGTH_LONG).show();

                } else if (notaFinal >= 6) {
                    txtSituacao.setText("Aprovado");
                    txtSituacao.setTextColor(getColor(R.color.corAprovado));

                } else {
                    txtSituacao.setText("Reprovado");
                    txtSituacao.setTextColor(getColor(R.color.corReprovado));
                }
            }
        });

        }
    }



