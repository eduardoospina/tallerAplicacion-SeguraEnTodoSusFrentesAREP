package edu.escuelaing.arep;

import org.json.simple.JSONObject;
import java.lang.Math;

/**
 *
 * @author Eduardo ospina
 */
public class Mathimplementation {

    /**
     * convierta los datos dados en el json requerido por la app
     * @param operation string
     * @param input string
     * @param output string
     * @return JSONobject del jason generado
     */
    private static JSONObject makeJson1(String operation, Double input, Double output){
        JSONObject json = new JSONObject();
        json.put("operation", operation);
        json.put("input", input);
        json.put("output", Math.atan(output));
        return json;
    }

    /**
     * convierta los datos dados en el json requerido por la app
     * @param operation string
     * @param input string
     * @param output string
     * @return JSONobject del jason generado
     */
    private static JSONObject makeJson2(String operation, Double input, Double output){
        JSONObject json = new JSONObject();
        json.put("operation", operation);
        json.put("input", input);
        json.put("output", Math.sqrt(output));
        return json;
    }

    /**
     * calcula le valor de Atan
     * @param input string
     * @return JSONobject del jason generado
     */
    public static JSONObject Atan(Double input){
        return makeJson1("atan", input, input);
    }

    /**
     * calcula le valor de sqrt
     * @param input string
     * @return JSONobject del jason generado
     */
    public static JSONObject Sqrt(Double input){
        return makeJson2("sqrt", input, input);
    }

}
