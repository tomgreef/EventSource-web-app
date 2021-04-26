package entidades;

import entidades.Chats;
import entidades.MensajesPK;
import entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T08:59:48")
@StaticMetamodel(Mensajes.class)
public class Mensajes_ { 

    public static volatile SingularAttribute<Mensajes, MensajesPK> mensajesPK;
    public static volatile SingularAttribute<Mensajes, Chats> chats;
    public static volatile SingularAttribute<Mensajes, String> mensaje;
    public static volatile SingularAttribute<Mensajes, Usuarios> usuarios;

}