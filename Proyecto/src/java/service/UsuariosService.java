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

    public UsuariosDTO find(Integer id) {
        Usuarios usuario = this.usuariosFacade.find(id);
        return usuario.getDTO();
    }

    public void remove(Integer id) {
        Usuarios usuario = this.usuariosFacade.find(id);
        this.usuariosFacade.remove(usuario);
    }

    public UsuariosDTO findByEmailAndPassword(String email, String password) {
        Usuarios usuario = this.usuariosFacade.findByEmailAndPassword(email, password);
        return usuario.getDTO();
    }

    public void edit(Integer usuarioId, String email, String nombre, String apellidos, String domicilio, String ciudad, Integer edad, Integer sexo, Integer rol, String password) {
        Usuarios usuario;

        usuario = this.usuariosFacade.find(usuarioId);

        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setEmail(email);
        usuario.setDomicilio(domicilio);
        usuario.setCiudad(ciudad);
        usuario.setEdad(edad);
        usuario.setSexo(sexo);
        usuario.setPassword(password);
        usuario.setRol(rol);
        
        this.usuariosFacade.edit(usuario);

    }

    public void create(String email, String nombre, String apellidos, String domicilio, String ciudad, Integer edad, Integer sexo, String password) {
        Usuarios usuario = new Usuarios();

        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setEmail(email);
        usuario.setDomicilio(domicilio);
        usuario.setCiudad(ciudad);
        usuario.setEdad(edad);
        usuario.setSexo(sexo);
        usuario.setPassword(password);
        usuario.setRol(0);

        this.usuariosFacade.create(usuario);
    }

    public void createAsAdmin(String email, String nombre, String apellidos, String domicilio, String ciudad, Integer edad, Integer sexo, Integer rol, String password) {
        Usuarios usuario = new Usuarios();

        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setEmail(email);
        usuario.setDomicilio(domicilio);
        usuario.setCiudad(ciudad);
        usuario.setEdad(edad);
        usuario.setSexo(sexo);
        usuario.setPassword(password);
        usuario.setRol(rol);

        this.usuariosFacade.create(usuario);
    }
}
