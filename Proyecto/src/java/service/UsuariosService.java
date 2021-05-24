/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UsuariosFacade;
import dto.UsuariosDTO;
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
public class UsuariosService {

    @EJB
    private UsuariosFacade usuariosFacade;

    protected List<UsuariosDTO> convertirAListaDTO(List<Usuarios> lista) {

        if (lista != null) {
            List<UsuariosDTO> listaDTO = new ArrayList<>();
            lista.forEach((cliente) -> {
                listaDTO.add(cliente.getDTO());
            });
            return listaDTO;
        } else {
            return null;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<UsuariosDTO> listarClientes(String nombre, String apellidos) {
        List<Usuarios> usuarios;

        if ((nombre != null && nombre.length() > 0)
                || (apellidos != null && apellidos.length() > 0)) {// Estoy aplicando filtros
            usuarios = this.usuariosFacade.filter(nombre, apellidos);
        } else {  // Quiero mostrar todos
            usuarios = this.usuariosFacade.findAll();
        }

        return this.convertirAListaDTO(usuarios);
    }
}
