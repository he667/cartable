package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Bouddha on 26/11/2017.
 */
public class Table {

    private String name;
    private String schema;
    private String source;
    private String location;
    private String description;
    private LocalDateTime creation;
    private LocalDateTime updated;
    private String version;
    private String status;

    private ArrayList<Metrics> metrics;
    private ArrayList<Column> rows;
}
