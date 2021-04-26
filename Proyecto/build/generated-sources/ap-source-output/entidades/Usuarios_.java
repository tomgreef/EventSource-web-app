package entidades;

import entidades.Chats;
import entidades.Mensajes;
import entidades.Reservas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T01:18:07")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> nobmre;
    public static volatile SingularAttribute<Usuarios, String> apellidos;
    public static volatile CollectionAttribute<Usuarios, Chats> chatsCollection;
    public static volatile SingularAttribute<Usuarios, Integer> edad;
    public static volatile SingularAttribute<Usuarios, Integer> rol;
    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile SingularAttribute<Usuarios, String> domicilio;
    public static volatile CollectionAttribute<Usuarios, Chats> chatsCollection1;
    public static volatile SingularAttribute<Usuarios, String> ciudad;
    public static volatile CollectionAttribute<Usuarios, Mensajes> mensajesCollection;
    public static volatile CollectionAttribute<Usuarios, Reservas> reservasCollection;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile SingularAttribute<Usuarios, Integer> sexo;
    public static volatile SingularAttribute<Usuarios, String> email;

}