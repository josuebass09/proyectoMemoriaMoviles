package una.ac.cr.proyectomemoriamoviles;


import android.content.Context;

public class Puntuaciones {

    private int id;
    private String dificultad;
    private int tiempo;

    public Puntuaciones(int id, String dificultad, int tiempo) {
        this.id = id;
        this.dificultad = dificultad;
        this.tiempo = tiempo;
    }

    public Puntuaciones()
    {
        this.id=0;
        this.dificultad="";
        this.tiempo=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
