/**
 * Created by Bouddha on 23/09/2017.
 */

import static spark.Spark.*;
public class DMServer {


    public static void main(String[] args){
        exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print all exceptions
        //staticFiles.location("/public");
        String projectDir = System.getProperty("user.dir");
        String staticDir = "/src/main/resources/public";
        staticFiles.externalLocation(projectDir + staticDir);
        //staticFiles.header("content-type", "image/svg+xml");
        port(8080);
        get("/hello", (req, res) -> "Hello World");
        get("/testx.svg", (req, res) -> {
            res.header("content-type", "image/svg+xml");
            return "<svg width=\"200\" height=\"180\" xmlns=\"http://www.w3.org/2000/svg\" shape-rendering=\"crispEdges\" >\n" +
                    "  <g>\n" +
                    "    <rect shape-rendering=\"optimizeQuality\" x=\"0\" y=\"0\" width=\"200\" height=\"180\" fill=\"#EEE\"></rect>\n" +
                    "    <text shape-rendering=\"optimizeQuality\" x=\"10\" y=\"25\" font-family=\"Verdana\" font-size=\"15\" fill=\"#099\">INT.PRD_SVC_INSEE</text>\n" +
                    "    <text shape-rendering=\"optimizeQuality\" x=\"10\" y=\"40\" font-family=\"Verdana\" font-size=\"10\" fill=\"black\">BIGINT : ID [PK]</text>\n" +
                    "    <text shape-rendering=\"optimizeQuality\" x=\"10\" y=\"55\" font-family=\"Verdana\" font-size=\"10\" fill=\"black\">VARCHAR : CODE</text>\n" +
                    "    <text shape-rendering=\"optimizeQuality\" x=\"10\" y=\"70\" font-family=\"Verdana\" font-size=\"10\" fill=\"black\">VARCHAR : NAME</text>\n" +
                    "    <text shape-rendering=\"optimizeQuality\" x=\"10\" y=\"85\" font-family=\"Verdana\" font-size=\"10\" fill=\"black\">VARCHAR : SURNAME</text>\n" +
                    "    <text shape-rendering=\"optimizeQuality\" x=\"10\" y=\"100\" font-family=\"Verdana\" font-size=\"10\" fill=\"black\">VARCHAR : ADRESS</text>\n" +
                    "    <text shape-rendering=\"optimizeQuality\" x=\"10\" y=\"115\" font-family=\"Verdana\" font-size=\"10\" fill=\"black\">INT : ZIP</text>\n" +
                    "    <text shape-rendering=\"optimizeQuality\" x=\"10\" y=\"130\" font-family=\"Verdana\" font-size=\"10\" fill=\"black\">VARCHAR : CITY</text>\n" +
                    "    <text shape-rendering=\"optimizeQuality\" x=\"10\" y=\"145\" font-family=\"Verdana\" font-size=\"10\" fill=\"black\">VARCHAR : COUNTRY</text>\n" +
                    "    <text shape-rendering=\"optimizeQuality\" x=\"10\" y=\"160\" font-family=\"Verdana\" font-size=\"10\" fill=\"black\">BIGINT : SCORE</text>\n" +
                    "  </g>\n" +
                    "</svg>";
        });
        enableCORS("*", "*", "*");
    }
    private static void enableCORS(final String origin, final String methods, final String headers) {

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Access-Control-Request-Method", methods);
            response.header("Access-Control-Allow-Headers", headers);
            // Note: this may or may not be necessary in your particular application
            response.type("application/json");
        });
    }
}
