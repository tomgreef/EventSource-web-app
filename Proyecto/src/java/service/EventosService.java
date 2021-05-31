/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
 
import dao.EventosFacade;
import dto.EventosDTO;
import entidades.Eventos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.Query;
 
/**
 *
 * @author tomvg
 */
public class EventosService {
 
 
    @EJB private EventosFacade eventosFacade;
 
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
 
}
 
