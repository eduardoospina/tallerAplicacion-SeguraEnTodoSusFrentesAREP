package edu.escuelaing.arep;

/**
 *
 * @author Eduardo ospina
 */
public class Usuarios {

    private String user;
    private String password;

    /**
     * constructor de usuarios.
     * @param user string
     * @param password password
     */
    public Usuarios(String user, String password) {
        this.user = user;
        this.password = password;
    }

    /**
     * get del usuario
     * @return  string usuario
     */
    public String getUser() {
        return user;
    }

    /**
     * set del usuario
     * @param user
     */
    public void setEmail(String user) {
        this.user = user;
    }

    /**
     * get del password
     * @return  string passwrd
     */
    public String getPassword() {
        return password;
    }

    /**
     * set del password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
