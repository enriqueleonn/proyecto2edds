/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edds;

/**
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeral() {
        return numeral;
    }

    public void setNumeral(String numeral) {
        this.numeral = numeral;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getMadre() {
        return madre;
    }

    public void setMadre(String madre) {
        this.madre = madre;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public String getTitulo() {
        return titulo;
    }

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

    public void setComentMuerte(String comentMuerte) {
        this.comentMuerte = comentMuerte;
    }
    
    public String nombreUnico(){
        if(this.mote == null){
            return this.getNombre() + "" + this.getNumeral();
        }
        
        return this.mote;
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
        sb.append(", \nColorOjos=").append(colorOjos);
        sb.append(", \nColorCabello=").append(colorCabello);
        sb.append(", \nComentVida=").append(comentVida);
        sb.append(", \nComentMuerte=").append(comentMuerte);
       
        return sb.toString();
    }
    
    
}
