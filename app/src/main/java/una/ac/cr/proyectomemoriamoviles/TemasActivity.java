package una.ac.cr.proyectomemoriamoviles;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TemasActivity extends AppCompatActivity {
    private Button btnAtras;
    private Button btnOk;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private RadioButton animales;
    private RadioButton personajes;
    private RadioButton paises;
    private RadioButton frutas;
    private MediaPlayer sonidoToqueMenu;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temas);
        //Inicialiación de botones
        btnAtras=(Button)findViewById(R.id.btnAtrasTema);
        btnOk=(Button)findViewById(R.id.btnAceptarTema);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroupTema);

        animales=(RadioButton)findViewById(R.id.radioAnimales);
        personajes=(RadioButton)findViewById(R.id.radioMedioTema);
        paises=(RadioButton)findViewById(R.id.radioPaises);
        frutas=(RadioButton)findViewById(R.id.radioFrutas);
        sonidoToqueMenu= MediaPlayer.create(this,R.raw.sonidotoquemenu);
        sonidoToqueMenu.setAudioStreamType(AudioManager.STREAM_MUSIC);;

        final int obtenerDatos = obtenerOpciones(this);


        //
        if(obtenerDatos==animales.getId()){
            animales.setChecked(true);
        } else if(obtenerDatos==personajes.getId()){
            personajes.setChecked(true);
        }else if(obtenerDatos==paises.getId()) {
            paises.setChecked(true);
        }else{
            frutas.setChecked(true);
        }


        //Listeners



        //Listeners

        btnOk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int radioSeleccionado=radioGroup.getCheckedRadioButtonId();
                radioButton=(RadioButton)findViewById(radioSeleccionado);


                switch(radioButton.getText().toString())
                {
                    case "Animales":
                        enviarTipoTema("Animales");


                        guardarOpcionSeleccionada(radioSeleccionado);
                        break;

                    case "Personas":
                        enviarTipoTema("Personas");


                        guardarOpcionSeleccionada(radioSeleccionado);
                        break;

                    case "Paises":
                        enviarTipoTema("Paises");


                        guardarOpcionSeleccionada(radioSeleccionado);
                        break;

                    case "Frutas":
                        enviarTipoTema("Frutas");

                        guardarOpcionSeleccionada(radioSeleccionado);
                        break;

                }
            }
        });


        btnAtras.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sonidoToqueMenu.start();
                irAMainActivity();
            }
        });
    }

    private void guardarOpcionSeleccionada(int radioSeleccionado) {

        SharedPreferences prefs = this.getSharedPreferences("AppPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Seleccionada",radioSeleccionado);
        editor.apply();
    }

    static public int obtenerOpciones(Context context){
        SharedPreferences prefs = context.getSharedPreferences("AppPrefs",MODE_PRIVATE);
        return prefs.getInt("Seleccionada",0);
    }


    public void irAMainActivity()
    {

        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }

    public void enviarTipoTema(String tipoTema)
    {
        Intent intent = new Intent(TemasActivity.this, MainActivity.class);
        intent.putExtra("tipoTema",tipoTema);
        startActivity(intent);
        finish();


    }









}