package entidades;

import entidades.Mensajes;
import entidades.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-18T18:14:08")
@StaticMetamodel(Chats.class)
public class Chats_ { 

    public static volatile SingularAttribute<Chats, Usuarios> usuariosId1;
    public static volatile CollectionAttribute<Chats, Mensajes> mensajesCollection;
    public static volatile SingularAttribute<Chats, Usuarios> usuariosId;
    public static volatile SingularAttribute<Chats, Integer> id;
    public static volatile SingularAttribute<Chats, Date> fechaYHora;

}