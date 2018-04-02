package com.devmob.minhagrade;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class NovoCursoActivity extends AppCompatActivity {

    ImageButton imageButtonNovoCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_curso);
        imageButtonNovoCurso = (ImageButton) findViewById(R.id.enviarCurso);
        imageButtonNovoCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto: devmob.ufrj@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Digite aqui seu curso");
            }
        });
    }
}
