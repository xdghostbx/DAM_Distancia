package com.example.hibernate.model.util.exceptions;




/**
 *
 * @author maria
 */
public class InstanceNotFoundException extends Exception {

  
    private Object key;
    private String className;
    
    private static final String DEFAULT_MSG = "Instance not found";

    public InstanceNotFoundException( Object key,
            String className) {

        super(DEFAULT_MSG + " (key = '" + key + "' - className = '"
                + className + "')");
        this.key = key;
        this.className = className;

    }

    public Object getKey() {
        return key;
    }

    public String getClassName() {
        return className;
    }
}
