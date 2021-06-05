package com.example.notifictionhomework;

public class Result {
    boolean status;
    int statusCode;
    String msg;
    Data data;

    public boolean isStatus() {
        return status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public Data getData() {
        return data;
    }

    public class Data {
        int id;
        String first_name;
        String second_name;
        String email;

        public int getId() {
            return id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public String getSecond_name() {
            return second_name;
        }

        public String getEmail() {
            return email;
        }
    }
}

