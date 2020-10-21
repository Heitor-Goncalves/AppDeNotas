package com.example.appdenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcularNotaAf extends AppCompatActivity {

    public EditText edtNota1;
    public EditText edtNota2;
    public EditText edtNota3;
    public TextView txtSituacaoAf;
    public TextView txtNotaFinalAf;
    public Button btnCalcularNotaAf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_nota_af);

        Intent disciplina = getIntent();
        Bundle disciplinaclicada = disciplina.getExtras();
        String sDisciplina = disciplinaclicada.getString("disciplina");

        TextView txtDisciplinaAf = (TextView) findViewById(R.id.txtDisciplinaAf);
        txtDisciplinaAf.setText(sDisciplina);

        edtNota1 = (EditText) findViewById(R.id.edtNota1Af);
        edtNota2 = (EditText) findViewById(R.id.edtNota2Af);
        edtNota3 = (EditText) findViewById(R.id.edtNotaAf);
        txtSituacaoAf = (TextView) findViewById(R.id.txtSituacaoAf);
        txtNotaFinalAf = (TextView) findViewById(R.id.txtNotaFinalAf);
        btnCalcularNotaAf = (Button) findViewById(R.id.btnCalcularNotaAf);

        btnCalcularNotaAf.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceAsColor")
            public void onClick(View v) {
                Double nota1 = Double.parseDouble(edtNota1.getText().toString());
                Double nota2 = Double.parseDouble(edtNota2.getText().toString());
                Double nota3 = Double.parseDouble(edtNota3.getText().toString());

                Double notaFinal = nota1 + nota2 + nota3;

                txtNotaFinalAf.setText(notaFinal.toString());

                if (nota1 < 0 && nota1 > 5 || nota2 < 0 && nota2 > 5 || nota3 < 0 && nota3 < 5) {
                    Toast.makeText(getApplicationContext(), "Digite uma nota Válida", Toast.LENGTH_LONG).show();

                } else if (notaFinal >= 6) {
                    txtSituacaoAf.setText("Aprovado");
                    txtSituacaoAf.setTextColor(getColor(R.color.corAprovado));

                } else {
                    txtSituacaoAf.setText("Reprovado");
                    txtSituacaoAf.setTextColor(getColor(R.color.corReprovado));
                }
            }
        });
    }
}