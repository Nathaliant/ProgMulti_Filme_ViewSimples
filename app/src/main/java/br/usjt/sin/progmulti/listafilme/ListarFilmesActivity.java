package br.usjt.sin.progmulti.listafilme;

/*
 *Nathalia Nogueira Torres - 816114445
*/ 


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarFilmesActivity extends Activity {

    public static final String DESCRICAO = "br.usjt.sin.progmulti.listafilme.descricao";
    ArrayList<String> lista;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_filmes);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        lista = buscaChamados(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                                                        
                Intent intent = new Intent(atividade, DetalheFilmeActivity.class);
                intent.putExtra(DESCRICAO, lista.get(position));
                startActivity(intent);
                }
        });
    }
    public ArrayList<String> buscaChamados(String chave){
        ArrayList<String> lista = geraListaFilmes();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<String> subLista = new ArrayList<>();
            for(String nome:lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }
    public ArrayList<String> geraListaFilmes(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Toy Story: 1995");
        lista.add("Toy Story 2: 1999	");
        lista.add("Toy Story 3: 2010");
        lista.add("Toy Story 4: 2019");
        lista.add("Up - Altas Aventuras: 2009");
        lista.add("Monsters, Inc.: 2001");
        lista.add("A Missão Especial do Dug: 2009");
        lista.add("O Bom Dinossauro: 2011");
        lista.add("Animais Fantásticos e Onde Habitam - Ano de lançamento: 2015");
        return lista;
    }
}
