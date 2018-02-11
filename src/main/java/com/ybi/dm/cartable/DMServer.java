package com.ybi.dm.cartable; /**
 * Created by Bouddha on 23/09/2017.
 */

import com.ybi.dm.cartable.models.Column;
import com.ybi.dm.cartable.models.Table;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static spark.Spark.*;

public class DMServer {


    public static void main(String[] args) {
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
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("e:/coding/java/Workspace/cartable/test.odb");
            EntityManager em = emf.createEntityManager();
            //em.getTransaction().begin();
            //em.getTransaction().commit();
            long count = em.createQuery("SELECT count(t) FROM Table t", Long.class).getSingleResult();
            System.out.println("Table Count " + count);
            Table table = em.createQuery("SELECT t FROM Table t", Table.class).setFirstResult(0).setMaxResults(1).getSingleResult();
            String result =getTableSVG(table);
            emf.close();
            return result;

        });
        enableCORS("*", "*", "*");
    }


    private static String getTableSVG(Table table) {
        StringBuilder sb = new StringBuilder();
        int totalHeight = 40 + 15 * table.getColumns().size();
        int currentHeight = 40;
        sb.append("<svg width=\"200\" height=\""+totalHeight+"\" xmlns=\"http://www.w3.org/2000/svg\" shape-rendering=\"crispEdges\" >\n");
        sb.append("  <g>\n" );
        sb.append("    <rect shape-rendering=\"optimizeQuality\" x=\"0\" y=\"0\" width=\"200\" height=\""+totalHeight+"\" fill=\"#EEE\"></rect>\n" );
        sb.append("    <text shape-rendering=\"optimizeQuality\" x=\"10\" y=\"25\" font-family=\"Verdana\" font-size=\"15\" fill=\"#099\">");
        sb.append("      " + table.getName());
        sb.append("    </text>\n" );
        for (Column column : table.getColumns()) {
            sb.append("    <text shape-rendering=\"optimizeQuality\" x=\"10\" y=\""+currentHeight+"\" font-family=\"Verdana\" font-size=\"10\" fill=\"black\">");
            sb.append(column.getType().toString());
            sb.append(" : ");
            sb.append(column.getName());
            if (column.isPrimary()) {
                sb.append(" [PK]");
            }
            if (column.isForeign()) {
                sb.append(" [FK]");
            }
            sb.append("</text>\n");
            currentHeight += 15;
        }
        sb.append("  </g>\n" );
        sb.append("</svg>");
        return sb.toString();
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
