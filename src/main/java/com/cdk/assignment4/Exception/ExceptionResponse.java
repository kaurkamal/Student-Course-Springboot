package com.cdk.assignment4.Exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaurk on 6/27/18.
 */
public class ExceptionResponse {
    private String errorCode;
    private String errorMessage;


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
