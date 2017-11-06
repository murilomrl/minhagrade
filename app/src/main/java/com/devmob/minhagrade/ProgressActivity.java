package com.devmob.minhagrade;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.TextView;

//import com.devmob.minhagrade.Lixo.Periodo;

import com.devmob.minhagrade.DB.DisciplinaDAO;

/**
 * Created by devmob on 27/03/17.
 */

@SuppressLint("SetJavaScriptEnabled")

public class ProgressActivity extends AppCompatActivity {

    private String curso;
    private TextView porcentagemConcluido;
    private TextView porcentagemCursando;
    private TextView porcentagemFaltando;
    private DisciplinaDAO disciplinaDAO = new DisciplinaDAO(this);

    private WebView webView;
    private int dadoConcluido, dadoCursando, dadoFaltando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        final Intent intent = getIntent();
        curso =  Prefs.getString(this,"course");
        TextView course = (TextView) findViewById(R.id.course);
        course.setText(curso);

        porcentagemConcluido = (TextView) findViewById(R.id.porcentagemConcluido);
        porcentagemCursando = (TextView) findViewById(R.id.porcentagemCursando);
        porcentagemFaltando = (TextView) findViewById(R.id.porcentagemFaltam);

        porcentagemConcluido.setText(disciplinaDAO.porcentagemDeDisciplinasPorStatus(2));
        porcentagemCursando.setText(disciplinaDAO.porcentagemDeDisciplinasPorStatus(1));
        porcentagemFaltando.setText(disciplinaDAO.porcentagemDeDisciplinasPorStatus(0));


        dadoConcluido = disciplinaDAO.quantidadeDisciplinasPorStatus(2);
        dadoCursando = disciplinaDAO.quantidadeDisciplinasPorStatus(1);
        dadoFaltando = disciplinaDAO.quantidadeDisciplinasPorStatus(0);

        webView = (WebView)findViewById(R.id.pizza);
        webView.addJavascriptInterface(new WebAppInterface(), "Android");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.loadUrl("file:///android_asset/chartsPie.html");

    }

    public class WebAppInterface{
        @JavascriptInterface
        public int getDadoConcluido(){
            return dadoConcluido;
        }
        @JavascriptInterface
        public int getDadoCursando(){
            return dadoCursando;
        }
        @JavascriptInterface
        public int getDadoFaltando(){
            return dadoFaltando;
        }
        @JavascriptInterface
        public int getWidth(){
            Display display = getWindowManager().getDefaultDisplay();
            return display.getWidth();
        }
        @JavascriptInterface
        public int getHeight(){
            Display display = getWindowManager().getDefaultDisplay();
            return display.getHeight();
        }
    }


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

}
