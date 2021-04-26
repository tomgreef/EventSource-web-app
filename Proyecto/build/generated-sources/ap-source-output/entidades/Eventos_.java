package entidades;

import entidades.Etiquetas;
import entidades.Reservas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T09:32:32")
@StaticMetamodel(Eventos.class)
public class Eventos_ { 

    public static volatile SingularAttribute<Eventos, String> descripcion;
    public static volatile SingularAttribute<Eventos, Date> fechaLimiteReserva;
    public static volatile SingularAttribute<Eventos, Integer> aforo;
    public static volatile CollectionAttribute<Eventos, Etiquetas> etiquetasCollection;
    public static volatile SingularAttribute<Eventos, Date> fecha;
    public static volatile SingularAttribute<Eventos, Integer> entradasMaximasPorUsuario;
    public static volatile SingularAttribute<Eventos, Integer> filas;
    public static volatile CollectionAttribute<Eventos, Reservas> reservasCollection;
    public static volatile SingularAttribute<Eventos, String> titulo;
    public static volatile SingularAttribute<Eventos, Integer> id;
    public static volatile SingularAttribute<Eventos, Double> coste;
    public static volatile SingularAttribute<Eventos, Integer> columnas;

}