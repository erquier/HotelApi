
package com.mycompany.hotelapi;

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
    
    private static final String SESSION_NAME = "username";
    private static SessionFactory factory;
    
    public static void main(String[] args){
    
        
        
        Spark.exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });
        
                after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });


        try {
            factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        //Login
        post("/login", (request, response) -> {
            String user = request.queryParams("user");
            String pass = request.queryParams("pass");
            if (user.toLowerCase().equals("admin") && pass.equals("123456")) {
                request.session().attribute(SESSION_NAME, user);
                response.redirect("/");
            } else {
                response.redirect("/?err=1");
            }
            return null;
        });
        
        
        //agregar cliente
        post("/crear", (req, res) -> {
        
        String nombre = req.queryParams("nombre");
        String email = req.queryParams("email");
        String password = req.queryParams("password");
        String telefono = req.queryParams("telefono");
        String direccion = req.queryParams("direccion");
        
        int estado = Integer.parseInt(req.queryParams("estado"));
        
            String insertID = "";
            Session session = factory.openSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                Cliente cliente = new Cliente(nombre,email, password, telefono, direccion, estado);
                insertID = session.save(cliente).toString();
                tx.commit();

            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
            return new Gson().toJson("Agregado");
        });
        
    
    }
    
}
