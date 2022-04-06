package edu.escuelaing.arep;

import static spark.Spark.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Session;


/**
 *
 * @author Eduardo ospina
 */
public class App 
{

    private static Usuarios user;
    private static userdb usuarios = new userdb();


    /**
     * main del sevicio que lo crea a partir de los puertos, la tienda de certificados y llaves, generandolo d emanera segura y permite conectarlo, corre los path necesarios para que funcione completamente el proyecto.
     * @param args
     */
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
        get("/Atan", (req, res) -> {
            res.type("application/json");
            Double input = Double.parseDouble(req.queryParams("value"));
            return SecureURLReader.getAtan(input);
        });

        get("/Sqrt", (req, res) -> {
            res.type("application/json");
            Double input = Double.parseDouble(req.queryParams("value"));
            return SecureURLReader.getSqrt(input);
        });

    }

    /**
     * trae el puerto para la creacion dle servicio
     * @return int puerto
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 34000; //returns default port if heroku-port isn't set(i.e. on localhost)
    }

    /**
     *retornsa los keystore en un path determinado
     * @return String con el path en donde se encuentra la keystore.
     */
    static String getKeystore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("Keystore");
        }
        return "keystores/ecikeystore.p12"; //returns default port if heroku-port isn't set(i.e. on localhost)
    }

    /**
     *genera los hash a partir de la clave que entre, permite no guardar las llaves sino los hash de las llaves.
     * @param Clave
     * @return String con el phash generado
     */
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

    /**
     *valida que la conecion este autorizada al momento de entrar, en donde etra el request y response yvalida que si este autorizado antes de continuar.
     * @param request
     * @param response
     */
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
