package edu.escuelaing.arep;

import static spark.Spark.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Session;


/**
 * Hello world!
 *
 */
public class App 
{

    private static Usuarios user;
    private static userdb usuarios = new userdb();


    public static void main(String[] args) {
        //System.out.println(convertir("12345Ab3"));

        secure(getKeystore(), "123456",null, null);
        SecureURLReader.reader();
        port(getPort());
        staticFileLocation("/static");

        before("/DLogin/*",App::validarIngresoInvalido);




        get("/", (req, res) -> {
            res.redirect("index.html");
            return null;
        });

        get("/hello", (req, res) -> "Hello world");

        post("/login", (req, res) ->{
            req.session(true);
            Gson gson=new Gson();
            user = gson.fromJson(req.body(), Usuarios.class);
            if(convertir(user.getPassword()).equals(usuarios.LoadPassByUser(user.getUser()))){
                req.session().attribute("User",user.getUser());
                req.session().attribute("loged",true);
            }
            else{
                return "no entra";
            }
            return "";
        });
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


    public static String convertir(String Clave) {
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

    private static void validarIngresoInvalido(Request request, Response response) {
        request.session(true);
        Session session = request.session();
        boolean newSession = session.isNew();
        if(newSession){
            request.session().attribute("loged",false);
        }
        else{
            boolean auth=request.session().attribute("loged");
            if(!auth) {
                halt(401, "<h1> no ha hecho login</h1>");
            }};
    }

}
