package entidades;

import entidades.Eventos;
import entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-22T17:41:07")
@StaticMetamodel(Reservas.class)
public class Reservas_ { 

    public static volatile SingularAttribute<Reservas, Eventos> eventoId;
    public static volatile SingularAttribute<Reservas, Integer> idReservas;
    public static volatile SingularAttribute<Reservas, Integer> asientoColumna;
    public static volatile SingularAttribute<Reservas, Integer> asientoFila;
    public static volatile SingularAttribute<Reservas, Integer> cantidad;
    public static volatile SingularAttribute<Reservas, Usuarios> usuarioId;

}