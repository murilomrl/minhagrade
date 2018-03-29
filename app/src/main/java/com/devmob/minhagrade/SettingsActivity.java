package com.devmob.minhagrade;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.text.util.Linkify;
import android.view.MenuItem;
import android.view.View;
import android.widget.Scroller;
import android.widget.TextView;

import com.devmob.minhagrade.DB.PeriodoDAO;
import com.devmob.minhagrade.Model.Prefs;

import org.w3c.dom.Text;

/**
 * Created by georgerappel on 28/03/18.
 */

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    View apagarDados;
    View sobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        apagarDados = findViewById(R.id.apagarDados);
        sobre = findViewById(R.id.sobre);

        apagarDados.setOnClickListener(this);
        sobre.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent;
        ActivityOptionsCompat opts;
        switch (v.getId()){
            case R.id.minhaGrade:
                intent = new Intent(this, GradeActivity.class);
                opts =  ActivityOptionsCompat.makeCustomAnimation(this,R.anim.slide_in_left,R.anim.slide_out_left);
                ActivityCompat.startActivity(this,intent,opts.toBundle());
                break;
            case R.id.apagarDados:
                apagarDados();
                break;
            case R.id.sobre:
                dialogSobre();
                break;
        }

    }

    private void apagarDados(){
        final PeriodoDAO periodoDAO = new PeriodoDAO(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true)
            .setTitle("Confirmação")
            .setMessage("Você tem certeza que quer apagar os dados da sua grade?")
            .setPositiveButton("Sim",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        periodoDAO.apagaTudo();
                        Prefs.clear(SettingsActivity.this);
                        Intent intent = new Intent(SettingsActivity.this, CourseActivity.class);
                        ActivityOptionsCompat opts = ActivityOptionsCompat.makeCustomAnimation(SettingsActivity.this, R.anim.slide_in_right,R.anim.slide_out_right);
                        ActivityCompat.startActivity(SettingsActivity.this, intent,opts.toBundle());
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);
                    }
                })
            .setNegativeButton("Não", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void dialogSobre(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.sobre))
                .setMessage(getString(R.string.dialog_sobre_description))
                .setPositiveButton("Ok", null);
        AlertDialog dialog = builder.create();
        dialog.show();
        TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
        tvMessage.setScroller(new Scroller(this));
        tvMessage.setVerticalScrollBarEnabled(true);
        tvMessage.setMovementMethod(new ScrollingMovementMethod());
        tvMessage.setLinksClickable(true);
        tvMessage.setAutoLinkMask(Linkify.ALL);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
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
}
