/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.websocket_chat;
import static j2html.TagCreator.article;
import static j2html.TagCreator.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import static spark.Spark.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;
//import org.eclipse.jetty.server.session.JDBCSessionManager.Session;

/**
 *
 * @author marianny
 */
public class Chat {
    // this map is shared between sessions and threads, so it needs to be thread-safe (http://stackoverflow.com/a/2688817)
    static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();
    static int nextUserNumber = 1; //Used for creating the next username

    public static void main(String[] args) {
        
        staticFileLocation("/public"); //index.html is served at localhost:4567 (default port)
        webSocket("/chat", ChatWebSocketHandler.class);
        init();
             before((request, response) -> {
        response.header("Access-Control-Allow-Origin", "*");
        response.header("Access-Control-Request-Method", "*");
        response.header("Access-Control-Allow-Headers", "*");
      
    });      
    }
        
    //Sends a message from one user to all users, along with a list of current usernames
public static void broadcastMessage(String sender, String message) {
    userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
        try {
            session.getRemote().sendString(String.valueOf(new JSONObject()
                .put("userMessage", createHtmlMessageFromSender(sender, message))
                .put("userlist", userUsernameMap.values())
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
}
//Builds a HTML element with a sender-name, a message, and a timestamp,
private static String createHtmlMessageFromSender(String sender, String message) {
    return article().with(
            b(sender + " says:"),
            p(message),
            span().withClass("timestamp").withText(new SimpleDateFormat("HH:mm:ss").format(new Date()))
    ).render();
}
    
}
