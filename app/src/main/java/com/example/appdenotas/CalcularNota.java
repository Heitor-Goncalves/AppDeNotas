package com.example.appdenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalcularNota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_nota);

        Intent disciplina = getIntent();
        Bundle aluno = disciplina.getExtras();

        String nome = aluno.getString("nome");
        String rgm = aluno.getString("rgm");
        String turma = aluno.getString("turma");
        String curso = aluno.getString("curso");
        String disciplinaClic = aluno.getString("disciplina");

        TextView txtDisciplina = (TextView) findViewById(R.id.txtDisciplina);
        TextView txtNomeAluno = (TextView) findViewById(R.id.txtNomeAluno);
        TextView txtRgmAluno = (TextView) findViewById(R.id.txtRgmAluno);
        TextView txtCursoAluno = (TextView) findViewById(R.id.txtCursoAluno);
        TextView txtTurmaAluno = (TextView) findViewById(R.id.txtTurma);

        txtDisciplina.setText(disciplinaClic);
        txtNomeAluno.setText(nome);
        txtRgmAluno.setText(rgm);
        txtTurmaAluno.setText(turma);
        txtCursoAluno.setText(curso);

    }

    public void btnCalcularNota(View v){

        final EditText edtNota1 = (EditText) findViewById(R.id.edtNota1);
        final EditText edtNota2 = (EditText) findViewById(R.id.edtNota2);
        final TextView txtNotaFinal = (TextView) findViewById(R.id.txtNotaFinal);
        final TextView txtSituacao = (TextView) findViewById(R.id.txtSituacao);

        Double nota1 = Double.parseDouble(edtNota1.getText().toString());
        Double nota2 = Double.parseDouble(edtNota2.getText().toString());

        Double notaFinal = nota1 + nota2;
        txtNotaFinal.setText(notaFinal.toString());

        if(nota1<0 && nota1>5||nota2<0 && nota2>5){
            Toast.makeText(getApplicationContext(), "Digite uma nota Válida", Toast.LENGTH_LONG).show();

        } else if(notaFinal>=6){
            txtSituacao.setText("Aprovado");
            txtSituacao.setTextColor(getColor(R.color.corAprovado));

        } else {
            txtSituacao.setText("Reprovado");
            txtSituacao.setTextColor(getColor(R.color.corReprovado));
        }
    }

    public void btnCalcularAf(View v){

        Intent disciplina = getIntent();
        Bundle aluno = disciplina.getExtras();
        String disciplinaClic = aluno.getString("desciplina");

        Bundle bundle = new Bundle();
        bundle.putString("disciplina",disciplinaClic);

        Intent calcularNotaAf = new Intent(this,CalcularNotaAf.class);
        calcularNotaAf.putExtras(bundle);
        startActivity(calcularNotaAf);
    }
}