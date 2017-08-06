package com.devmob.minhagrade;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import com.devmob.minhagrade.Adapter.DisciplinasAdapter;
import com.devmob.minhagrade.Model.Disciplina;
import java.util.ArrayList;

///**
// * Created by murilo on 29/06/17.


public class GradeActivity extends AppCompatActivity {

    static final int REQUEST_CODE = 41324;
    private ListView listViewDeDisciplinas;
    private ArrayList<Disciplina> disciplinas;
    private  ListView listViewAdd;
    private ArrayList<Disciplina> addDisciplinas;
    private ArrayList<Integer> guardaItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        Intent intent = getIntent();
        final ArrayList<String> value = intent.getStringArrayListExtra("MESSAGE");

        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.addDisc);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(GradeActivity.this, AddDiscActivity.class);
                ArrayList<String> message = new ArrayList<>();
                message.addAll(value);
                intent.putExtra("MESSAGE", message);

                ActivityOptionsCompat opts =  ActivityOptionsCompat.makeCustomAnimation(GradeActivity.this,R.anim.slide_in_left,R.anim.slide_out_left);
                ActivityCompat.startActivityForResult(GradeActivity.this,intent,REQUEST_CODE,opts.toBundle());
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);*/
                final AlertDialog.Builder dialog = new AlertDialog.Builder(GradeActivity.this);
                guardaItems = new ArrayList<>();
                // Popula a Lista de disciplinas apartir do Model de Disciplinas

                addDisciplinas = Disciplina.getDisciplinasPorStatus(value,GradeActivity.this,0);
                CharSequence[] listaDeNomeDisciplinas = new CharSequence[addDisciplinas.size()];
                int i =0;
                for(Disciplina disc : addDisciplinas) {
                    listaDeNomeDisciplinas[i++]=disc.getNome();
                }
                //listViewAdd.setAdapter(new DisciplinasAdapter(addDisciplinas, GradeActivity.this, 2));
                dialog.setTitle(R.string.add_disciplina).setMultiChoiceItems(listaDeNomeDisciplinas,null,new DialogInterface.OnMultiChoiceClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                        if(isChecked){
                            guardaItems.add(i);
                        }else if(guardaItems.contains(i)){
                            guardaItems.remove(i);
                        }
                    }
                }).setPositiveButton(R.string.add_disciplina_ok, new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for(Integer n : guardaItems)
                            Prefs.setInteger(GradeActivity.this,addDisciplinas.get(n).getNome(),1);
                        GradeActivity.this.finish();
                        GradeActivity.this.startActivity(GradeActivity.this.getIntent());
                    }
                }).setNegativeButton(R.string.add_disciplina_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.create();
                dialog.show();
                /*Button concluido = (Button) dialog.findViewById(R.id.concAddDisc);
                concluido.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        GradeActivity.this.finish();
                        GradeActivity.this.startActivity(GradeActivity.this.getIntent());
                    }
                });
                dialog.show();*/
            }
        });

        int orientacao = this.getResources().getConfiguration().orientation;
        if(orientacao == Configuration.ORIENTATION_LANDSCAPE) {

        }else{
            // Instancia a ListView
            listViewDeDisciplinas = (ListView) findViewById(R.id.gradeSem);
            // Popula a Lista de disciplinas apartir do Model de Disciplinas
            disciplinas = Disciplina.getDisciplinasPorStatus(value,this,1);
            // Trata o erro da grade vazia
            if(disciplinas.isEmpty()){
                /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle("Sem disciplinas");
                builder.setMessage("Não há disciplinas em sua grade no momento.");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                GradeActivity.this.finish();
                                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                                }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();*/
            }
            else {
                Log.i("oi", disciplinas.get(0).getNome());
                // Usa DisciplinasAdapter para carregar as disciplinas
                listViewDeDisciplinas.setAdapter(new DisciplinasAdapter(disciplinas, this, 1));
                Log.i("oi", "c");
            }
        }
    }

    // Metodo pra atualizar a grade assim que a activity que adiciona disciplinas terminar
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE) {
            finish();
            startActivity(getIntent());
        }
    }

    //Volta para a activity anterior
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int orientacao = this.getResources().getConfiguration().orientation;
        if(orientacao == Configuration.ORIENTATION_LANDSCAPE) {

        }else{
        }
    }
}
