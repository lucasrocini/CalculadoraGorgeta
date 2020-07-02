package com.example.calculadoragorgeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorgeta;
    private TextView textTotal;
    private SeekBar seekBarGorgeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor         = findViewById(R.id.editValor);
        textGorgeta       = findViewById(R.id.textGorgeta);
        textPorcentagem   = findViewById(R.id.textPorcentagem);
        textTotal         = findViewById(R.id.textTotal);
        seekBarGorgeta    = findViewById(R.id.seekBarGorgeta);

        //listener para o seekbar
        seekBarGorgeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText( Math.round(porcentagem) + " %" );
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){
        String valorRecuperado = editValor.getText().toString();
        if( valorRecuperado == null || valorRecuperado.equals("") ){
            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro!",
                    Toast.LENGTH_LONG
            ).show();
        }else{
            //converter string recuperada para double
            double valorDigitado = Double.parseDouble( valorRecuperado );

            //calculo da gorgeta
            double gorgeta = valorDigitado * (porcentagem/100);
            double total = gorgeta + valorDigitado;

            //exibe a gorgeta e total
            //textGorgeta.setText("R$ " + Math.round(gorgeta));
            textGorgeta.setText("R$ " + gorgeta);
            textTotal.setText("R$ " + total);

        }
    }
}