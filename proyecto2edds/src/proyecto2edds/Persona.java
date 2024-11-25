/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edds;

/**
 * La clase Persona representa a un individuo en un árbol genealógico,
 * con atributos que describen su identidad, familia y características.
 * 
 * @author jorge
 */
public class Persona {

    private String nombre;
    private String numeral;
    private String padre;
    private String madre;
    private String mote;
    private String titulo;
    private String esposa;
    private String colorOjos;
    private String colorCabello;
    private String comentVida;
    private String comentMuerte;
    /**
     * Constructor que inicializa una nueva persona con el nombre proporcionado.
     * 
     * @param nombre El nombre de la persona.
     */
    public Persona(String nombre) {
        this.nombre = nombre;
        this.numeral = null;
        this.padre = null;
        this.madre = null;
        this.mote = null;
        this.titulo = null;
        this.esposa = null;
        this.colorOjos = null;
        this.colorCabello = null;
        this.comentVida = null;
        this.comentMuerte = null;
    }
    /**
     * Obtiene el nombre de la persona.
     * 
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre de la persona.
     * 
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene el numeral asociado a la persona.
     * 
     * @return El numeral de la persona.
     */
    public String getNumeral() {
        return numeral;
    }
    /**
     * Establece el numeral de la persona.
     * 
     * @param numeral El nuevo numeral de la persona.
     */
    public void setNumeral(String numeral) {
        this.numeral = numeral;
    }
    /**
     * Obtiene el nombre del padre de la persona.
     * 
     * @return El nombre del padre.
     */
    public String getPadre() {
        return padre;
    }
    /**
     * Establece el nombre del padre de la persona.
     * 
     * @param padre El nuevo nombre del padre.
     */
    public void setPadre(String padre) {
        this.padre = padre;
    }
     /**
     * Obtiene el nombre de la madre de la persona.
     * 
     * @return El nombre de la madre.
     */
    public String getMadre() {
        return madre;
    }
    /**
     * Establece el nombre de la madre de la persona.
     * 
     * @param madre El nuevo nombre de la madre.
     */
    public void setMadre(String madre) {
        this.madre = madre;
    }
    /**
     * Obtiene el mote de la persona.
     * 
     * @return El mote de la persona.
     */
    public String getMote() {
        return mote;
    }
    /**
     * Establece el mote de la persona.
     * 
     * @param mote El nuevo mote de la persona.
     */
    public void setMote(String mote) {
        this.mote = mote;
    }
     /**
     * Obtiene el título de la persona.
     * 
     * @return El título de la persona.
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Establece el título de la persona.
     * 
     * @param titulo El nuevo título de la persona.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEsposa() {
        return esposa;
    }

    public void setEsposa(String esposa) {
        this.esposa = esposa;
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    public String getColorCabello() {
        return colorCabello;
    }

    public void setColorCabello(String colorCabello) {
        this.colorCabello = colorCabello;
    }

    public String getComentVida() {
        return comentVida;
    }

    public void setComentVida(String comentVida) {
        this.comentVida = comentVida;
    }

    public String getComentMuerte() {
        return comentMuerte;
    }
     /**
     * Establece los comentarios sobre la muerte de la persona.
     * 
     * @param comentMuerte Los nuevos comentarios sobre la muerte.
     */
    public void setComentMuerte(String comentMuerte) {
        this.comentMuerte = comentMuerte;
    }
    /**
     * Genera un nombre único para la persona, utilizando el mote si está disponible.
     * 
     * @return El nombre único de la persona.
     */
    public String nombreUnico() {
        if (this.mote == null) {
            return this.getNombre() + "" + this.getNumeral();
        }

        return this.mote;
    }
    /**
     * Genera un nombre que incluye el nombre y el numeral.
     * 
     * @return El nombre combinado con el numeral.
     */
    public String nombreNumeral() {
        return this.getNombre() + " " + this.getNumeral();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nNombre=").append(nombre);
        sb.append(", \nNumeral=").append(numeral);
        sb.append(", \nPadre=").append(padre);
        sb.append(", \nMadre=").append(madre);
        sb.append(", \nMote=").append(mote);
        sb.append(", \nTitulo=").append(titulo);
        sb.append(", \nEsposa=").append(esposa);
        sb.append(", \nColor de Ojos=").append(colorOjos);
        sb.append(", \nColor de Cabello=").append(colorCabello);
        sb.append(", \nComentarios de su Vida=").append(comentVida);
        sb.append(", \nComentarios de su Muerte=").append(comentMuerte);
        return sb.toString();
    }

}
