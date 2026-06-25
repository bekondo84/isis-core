package com.teratech.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PluginData implements Serializable {
    private String id ;
    private String version;
    private String name;
    private int sequence;
    private boolean autoInstall = false;
    private String summary;
    private String description;
    private String category;
    private String email ;
    private String website;
    private String phone;
    private boolean install = false;
    private Date instaldate;
    private List<String> dependencies = new ArrayList<>();
    private List<MediaData> medias = new ArrayList<>();
}
