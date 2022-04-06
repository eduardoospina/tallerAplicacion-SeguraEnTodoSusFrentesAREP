package edu.escuelaing.arep;
import static spark.Spark.*;
import com.google.gson.Gson;
import org.json.simple.JSONObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        port(getPort());

        secure(getKeyStore(), "123456",getKeyTrustStore(),"123456");

        get("/hello", (req, res) -> "Hello Heroku");

        get("/sqrt", ((req, res) -> {
            res.type("application/json");
            Double input = Double.parseDouble(req.queryParams("value"));
            return Mathimplementation.Sqrt(input);
        }));

        get("/atan", ((req, res) -> {
            res.type("application/json");
            Double input = Double.parseDouble(req.queryParams("value"));
            return Mathimplementation.Atan(input);
        }));

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 34002; //returns default port if heroku-port isn't set(i.e. on localhost)
    }

    private static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null){
            return System.getenv("KEYSTORE");
        }
        return "keystores/ecikeystore2.p12";
    }

    private static String getKeyTrustStore() {
        if (System.getenv("KEYSTORE") != null){
            return System.getenv("KEYSTORE");
        }
        return "keystores/myTrustStore";
    }
}
