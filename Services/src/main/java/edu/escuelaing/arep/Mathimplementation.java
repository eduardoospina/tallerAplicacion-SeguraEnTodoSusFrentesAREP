package edu.escuelaing.arep;

import org.json.simple.JSONObject;
import java.lang.Math;

public class Mathimplementation {

    private static JSONObject makeJson1(String operation, Double input, Double output){
        JSONObject json = new JSONObject();
        json.put("operation", operation);
        json.put("input", input);
        json.put("output", Math.atan(output));
        return json;
    }

    private static JSONObject makeJson2(String operation, Double input, Double output){
        JSONObject json = new JSONObject();
        json.put("operation", operation);
        json.put("input", input);
        json.put("output", Math.sqrt(output));
        return json;
    }

    public static JSONObject Atan(Double input){
        return makeJson1("atan", input, input);
    }

    public static JSONObject Sqrt(Double input){
        return makeJson2("sqrt", input, input);
    }

}
