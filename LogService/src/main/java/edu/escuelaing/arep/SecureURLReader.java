package edu.escuelaing.arep;

import org.json.JSONML;

import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/**
 *
 * @author Eduardo ospina
 */
public class SecureURLReader {


    /**
     * lector seguro que se conecta a las llaves y a la ienda de certificados ara generar la conecion segura.
     */
    public static void reader() {
        try {

            // Create a file and a password representation
            File trustStoreFile = new File("keystores/myTrustStore");
            char[] trustStorePassword = "123456".toCharArray();

            // Load the trust store, the default type is "pkcs12", the alternative is "jks"
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(new FileInputStream(trustStoreFile), trustStorePassword);

            // Get the singleton instance of the TrustManagerFactory
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

            // Itit the TrustManagerFactory using the truststore object
            tmf.init(trustStore);

            //Print the trustManagers returned by the TMF
            //only for debugging

            //Set the default global SSLContext so all the connections will use it
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);
            SSLContext.setDefault(sslContext);

        } catch (KeyStoreException ex) {
            Logger.getLogger(SecureURLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SecureURLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SecureURLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecureURLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(SecureURLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(SecureURLReader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * lee un url dado y se conecta de manera segura  apartir de la tienda de certificados y llaves que lee en elmetodo anterior.
     * @param sitetoread
     */
    public static void readURL(String sitetoread) {
        try {
            // Crea el objeto que representa una URL2
            URL siteURL = new URL(sitetoread);
            // Crea el objeto que URLConnection
            URLConnection urlConnection = siteURL.openConnection();
            // Obtiene los campos del encabezado y los almacena en un estructura Map
            Map<String, List<String>> headers = urlConnection.getHeaderFields();
            // Obtiene una vista del mapa como conjunto de pares <K,V>
            // para poder navegarlo
            Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
            // Recorre la lista de campos e imprime los valores
            for (Map.Entry<String, List<String>> entry : entrySet) {
                String headerName = entry.getKey();

                //Si el nombre es nulo, significa que es la linea de estado
                if (headerName != null) {
                    System.out.print(headerName + ":");
                }
                List<String> headerValues = entry.getValue();
                for (String value : headerValues) {
                    System.out.print(value);
                }
                System.out.println("");
            }

            System.out.println("-------message-body------");
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    /**
     * se conecta al servicio de math y hace la peticion y trae el resultado de la funcion sqrt
     * @param datos
     * @return  string repsuesta
     */
    public static String getSqrt(Double datos) throws IOException {
        String site = "https://ec2-34-207-220-18.compute-1.amazonaws.com:34002/sqrt?value="+ datos;
        URL url = new URL(site);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response);
            return response.toString();
        }
    }


    /**
     * se conecta al servicio de math y hace la peticion y trae el resultado de la funcion atan
     * @param datos
     * @return  string repsuesta
     */
    public static String getAtan(Double datos) throws IOException {
        String site = "https://ec2-34-207-220-18.compute-1.amazonaws.com:34002/atan?value="+ datos;
        URL url = new URL(site);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response);
            return response.toString();
        }
    }
}
