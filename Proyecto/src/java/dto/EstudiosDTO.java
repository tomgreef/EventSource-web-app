/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author Alberto
 */
public class EstudiosDTO {
    
    private Integer estudioId;
    private UsuariosDTO analista;
    private String nombre;
    private Date fechaInicial;
    private Date fechaFinal;
    private Integer edadInferior;
    private Integer edadSuperior;
    private int sexo;
    private int cantidad;
    
    public EstudiosDTO(){}
    
    public Integer getEstudioId(){
        return estudioId;
    }
    
    public void setEstudioId(Integer estudioId){
        this.estudioId = estudioId;
    }
    
    public Integer getAnalistaId(){
        return analista.getUsuarioId();
    }
    
    public void setAnalistaId(Integer analistaId){
        this.analista.setUsuarioId(analistaId);
    }
    
    public String getAnalistaNombre(){
        return analista.getNombre();
    }
    
    public void setAnalistaNombre(String nombre){
        this.analista.setNombre(nombre);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Integer getEdadInferior() {
        return edadInferior;
    }

    public void setEdadInferior(Integer edadInferior) {
        this.edadInferior = edadInferior;
    }

    public Integer getEdadSuperior() {
        return edadSuperior;
    }

    public void setEdadSuperior(Integer edadSuperior) {
        this.edadSuperior = edadSuperior;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
