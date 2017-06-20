package una.ac.cr.proyectomemoriamoviles;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DificultadActivity extends AppCompatActivity {
    private Button btnAtras;
    private Button btnOk;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private MediaPlayer sonidoToqueMenu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificultad);
        //Inicialiación de botones
        btnAtras=(Button)findViewById(R.id.btnAtrasDificultad);
        btnOk=(Button)findViewById(R.id.btnAceptarDificultad);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroupDificultad);

        sonidoToqueMenu= MediaPlayer.create(this,R.raw.sonidotoquemenu);
        sonidoToqueMenu.setAudioStreamType(AudioManager.STREAM_MUSIC);;




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
                    case "Facil":
                        enviarNivel("Facil");

                        break;

                    case "Medio":
                        enviarNivel("Medio");

                        break;

                    case "Dificil":
                        enviarNivel("Dificil");

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





    public void irAMainActivity()
    {

        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);






    }



    public void enviarNivel(String nivel)
    {
        Intent intent = new Intent(DificultadActivity.this, MainActivity.class);
        intent.putExtra("nivel",nivel);
        startActivity(intent);


    }









}
