package com.example.appdenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Spinner SpinCursos = (Spinner) findViewById(R.id.SpinCursos);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.cursos, android.R.layout.simple_spinner_item);

        SpinCursos.setAdapter(adapter);

        final EditText nome = (EditText) findViewById(R.id.edtNome);
        final EditText turma = (EditText) findViewById(R.id.edtTurma);
        final EditText rgm = (EditText) findViewById(R.id.edtRGM);
        SpinCursos = (Spinner) findViewById(R.id.SpinCursos);
        Button btnAvancar = (Button) findViewById(R.id.btnAvancar);

        String nomeAluno = nome.getText().toString();
        String turmaAluno = turma.getText().toString();
        String rgmAluno = rgm.getText().toString();
        String cursoAluno = SpinCursos.getSelectedItem().toString();

        Intent CalcularNotaActivity = new Intent(this, CalcularNota.class);

        Bundle bundle = new Bundle();
        bundle.putString("nome", nomeAluno);
        bundle.putString("rgm", rgmAluno);
        bundle.putString("turma", turmaAluno);
        bundle.putString("curso", cursoAluno);
        CalcularNotaActivity.putExtras(bundle);

    }

    public void btnAvancar(View v){
        Intent disciplinaActivity = new Intent(this, Disciplina.class);
        startActivity(disciplinaActivity);
    }

    public void btnFechar(View v){
        finish();
    }

    public void btnCalcularNota(View view) {
    }

    public void btnCalcularAf(View view) {
    }
}