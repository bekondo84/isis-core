package com.teratech.metadata;

import java.io.Serializable;

public class CalendarData implements Serializable {
    protected String id_field;
    protected String title_field;
    protected String start_field;
    protected String end_field;
    protected String category_field;

    public CalendarData() {
    }

    public CalendarData(String id_field, String title_field, String start_field, String end_field) {
        this.id_field = id_field;
        this.title_field = title_field;
        this.start_field = start_field;
        this.end_field = end_field;
    }

    public String getId_field() {
        return id_field;
    }

    public CalendarData setId_field(String id_field) {
        this.id_field = id_field;
        return this;
    }

    public String getTitle_field() {
        return title_field;
    }

    public CalendarData setTitle_field(String title_field) {
        this.title_field = title_field;
        return this;
    }

    public String getStart_field() {
        return start_field;
    }

    public CalendarData setStart_field(String start_field) {
        this.start_field = start_field;
        return this;
    }

    public String getEnd_field() {
        return end_field;
    }

    public CalendarData setEnd_field(String end_field) {
        this.end_field = end_field;
        return this;
    }

    public String getCategory_field() {
        return category_field;
    }

    public CalendarData setCategory_field(String category_field) {
        this.category_field = category_field;
        return this;
    }
}
