package com.djsm.inscripcion.util;

/**
 * Created by dsosa on 4/5/2019.
 */

public class CustomerErrorType {
    public String errorMessage;

    public CustomerErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
