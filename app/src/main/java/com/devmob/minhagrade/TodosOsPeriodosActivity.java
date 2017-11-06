package com.devmob.minhagrade;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.devmob.minhagrade.Adapter.PeriodoAdapter;
import com.devmob.minhagrade.DB.PeriodoDAO;
import com.devmob.minhagrade.Model.Periodo;

import java.util.ArrayList;
import java.util.List;

public class TodosOsPeriodosActivity extends AppCompatActivity implements OnItemClickListener {

    private String curso;
    private PeriodoAdapter periodoArrayAdapter;
    private ListView listView;
    private List<Periodo> periodoList = new ArrayList<>();
    private PeriodoDAO periodoDAO = new PeriodoDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);
        final Intent intent = getIntent();
        curso =  Prefs.getString(this, "course");
        TextView course = (TextView) findViewById(R.id.course);
        listView = (ListView) findViewById(R.id.listaPeriodo);
        course.setText(curso);

        periodoList = periodoDAO.getPeriodos();
        listView.setAdapter(new PeriodoAdapter(this,periodoList));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Periodo periodo = this.periodoList.get(position);
//        Log.d("Clickado",periodo.getNome());
        Intent intent = new Intent(this,PeriodoActivity.class);
        intent.putExtra("PERIODO", periodo.getNome());
        ActivityOptionsCompat opts =  ActivityOptionsCompat.makeCustomAnimation(this,R.anim.slide_in_left,R.anim.slide_out_left);
        ActivityCompat.startActivity(this,intent,opts.toBundle());
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
