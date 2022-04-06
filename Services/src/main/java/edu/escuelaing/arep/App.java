package edu.escuelaing.arep;
import static spark.Spark.*;
import com.google.gson.Gson;
import org.json.simple.JSONObject;

/**
 *
 * @author Eduardo ospina
 */
public class App 
{


    /**
     * metodo main que se encarga de crear los sockets del servidor trayendo el puerto y los certificados y las llaves ara poder hacer el redirecionamiento de las peticiones de manera segura.
     * @param args Array de string
     */
    public static void main(String[] args) {

        port(getPort());

        secure(getKeyStore(), "123456",getKeyTrustStore(),"123456");

        get("/hello", (req, res) -> "Hello Heroku");

        get("/sqrt", ((req, res) -> {
            System.out.println("entro peticion a sqrt");
            res.type("application/json");
            Double input = Double.parseDouble(req.queryParams("value"));
            return Mathimplementation.Sqrt(input);
        }));

        get("/atan", ((req, res) -> {
            System.out.println("entro peticion a atan");
            res.type("application/json");
            Double input = Double.parseDouble(req.queryParams("value"));
            return Mathimplementation.Atan(input);
        }));

    }


    /**
     * trae el puerto para la creacion dle servicio
     * @return int puerto
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 34002; //returns default port if heroku-port isn't set(i.e. on localhost)
    }

    /**
     *retorna las llave d eun path determinado.
     * @return String con el path en donde se encuentra la keystore.
     */
    private static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null){
            return System.getenv("KEYSTORE");
        }
        return "keystores/ecikeystore2.p12";
    }

    /**
     * retorne la tienda de certcados d eun path determinado.
     * @return  String la tienda del keystore.
     */
    private static String getKeyTrustStore() {
        if (System.getenv("KEYSTORE") != null){
            return System.getenv("KEYSTORE");
        }
        return "keystores/myTrustStore";
    }
}
