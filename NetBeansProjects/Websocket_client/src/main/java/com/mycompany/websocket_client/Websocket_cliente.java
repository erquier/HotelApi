/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.websocket_client;

import static spark.Spark.*;

public class Websocket_cliente {

    public static void  main(String[] args) {
        
        
    port(1234);
    staticFiles.location("/public");
    
        get("/hello", (req, res) -> "Hello World");
        
        get("/chat", (req, res)->{
        res.redirect("index.html");
        return null;
        });
    }
}
