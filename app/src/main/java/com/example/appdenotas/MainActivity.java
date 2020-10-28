package com.example.appdenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Spinner SpinCursos;
    public EditText nome;
    public EditText rgm;
    public Button btnAvancar;
    public EditText turma;
    public String nomeAluno;
    public String turmaAluno;
    public String rgmAluno;
    public String cursoAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       SpinCursos = (Spinner) findViewById(R.id.SpinCursos);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.cursos, android.R.layout.simple_spinner_item);

        SpinCursos.setAdapter(adapter);

        nome = (EditText) findViewById(R.id.edtNome);
        turma = (EditText) findViewById(R.id.edtTurma);
        rgm = (EditText) findViewById(R.id.edtRGM);
        SpinCursos = (Spinner) findViewById(R.id.SpinCursos);
        btnAvancar = (Button) findViewById(R.id.btnAvancar);

        nomeAluno = nome.getText().toString();
        turmaAluno = turma.getText().toString();
        rgmAluno = rgm.getText().toString();
        cursoAluno = SpinCursos.getSelectedItem().toString();

    }

    public void btnAvancar(View v){
        Intent disciplinaActivity = new Intent(this, Disciplina.class);
        startActivity(disciplinaActivity);
    }


    public void btnFechar(View v){
        finish();
    }

}