/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelclient;

import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import spark.ModelAndView;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spark.Filter;
import spark.Spark;

public class Main {

    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}