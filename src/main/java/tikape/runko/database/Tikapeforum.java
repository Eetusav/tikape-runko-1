/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tikape.forum;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Scanner;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

/**
 *
 * @author Matti
 */
public class Tikapeforum {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        // Wait for a request from a machine, once it apprears, accept it
        Socket socket = server.accept();

        // Read the request
        Scanner requestReader = new Scanner(socket.getInputStream());

        // Write the response
        PrintWriter responseWriter = new PrintWriter(socket.getOutputStream());

        // Close the streams and the socket
        requestReader.close();
        responseWriter.close();
        socket.close();

        // Close the server
        server.close();
    }
}

