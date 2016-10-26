package me.cafetorres.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.cafetorres.myapplication.R;

/**
 * Created by Carlos on 25/10/2016.
 */


public class activity_detail extends AppCompatActivity{
    @Bind(R.id.txtTotal)
    TextView txtTotal;
    @Bind(R.id.txtPropina)
    TextView txtPropina;
    @Bind(R.id.txtFecha)
    TextView txtFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        ButterKnife.bind(this);



        Intent intent=getIntent();


        txtTotal.setText(intent.getStringExtra("Total"));
        txtPropina.setText(intent.getStringExtra("Propina"));
        txtFecha.setText(intent.getStringExtra("Fecha"));

    }
}
