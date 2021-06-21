/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.EventosFacade;
import dao.ReservasFacade;
import dao.UsuariosFacade;
import dto.UsuariosDTO;
import entidades.Eventos;
import entidades.Reservas;
import entidades.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author tomvg
 */

@Stateless
public class ReservasService {

    @EJB
    private ReservasFacade reservasFacade;
    
    @EJB
    private EventosFacade eventosFacade;
    
    
    @EJB
    private UsuariosFacade usuariosFacade;


  
    public void create(Integer fila,Integer columna, Integer eventoID, Integer usuarioID) {
        Reservas reserva = new Reservas();

        reserva.setAsientoFila(fila);
        reserva.setAsientoColumna(columna);
        reserva.setEventoId(eventosFacade.find(eventoID));
        reserva.setUsuarioId(usuariosFacade.find(usuarioID));
        this.reservasFacade.create(reserva);
    }
}
