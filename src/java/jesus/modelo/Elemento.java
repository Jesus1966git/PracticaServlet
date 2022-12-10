/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jesus.modelo;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("elemento")
@RequestScoped
public class Elemento implements Serializable {

    //PROPIEDADES
    private String uso;
    private String numero;
    private String cuota;
    private String finca;
    private String porcentaje;
    private String texto;
//    private String fondo;

    // CONSTRUCTORES
    public Elemento() {
    }

    //ACCESORES    
    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCuota() {
        return cuota;
    }

    public void setCuota(String cuota) {
        this.cuota = cuota;
    }

    public String getFinca() {
        return finca;
    }

    public void setFinca(String finca) {
        this.finca = finca;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

//    public String getFondo() {
//        return fondo;
//    }
//
//    public void setFondo(String fondo) {
//        this.fondo = fondo;
//    }

}
