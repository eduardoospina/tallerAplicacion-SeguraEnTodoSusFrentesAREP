package edu.escuelaing.arep;

import static spark.Spark.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        secure(getKeystore(), "123456",null, null);

        port(getPort());

        staticFileLocation("/static");
        get("/", (req, res) -> {
            res.redirect("index.html");
            return null;
        });

        get("/hello", (req, res) -> "Hello world");
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 34000; //returns default port if heroku-port isn't set(i.e. on localhost)
    }

    static String getKeystore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("Keystore");
        }
        return "Keystores/ecikeystore.p12"; //returns default port if heroku-port isn't set(i.e. on localhost)
    }

    public String convertir(String Clave) {
        MessageDigest mensaje = null;
        try {
            mensaje = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] newHash = mensaje.digest(Clave.getBytes());
        StringBuffer finalizacion = new StringBuffer();
        for(byte i : newHash) {
            finalizacion.append(String.format("%02x", i));
        }
        return finalizacion.toString();
    }
}
