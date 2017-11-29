package com.ybi.dm.cartable.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Bouddha on 26/11/2017.
 */
@Entity
public class Table {

    @Id @GeneratedValue
    private long id;
    private String name;
    private String schema;
    private String source;
    private String location;
    private String description;
    private long creation;
    private long updated;
    private String version;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreation() {
        return creation;
    }

    public void setCreation(long creation) {
        this.creation = creation;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    private String status;

    private ArrayList<Metrics> metrics;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Metrics> getMetrics() {
        return metrics;
    }

    public void setMetrics(ArrayList<Metrics> metrics) {
        this.metrics = metrics;
    }

    public ArrayList<Column> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Column> rows) {
        this.rows = rows;
    }

    private ArrayList<Column> rows;
}
