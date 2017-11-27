package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Bouddha on 26/11/2017.
 */
public class Column {
    private String name;
    private String description;
    private String status;
    private ColumnType type;
    private int position;
    private boolean isNullable;
    private boolean isPrimary;
    private boolean isForeign;
    private int charLength;
    private int numericPrecision;
    private int numericScale;

}
