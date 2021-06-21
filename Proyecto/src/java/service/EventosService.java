/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
 
import dao.EventosFacade;
import dao.ReservasFacade;
import dao.UsuariosFacade;
import dto.EventosDTO;
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
public class EventosService {
 
    @EJB 
    private UsuariosFacade usuariosFacade;
    
    @EJB 
    private EventosFacade eventosFacade;
    
    @EJB 
    private ReservasFacade reservasFacade;
 
    public EventosDTO find(int idEvento)
    {
        return eventosFacade.find(idEvento).getDTO();
    }
    
    public List<EventosDTO> filter(String titulo, double coste) {
        List<Eventos> listaEventos;
 
        if (titulo.length() > 0) 
        {
            if (coste != 0) 
            {
                listaEventos = this.eventosFacade.filter(titulo,coste);
            } 
            else 
            {
                listaEventos = this.eventosFacade.filtroNombreSimilar(titulo);
            }
        } 
        else 
        {
            if (coste != 0) 
            {
                listaEventos = this.eventosFacade.filtroCosteSimilar(String.valueOf(coste));
            } 
            else 
            {
                listaEventos = this.eventosFacade.filter("",0);
            }
        }
 
        return this.convertirAListaDTO(listaEventos);
    }
 
    private List<EventosDTO> convertirAListaDTO(List<Eventos> lista) {
         if (lista != null) {
            List<EventosDTO> listaDTO = new ArrayList<>();
            lista.forEach((evento) -> {
                listaDTO.add(evento.getDTO());
            });
            return listaDTO;
        } else {
            return null;
        }
    }
 
    public void guardarReserva (Integer idUsuario, Integer idEvento, String asiento){
        Usuarios usuario = this.usuariosFacade.find(idUsuario);
        Eventos evento = this.eventosFacade.find(idEvento);
        
        Reservas reserva = new Reservas();
        reserva.setAsientoFila(Integer.parseInt(String.valueOf(asiento.charAt(0))));
        reserva.setAsientoColumna(Integer.parseInt(String.valueOf(asiento.charAt(1))));
        reserva.setEventoId(evento);
        reserva.setUsuarioId(usuario);
        
        this.reservasFacade.create(reserva);
    }
}
 
