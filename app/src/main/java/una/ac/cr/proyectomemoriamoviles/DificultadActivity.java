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

public class DificultadActivity extends AppCompatActivity {
    private Button btnAtras;
    private Button btnOk;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private MediaPlayer sonidoToqueMenu;
    private RadioButton facil;
    private RadioButton medio;
    private RadioButton dificil;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificultad);
        //Inicialiación de botones
        btnAtras=(Button)findViewById(R.id.btnAtrasDificultad);
        btnOk=(Button)findViewById(R.id.btnAceptarDificultad);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroupDificultad);

        sonidoToqueMenu= MediaPlayer.create(this,R.raw.sonidotoquemenu);
        sonidoToqueMenu.setAudioStreamType(AudioManager.STREAM_MUSIC);


        facil = (RadioButton)findViewById(R.id.radioFacil);
        medio = (RadioButton)findViewById(R.id.radioMedio);
        dificil = (RadioButton)findViewById(R.id.radioDificil);

        final int obtenerDificultad = obtenerOpcionesD(this);


        if(obtenerDificultad==facil.getId()){
            facil.setChecked(true);
        }else if(obtenerDificultad==medio.getId()){
            medio.setChecked(true);
        }else if(obtenerDificultad==dificil.getId()){
            dificil.setChecked(true);
        }




        //Listeners

        btnOk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int radioNSeleccionado=radioGroup.getCheckedRadioButtonId();
                radioButton=(RadioButton)findViewById(radioNSeleccionado);


                switch(radioButton.getText().toString())
                {
                    case "Facil":
                        enviarNivel("Facil");

                        guardarNivelSeleccionado(radioNSeleccionado);

                        break;

                    case "Medio":
                        enviarNivel("Medio");

                        guardarNivelSeleccionado(radioNSeleccionado);

                        break;

                    case "Dificil":
                        enviarNivel("Dificil");

                        guardarNivelSeleccionado(radioNSeleccionado);

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


    private void guardarNivelSeleccionado(int radioNSeleccionado) {

        SharedPreferences prefD = this.getSharedPreferences("AppPrefD",MODE_PRIVATE);
        SharedPreferences.Editor editorD = prefD.edit();
        editorD.putInt("Seleccionada",radioNSeleccionado);
        editorD.apply();
    }

    static public int obtenerOpcionesD(Context context){
        SharedPreferences prefD = context.getSharedPreferences("AppPrefD",MODE_PRIVATE);
        return prefD.getInt("Seleccionada",0);
    }


    public void irAMainActivity()
    {

        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();






    }



    public void enviarNivel(String nivel)
    {
        Intent intent = new Intent(DificultadActivity.this, MainActivity.class);
        intent.putExtra("nivel",nivel);
        startActivity(intent);
        finish();


    }









}
