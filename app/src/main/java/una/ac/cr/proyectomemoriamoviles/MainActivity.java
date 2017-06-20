package una.ac.cr.proyectomemoriamoviles;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {


    private Button btnDificultad;
    private Button btnTemas;
    private Button btnPuntuaciones;
    private Button btnIniciarJuego;
    private Button btnSalir;

    private MediaPlayer sonidoToqueMenu;
    private Vector<String> datosConfiguracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnDificultad=(Button)findViewById(R.id.btnDificultad);
        btnTemas=(Button)findViewById(R.id.btnTemas);
        btnPuntuaciones=(Button)findViewById(R.id.btnTiempos);
        btnIniciarJuego=(Button)findViewById(R.id.btnIniciarJuego);
        btnSalir=(Button)findViewById(R.id.btnSalir);
        sonidoToqueMenu=MediaPlayer.create(this,R.raw.sonidotoque);
        sonidoToqueMenu.setAudioStreamType(AudioManager.STREAM_MUSIC);;







        //Listener de los botones del menu

        //boton de dificultad
        btnDificultad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                irADificultadActivity();
            }
        });

        //boton de temas
        btnTemas.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                irATemasActivity();
            }
        });

        //boton puntuaciones
        btnPuntuaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAPuntuacionesActivity();
            }
        });

        btnIniciarJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irIniciarJuegoActivity();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                salir();
            }
        });


    }


    public void irADificultadActivity()
    {
        sonidoToqueMenu.start();
        Intent intent=new Intent(this,DificultadActivity.class);
        startActivity(intent);

    }

    public void irATemasActivity()
    {

        sonidoToqueMenu.start();
        Intent intent=new Intent(this,TemasActivity.class);
        startActivity(intent);
    }

    public void irAPuntuacionesActivity()
    {
        sonidoToqueMenu.start();
        Intent intent=new Intent(this,PuntuacionesActivity.class);
        startActivity(intent);
    }

    public void irIniciarJuegoActivity(){

        sonidoToqueMenu.start();
        Intent intent=new Intent(this,Base.class);
        startActivity(intent);
    }

    public void salir()
    {
        finish();
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }









}