package una.ac.cr.proyectomemoriamoviles;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class PuntuacionesActivity extends AppCompatActivity {

    private Button regresarPuntuaciones;
    private Button btnOk;
    private MediaPlayer sonidoToqueMenu;
    private TextView textFacil;
    private TextView textMedio;
    private TextView textDificil;
    private TableLayout tabla;
    private TableRow fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones);
        regresarPuntuaciones=(Button)findViewById(R.id.regresarPuntuaciones);


        sonidoToqueMenu=MediaPlayer.create(this,R.raw.sonidotoquemenu);
        sonidoToqueMenu.setAudioStreamType(AudioManager.STREAM_MUSIC);;
        tabla=(TableLayout)findViewById(R.id.tabla);
        fila =new TableRow(getBaseContext());
        textFacil=(TextView)findViewById(R.id.puntageFacil);
        textMedio=(TextView)findViewById(R.id.puntageMedio);
        textDificil=(TextView)findViewById(R.id.puntageDificil);

        verificaDatosBD();



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

    public void verificaDatosBD()
    {
        PuntuacionesBDHelper PDB = new PuntuacionesBDHelper(getApplicationContext());
        int tiempoFacil = PDB.recuperarPuntuacion(1).getTiempo();
        int tiempoMedio=PDB.recuperarPuntuacion(2).getTiempo();
        int tiempoDificil=PDB.recuperarPuntuacion(3).getTiempo();
        textFacil.setText(String.valueOf(tiempoFacil));
        textMedio.setText(String.valueOf(tiempoMedio));
        textDificil.setText(String.valueOf(tiempoDificil));

    }


}