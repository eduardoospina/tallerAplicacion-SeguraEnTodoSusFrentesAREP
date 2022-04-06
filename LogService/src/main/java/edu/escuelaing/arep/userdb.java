package edu.escuelaing.arep;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Eduardo ospina
 */
public class userdb {

    private Map<String,String> usuarios;
    /**
     * constructor de los usuarios quemados para la funcionalidad.
     */
    public userdb(){
        usuarios = new HashMap<>();
        usuarios.put("prueba1","5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5");//12345
        usuarios.put("prueba2","a546857c80739db8714c254bc921d2f061d3884d638cd24ecc0d4629f0ab920f");//12345Ab3
    }

    /**
     * cragar los usarios y los reotrna.
     * @param user
     * @return  string usuario
     */
    public String LoadPassByUser(String user) {
        return usuarios.get(user);
    }


}
