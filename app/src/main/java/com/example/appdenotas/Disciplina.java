package com.example.appdenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Disciplina extends ListActivity {

    private ArrayList<String> disciplina = new ArrayList<String>();
    public EditText edtDisciplina;
    public String novaDisciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina);

       atualizaLista();
       limparDisciplina();
    }
    private  void limparDisciplina(){
        edtDisciplina = (EditText) findViewById(R.id.edtDisciplina);
        edtDisciplina.setText("");
        edtDisciplina.requestFocus();
    }
    private void atualizaLista(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, disciplina);
        setListAdapter(arrayAdapter);
    }


    @Override
    protected void onListItemClick(ListView lista, View v, int position, long id) {
        super.onListItemClick(lista, v, position, id);

        Object obj = this.getListAdapter().getItem(position);
        String disciplinaClicada = obj.toString();

            Intent CalcularNotaActivity = new Intent (this, CalcularNota.class);
            Bundle bundle = new Bundle();
            bundle.putString("Disciplina", disciplinaClicada);
            CalcularNotaActivity.putExtras(bundle);

            startActivity(CalcularNotaActivity);
    }
    public void btnSalvarOnClick(View v) {
        edtDisciplina = (EditText) findViewById(R.id.edtDisciplina);
        novaDisciplina = edtDisciplina.getText().toString();
        if ((novaDisciplina != null) &&(!novaDisciplina.equals(""))) {
            disciplina.add(edtDisciplina.getText().toString());
            limparDisciplina();
            atualizaLista();
            }
        }

        public void btnFechar(View v){ finish(); }
}