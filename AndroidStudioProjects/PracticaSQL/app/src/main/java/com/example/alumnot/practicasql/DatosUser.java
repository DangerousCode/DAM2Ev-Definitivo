package com.example.alumnot.practicasql;

import java.io.Serializable;

/**
 * Created by AlumnoT on 18/02/2016.
 */
public class DatosUser implements Serializable {
    String user;
    String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;

    }

    public void setUser(String user) {
        this.user = user;
    }

    DatosUser(String user,String pass){
        this.user=user;
        this.pass=pass;
    }
}
