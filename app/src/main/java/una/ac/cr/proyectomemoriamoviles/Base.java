package una.ac.cr.proyectomemoriamoviles;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

/**
 * Created by josue on 19/06/17.
 */

public class Base extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btn1;
    private ImageButton btn2;
    private ImageButton btn3;
    private ImageButton btn4;
    private ImageButton btn5;
    private ImageButton btn6;
    private ImageButton btn7;
    private ImageButton btn8;
    private ImageButton btn9;
    private ImageButton btn10;
    private ImageButton btn11;
    private ImageButton btn12;
    private ImageButton btn13;
    private ImageButton btn14;
    private ImageButton btn15;
    private ImageButton btn16;
    private ImageButton btn17;
    private ImageButton btn18;
    private ImageButton btn19;
    private ImageButton btn20;
    private Button comienzo;
    private MediaPlayer mp,mp2,mp3;
    private Animation mover,gira;
    private int regresiva;
    int contadorAscendente;
    int contadorDescendente;
    private boolean seAcabo=false;

    Random azar;
    private static int tam_lista_num=10;


    private int cuenta;
    private TimerTask tarea, tarea2;
    private int numeroJugada = 0;
    private Timer timer;
    private Timer timer2;
    private int posicion1 = 0, posicion2 = 0;
    private int id_posi = 0;

    private String vectAzares [];
    int vectConvertidos[];
    private int contadorGane=0;

    private ImageButton [] vectBotones;

    private ArrayList<Integer> listaGuardados;
    private ArrayList<Integer> listaNumeros;
    private int posicionamiento1=0;
    private int posicionamiento2=0;
    private boolean volvioJugar=false;
    private String tipoTema;
    private TextView cronometro;
    private ProgressBar barraProgreso;
    private boolean nuevoRecord;

    private int segundosC;
    private int reiniciarS;
    private String tipoDificultad;
    private PuntuacionesBDHelper PDB;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);
        listaGuardados = new ArrayList<Integer>();
        listaNumeros=new ArrayList<Integer>();
        vectBotones=new ImageButton[20];
        vectAzares=new String [20];
        vectConvertidos=new int[20];
        mover= AnimationUtils.loadAnimation(this,R.anim.moverse);
        gira=AnimationUtils.loadAnimation(this,R.anim.gira);
        tipoTema="Animales";

        nuevoRecord=false;



        btn1 = (ImageButton) findViewById(R.id.imageButton1);
        btn2 = (ImageButton) findViewById(R.id.imageButton2);
        btn3 = (ImageButton) findViewById(R.id.imageButton3);
        btn4 = (ImageButton) findViewById(R.id.imageButton4);
        btn5 = (ImageButton) findViewById(R.id.imageButton5);
        btn6 = (ImageButton) findViewById(R.id.imageButton6);
        btn7 = (ImageButton) findViewById(R.id.imageButton7);
        btn8 = (ImageButton) findViewById(R.id.imageButton8);
        btn9 = (ImageButton) findViewById(R.id.imageButton9);
        btn10 = (ImageButton) findViewById(R.id.imageButton10);
        btn11 = (ImageButton) findViewById(R.id.imageButton11);
        btn12 = (ImageButton) findViewById(R.id.imageButton12);
        btn13 = (ImageButton) findViewById(R.id.imageButton13);
        btn14 = (ImageButton) findViewById(R.id.imageButton14);
        btn15 = (ImageButton) findViewById(R.id.imageButton15);
        btn16 = (ImageButton) findViewById(R.id.imageButton16);
        btn17 = (ImageButton) findViewById(R.id.imageButton17);
        btn18 = (ImageButton) findViewById(R.id.imageButton18);
        btn19 = (ImageButton) findViewById(R.id.imageButton19);
        btn20 = (ImageButton) findViewById(R.id.imageButton20);
        comienzo = (Button) findViewById(R.id.comienzo);
        cronometro=(TextView)findViewById(R.id.cronometro);
        barraProgreso=(ProgressBar)findViewById(R.id.barraProgreso);
        PDB= new PuntuacionesBDHelper(getApplicationContext());
        PDB.insertarPuntuacion(1, "Facil",  0);
        PDB.insertarPuntuacion(2, "Medio",  0);
        PDB.insertarPuntuacion(3, "Dificil",  0);
        int idDificultad = DificultadActivity.obtenerOpcionesD(this);

        if(idDificultad == R.id.radioFacil || idDificultad==0)
        {
            regresiva = 100;
            segundosC = 100000;
            reiniciarS = 100;
            tipoDificultad="Facil";








        }
        else if(idDificultad == R.id.radioMedio)
        {
            regresiva = 80;
            segundosC = 80000;
            reiniciarS = 80;
            tipoDificultad="Medio";




        }
        else if(idDificultad==R.id.radioDificil)
        {

            regresiva = 60;
            segundosC = 60000;
            reiniciarS = 60;
            tipoDificultad="Dificil";



        }




        barraProgreso.setMax(regresiva);
        contadorAscendente=0;
        contadorDescendente=20;


        azar=new Random();
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);
        btn18.setOnClickListener(this);
        btn19.setOnClickListener(this);
        btn20.setOnClickListener(this);
        comienzo.setOnClickListener(this);
        cuenta = 0;
        guardaBotonesVector();
        mp=MediaPlayer.create(this, R.raw.sonidotoque);
        mp2=MediaPlayer.create(this, R.raw.sonidotoquepareja);
        mp3=MediaPlayer.create(this, R.raw.finalizo);
        barraProgreso=(ProgressBar)findViewById(R.id.barraProgreso);
        for(int i=0;i<20;i++)
        {
            vectBotones[i].setClickable(false);
            vectBotones[i].setAnimation(mover);
            vectBotones[i].setAnimation(gira);
        }


        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp2.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp3.setAudioStreamType(AudioManager.STREAM_MUSIC);





        int idTema = TemasActivity.obtenerOpciones(this);

        if(idTema==R.id.radioAnimales)
        {
            tipoTema = "Animales";
        }
        else if(idTema==R.id.radioMedioTema)
        {
            tipoTema = "Personas";
        }
        else if(idTema==R.id.radioPaises)
        {
            tipoTema="Paises";
        }
        else
        {
            tipoTema="Frutas";
        }









        mover.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        gira.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void llenaNumeros()
    {
        for(int i=0;i<10;i++)
        {
            listaNumeros.add(i,i);
        }
    }
    public void guardaBotonesVector()
    {
        vectBotones[0]=btn1;
        vectBotones[1]=btn2;
        vectBotones[2]=btn3;
        vectBotones[3]=btn4;
        vectBotones[4]=btn5;
        vectBotones[5]=btn6;
        vectBotones[6]=btn7;
        vectBotones[7]=btn8;
        vectBotones[8]=btn9;
        vectBotones[9]=btn10;
        vectBotones[10]=btn11;
        vectBotones[11]=btn12;
        vectBotones[12]=btn13;
        vectBotones[13]=btn14;
        vectBotones[14]=btn15;
        vectBotones[15]=btn16;
        vectBotones[16]=btn17;
        vectBotones[17]=btn18;
        vectBotones[18]=btn19;
        vectBotones[19]=btn20;



    }


    public void setNumeroJugada(int num)
    {
        this.numeroJugada=num;
    }
    int getNumeroJugada()
    {
        return numeroJugada;
    }

    public void cargaTodo()
    {
        llenaNumeros();
        llenaGuardados();



        saca10Cartas(0,10);
        saca10Cartas(10,20);
    }



    public void cargaPregunta()
    {

        switch (contadorDescendente) {

            case -1:
                pararTimer2();

                break;
            case 0:
                btn1.setBackgroundResource(R.drawable.pregunta);

                break;
            case 1:
                btn2.setBackgroundResource(R.drawable.pregunta);

                break;

            case 2:
                btn3.setBackgroundResource(R.drawable.pregunta);

                break;


            case 3:
                btn4.setBackgroundResource(R.drawable.pregunta);

                break;

            case 4:
                btn5.setBackgroundResource(R.drawable.pregunta);

                break;

            case 5:

                btn6.setBackgroundResource(R.drawable.pregunta);

                break;

            case 6:
                btn7.setBackgroundResource(R.drawable.pregunta);

                break;

            case 7:
                btn8.setBackgroundResource(R.drawable.pregunta);

                break;

            case 8:
                btn9.setBackgroundResource(R.drawable.pregunta);
                break;

            case 9:
                btn10.setBackgroundResource(R.drawable.pregunta);
                break;

            case 10:
                btn11.setBackgroundResource(R.drawable.pregunta);
                break;

            case 11:
                btn12.setBackgroundResource(R.drawable.pregunta);
                break;

            case 12:
                btn13.setBackgroundResource(R.drawable.pregunta);
                break;

            case 13:
                btn14.setBackgroundResource(R.drawable.pregunta);
                break;

            case 14:
                btn15.setBackgroundResource(R.drawable.pregunta);
                break;

            case 15:
                btn16.setBackgroundResource(R.drawable.pregunta);
                break;

            case 16:
                btn17.setBackgroundResource(R.drawable.pregunta);
                break;

            case 17:
                btn18.setBackgroundResource(R.drawable.pregunta);
                break;

            case 18:
                btn19.setBackgroundResource(R.drawable.pregunta);
                break;

            case 19:
                btn20.setBackgroundResource(R.drawable.pregunta);
                break;
        }
        contadorDescendente--;
    }





    public void irAMenu()
    {


        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);




    }
    public void iniciaTimer()
    {


        contadorAscendente=0;
        contadorDescendente=20;
        cargaTodo();
        posicionamiento1=0;
        posicionamiento2=0;
        posicion1=0;
        posicion2=0;

        if(volvioJugar==true)
        {
            numeroJugada=1;
            volvioJugar=false;

        }
        else
        {
            numeroJugada = 0;
        }
        timer=new Timer();



        tarea = new TimerTask()
        {
            @Override
            public void run() {

                runOnUiThread(new Runnable()
                {

                    @Override
                    public void run()
                    {


                        cargaPersonajes();
                    }

                });

            }


        };

        timer2=new Timer();
        tarea2 = new TimerTask()
        {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {

                    @Override
                    public void run()
                    {
                        cargaPregunta();
                    }

                });

            }


        };


    }
    public void saca10Cartas(int contador,int posi)
    {
        String carta="";
        switch(tipoTema)
        {
            case "Animales":
                carta="animal";
                break;

            case "Personas":
                carta="personaje";
                break;

            case "Paises":
                carta="bandera";
                break;

            case "Frutas":
                carta="fruta";
                break;


        }

        while(contador<posi)
        {//saca las cartas al azar

            vectAzares[contador] = carta + sacaNumeroAzar();
            int id = getResources().getIdentifier(vectAzares[contador], "drawable", getPackageName());
            vectConvertidos[contador] = id;


            contador++;
        }

        tam_lista_num=10;
        llenaNumeros();
    }








    public void pararTimer()
    {

        if (timer != null) {
            timer.cancel();


        }


    }

    public void llenaGuardados()
    {
        for(int i=0;i<20;i++)
        {
            listaGuardados.add(i);
        }

    }


    public void pararTimer2()
    {
        if (timer2 != null) {
            timer2.cancel();

            activaBotones();
            iniciarCuentaRegresiva();
        }
    }


    public void iniciarCuentaRegresiva() {



        new CountDownTimer(segundosC, 1000) {


            public void onTick(long millisUntilFinished) {
                if(seAcabo)
                {
                    cancel();
                    onFinish();

                }
                else {

                    regresiva--;
                    if (regresiva <= 15)
                    {

                        cronometro.setTextColor(Color.RED);

                    } else
                    {
                        cronometro.setTextColor(Color.WHITE);

                    }

                    cronometro.setText(String.valueOf(regresiva));
                    barraProgreso.setProgress(regresiva);
                    barraProgreso.setBackgroundResource(R.color.colorPrimaryDark);


                }
            }

            public void onFinish()
            {
                boolean nuevoRecord=false;
                boolean gano=false;
                if(regresiva<=1)
                {
                    preguntaJuego(nuevoRecord,gano);
                }
                else
                {

                   //trae los tiempos de cada dificultad y los guarda en un vector
                    int tiempos[]=new int[3];

                    for(int i=0;i<tiempos.length;i++)
                    {

                            tiempos[i]=PDB.recuperarPuntuacion(i+1);





                    }

                         //Evalua los tiempos anteriores guardados en la base con el nuevo y verifica si hay nuevo record
                    //el switch es para validar las diferentes dificultades que hay
                        switch (tipoDificultad)
                        {
                            case "Facil":
                                if(regresiva > tiempos[0])
                                {
                                    PDB.modificarPuntuacion(1, "Facil",regresiva);
                                    nuevoRecord=true;

                                }


                                break;
                            case "Medio":

                                if(regresiva > tiempos[1])
                                {
                                    PDB.modificarPuntuacion(2, "Medio",regresiva);
                                    nuevoRecord=true;

                                }




                                break;
                            case "Dificil":
                                if(regresiva > tiempos[2])
                                {
                                    PDB.modificarPuntuacion(3, "Dificil",regresiva);
                                    nuevoRecord=true;
                                }



                        }






                        // Recuperamos los 4 registros y los mostramos en el log por consola

                        Log.d("TOTAL", Integer.toString(PDB.recuperarPuntuaciones().size()));

                    int[] ids = new int[PDB.recuperarPuntuaciones().size()];
                    String[] dics = new String[PDB.recuperarPuntuaciones().size()];
                    int[] timps = new int[PDB.recuperarPuntuaciones().size()];
                    for (int i = 0; i < PDB.recuperarPuntuaciones().size(); i++) {
                        ids[i] = PDB.recuperarPuntuaciones().get(i).getId();
                        dics[i] = PDB.recuperarPuntuaciones().get(i).getDificultad();
                        timps[i] = PDB.recuperarPuntuaciones().get(i).getTiempo();

                        Log.d(""+ids[i], dics[i] + ", " + timps[i]);

                    }
                    gano=true;
                    preguntaJuego(nuevoRecord,gano);

                }

   /*  Otros metodos

   // Modificamos el registro 3
        PDB.modificarPuntuacion(3, "PPPPP", 121212121, "zzzz@xxxx.es");

        // Recuperamos el 3 registro dato por dato y lo mostramos en el log

        int id = PDB.recuperarCONTACTO(3).getId();
        String nombre = PDB.recuperarPuntuacion(3).getDificultad();
        int telefono = PDB.recuperarPuntuacion(3).getTiempo();
        Log.d(""+id, dificultad + ", " + tiempo );

        // Para borrar el registro 3
        PDB.borrarPuntuacion(3); */







            }


        }.start();


    }


    public void reestablecerValoresCronometro()
    {
        regresiva=reiniciarS;
        cronometro.setTextColor(Color.WHITE);
        cronometro.setText("0");
        seAcabo=false;
        volvioJugar=true;
        nuevoRecord=false;


    }


    public void activaBotones()
    {
        for(int i=0;i<vectBotones.length;i++)
        {
            vectBotones[i].setClickable(true);
        }
    }
    public void desactivaBotones()
    {
        for(int i=0;i<vectBotones.length;i++)
        {
            vectBotones[i].setClickable(false);
        }
    }
    public void DevuelveCartas()
    {

        timer2.schedule(tarea2, 1000, 100);
      /*  comienzo.setClickable(false);*/






    }



    public void cargaPersonajes()
    {

        switch (contadorAscendente) {
            case 0:


                btn1.setVisibility(View.VISIBLE);
                btn1.setBackgroundResource(vectConvertidos[contadorAscendente]);




                break;
            case 1:
                btn2.setVisibility(View.VISIBLE);
                btn2.setBackgroundResource(vectConvertidos[contadorAscendente]);

                break;

            case 2:
                btn3.setVisibility(View.VISIBLE);
                btn3.setBackgroundResource(vectConvertidos[contadorAscendente]);


                break;


            case 3:
                btn4.setVisibility(View.VISIBLE);
                btn4.setBackgroundResource(vectConvertidos[contadorAscendente]);

                break;

            case 4:
                btn5.setVisibility(View.VISIBLE);
                btn5.setBackgroundResource(vectConvertidos[contadorAscendente]);

                break;

            case 5:

                btn6.setVisibility(View.VISIBLE);
                btn6.setBackgroundResource(vectConvertidos[contadorAscendente]);

                break;

            case 6:
                btn7.setVisibility(View.VISIBLE);
                btn7.setBackgroundResource(vectConvertidos[contadorAscendente]);

                break;

            case 7:
                btn8.setVisibility(View.VISIBLE);
                btn8.setBackgroundResource(vectConvertidos[contadorAscendente]);

                break;

            case 8:
                btn9.setVisibility(View.VISIBLE);
                btn9.setBackgroundResource(vectConvertidos[contadorAscendente]);
                break;

            case 9:
                btn10.setVisibility(View.VISIBLE);
                btn10.setBackgroundResource(vectConvertidos[contadorAscendente]);
                break;

            case 10:
                btn11.setVisibility(View.VISIBLE);
                btn11.setBackgroundResource(vectConvertidos[contadorAscendente]);
                break;

            case 11:
                btn12.setVisibility(View.VISIBLE);
                btn12.setBackgroundResource(vectConvertidos[contadorAscendente]);
                break;

            case 12:
                btn13.setVisibility(View.VISIBLE);
                btn13.setBackgroundResource(vectConvertidos[contadorAscendente]);
                break;

            case 13:
                btn14.setVisibility(View.VISIBLE);
                btn14.setBackgroundResource(vectConvertidos[contadorAscendente]);
                break;

            case 14:
                btn15.setVisibility(View.VISIBLE);
                btn15.setBackgroundResource(vectConvertidos[contadorAscendente]);
                break;

            case 15:
                btn16.setVisibility(View.VISIBLE);
                btn16.setBackgroundResource(vectConvertidos[contadorAscendente]);
                break;

            case 16:
                btn17.setVisibility(View.VISIBLE);
                btn17.setBackgroundResource(vectConvertidos[contadorAscendente]);
                break;

            case 17:
                btn18.setVisibility(View.VISIBLE);
                btn18.setBackgroundResource(vectConvertidos[contadorAscendente]);
                break;

            case 18:
                btn19.setVisibility(View.VISIBLE);
                btn19.setBackgroundResource(vectConvertidos[contadorAscendente]);
                break;

            case 19:
                btn20.setVisibility(View.VISIBLE);
                btn20.setBackgroundResource(vectConvertidos[contadorAscendente]);


                break;

            case 20:

                try
                {
                    pararTimer();


                    DevuelveCartas();


                }
                catch (Exception er)
                {
                }
                break;


        }
        contadorAscendente++;

    }
    public int sacaNumeroAzar()
    {



        if(tam_lista_num>0)
        {
            int num = azar.nextInt(tam_lista_num);
            tam_lista_num--;
            int auxiliarLista = listaNumeros.get(num);
            listaNumeros.remove(Integer.valueOf(auxiliarLista));

            return auxiliarLista;
        }





        return 0;
    }

    public void salirTotalmente()
    {
        Intent intento=new Intent(Intent.ACTION_MAIN);
        intento.addCategory(Intent.CATEGORY_HOME);
        intento.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intento);
    }



    public void jugar()
    {
        comienzo.setClickable(false);
        contadorGane=0;
        iniciaTimer();
        timer.schedule(tarea,0,100);
    }



    @Override
    public void onClick(View v)
    {


        if (numeroJugada > 2)
        {



            //setearCartasPregunta();




            numeroJugada = 1;
            posicionamiento1=0;
            posicionamiento2=0;



        }
        int temp=0;
        switch (v.getId())
        {



            case R.id.comienzo:

                comienzo.setClickable(true);
                jugar();



                break;
            case R.id.imageButton1:
                id_posi = vectConvertidos[0];
                temp=1;

                mp.start();


                btn1.setBackgroundResource(vectConvertidos[0]);



                break;


            case R.id.imageButton2:
                mp.start();
                id_posi = vectConvertidos[1];
                btn2.setBackgroundResource(vectConvertidos[1]);

                temp=2;
                break;

            case R.id.imageButton3:
                mp.start();
                btn3.setBackgroundResource(vectConvertidos[2]);
                id_posi = vectConvertidos[2];

                temp=3;
                break;

            case R.id.imageButton4:
                mp.start();
                btn4.setBackgroundResource(vectConvertidos[3]);
                id_posi = vectConvertidos[3];

                temp=4;
                break;

            case R.id.imageButton5:
                mp.start();
                btn5.setBackgroundResource(vectConvertidos[4]);
                id_posi = vectConvertidos[4];

                temp=5;
                break;

            case R.id.imageButton6:
                mp.start();
                btn6.setBackgroundResource(vectConvertidos[5]);
                id_posi = vectConvertidos[5];

                temp=6;
                break;

            case R.id.imageButton7:
                mp.start();
                btn7.setBackgroundResource(vectConvertidos[6]);
                id_posi = vectConvertidos[6];

                temp=7;
                break;

            case R.id.imageButton8:
                mp.start();
                btn8.setBackgroundResource(vectConvertidos[7]);
                id_posi = vectConvertidos[7];

                temp=8;
                break;

            case R.id.imageButton9:
                mp.start();
                btn9.setBackgroundResource(vectConvertidos[8]);
                id_posi = vectConvertidos[8];

                temp=9;
                break;

            case R.id.imageButton10:
                mp.start();
                btn10.setBackgroundResource(vectConvertidos[9]);
                id_posi = vectConvertidos[9];

                temp=10;
                break;

            case R.id.imageButton11:
                mp.start();
                btn11.setBackgroundResource(vectConvertidos[10]);
                id_posi = vectConvertidos[10];

                temp=11;
                break;

            case R.id.imageButton12:
                mp.start();
                btn12.setBackgroundResource(vectConvertidos[11]);
                id_posi = vectConvertidos[11];

                temp=12;

                break;

            case R.id.imageButton13:
                mp.start();
                btn13.setBackgroundResource(vectConvertidos[12]);
                id_posi = vectConvertidos[12];

                temp=13;
                break;
            case R.id.imageButton14:
                mp.start();
                btn14.setBackgroundResource(vectConvertidos[13]);
                id_posi = vectConvertidos[13];

                temp=14;
                break;
            case R.id.imageButton15:
                mp.start();
                btn15.setBackgroundResource(vectConvertidos[14]);
                id_posi = vectConvertidos[14];

                temp=15;
                break;
            case R.id.imageButton16:
                mp.start();
                btn16.setBackgroundResource(vectConvertidos[15]);
                id_posi = vectConvertidos[15];

                temp=16;
                break;
            case R.id.imageButton17:
                mp.start();
                btn17.setBackgroundResource(vectConvertidos[16]);
                id_posi = vectConvertidos[16];

                temp=17;
                break;
            case R.id.imageButton18:
                mp.start();
                btn18.setBackgroundResource(vectConvertidos[17]);
                id_posi = vectConvertidos[17];


                temp=18;
                break;
            case R.id.imageButton19:
                mp.start();
                btn19.setBackgroundResource(vectConvertidos[18]);
                id_posi = vectConvertidos[18];

                temp=19;
                break;
            case R.id.imageButton20:
                mp.start();
                btn20.setBackgroundResource(vectConvertidos[19]);
                id_posi = vectConvertidos[19];

                temp=20;
                break;


        }




        if (numeroJugada > 0)
        {



            switch (numeroJugada)
            {
                case 1:
                    posicion1 = id_posi;
                    posicionamiento1=temp;


                    break;
                case 2:
                    posicion2 = id_posi;
                    posicionamiento2=temp;

                    break;
            }

            if (numeroJugada == 2)
            {

                desactivaBotones();
                if (posicion1 == posicion2 &&posicionamiento1!=posicionamiento2)
                {
                    mp2.start();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            // acciones que se ejecutan tras los milisegundos



                            listaGuardados.remove(Integer.valueOf(posicionamiento1 - 1));
                            listaGuardados.remove(Integer.valueOf(posicionamiento2 - 1));

                            vectBotones[posicionamiento1 - 1].setClickable(false);
                            vectBotones[posicionamiento2 - 1].setClickable(false);

                            vectBotones[posicionamiento1-1].startAnimation(gira);
                            vectBotones[posicionamiento2-1].startAnimation(gira);
                            vectBotones[posicionamiento1-1].setVisibility(View.INVISIBLE);
                            vectBotones[posicionamiento2-1].setVisibility(View.INVISIBLE);

                            activaBotones();





                        }
                    }, 500);


                    contadorGane++;
                }
                else
                {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            // acciones que se ejecutan tras los milisegundos
                            setearCartasPregunta();
                            activaBotones();






                        }
                    }, 500);

                }


            }



            if(contadorGane==10)
            {
                mp3.start();


                contadorGane=0;
                seAcabo=true;

                acomodaCartasPregunta();





            }
        }
        numeroJugada++;

    }



    public void preguntaJuego(boolean nuevoRecord,boolean gano)
    {
        AlertDialog.Builder alerta=new AlertDialog.Builder(this);


        if(nuevoRecord)
        {
            alerta.setTitle("Excelente!!, Nuevo record!!");
        }
        else
        {
            if(!gano)
            {
                alerta.setTitle("Has perdido!");
            }
            else
            {
                alerta.setTitle("Ganastes!!");
            }
        }

        alerta.setMessage("Jugar de nuevo?");

        alerta.setCancelable(false);

        alerta.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {


                reestablecerValoresCronometro();
                desactivaBotones();
                jugar();









            }
        });

        alerta.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                irAMenu();


            }
        });






        alerta.show();


    }

    public void setearCartasPregunta()
    {
        for (int i = 0; i < 20; i++)
        {

            for (int j = 0; j < listaGuardados.size(); j++)
            {

                if (i ==listaGuardados.get(j))
                {

                    vectBotones[i].setBackgroundResource(R.drawable.pregunta);
                    vectBotones[i].setClickable(true);

                }


            }

        }


    }

    public void acomodaCartasPregunta()
    {

        guardaBotonesVector();

        // acciones que se ejecutan tras los milisegundos
        for (int i = 0; i < vectBotones.length; i++)
        {

            vectBotones[i].setBackgroundResource(R.drawable.pregunta);


        }



    }


    public void esperarYCerrar(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos

            }
        }, milisegundos);
    }









}