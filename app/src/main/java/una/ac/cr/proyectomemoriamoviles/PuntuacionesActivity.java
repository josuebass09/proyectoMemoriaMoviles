package una.ac.cr.proyectomemoriamoviles;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PuntuacionesActivity extends AppCompatActivity {

    private Button regresarPuntuaciones;
    private Button btnOk;
    private MediaPlayer sonidoToqueMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones);
        regresarPuntuaciones=(Button)findViewById(R.id.regresarPuntuaciones);


        sonidoToqueMenu=MediaPlayer.create(this,R.raw.sonidotoquemenu);
        sonidoToqueMenu.setAudioStreamType(AudioManager.STREAM_MUSIC);;


        //Listeners



        regresarPuntuaciones.setOnClickListener(new View.OnClickListener()
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


}