package com.cdk.assignment4.Exception;

/**
 * Created by kaurk on 6/24/18.
 */
public class StudentNotFoundException extends RuntimeException {

    private int sId;

    public StudentNotFoundException( int id , String message) {
        super(message);
        sId = id;
    }
}
