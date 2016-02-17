package com.keik.jwebservice;

import com.keik.jwebservice.servlets.AllRequestsServlet;
import com.keik.jwebservice.servlets.MirrorRequestsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Приложение генерит ответ на первое задание и содержит обновленный для послдених версий jetty и
 * freemaker код из примеров к первой части курса "Создание веб-сервиса"
 * @author Коба Андрей Александрович.
 */
public class Main {

  public static void main(String[] args) throws Exception {
    AllRequestsServlet allRequestsServlet = new AllRequestsServlet();
    MirrorRequestsServlet mirrorRequestsServlet = new MirrorRequestsServlet();

    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.addServlet(new ServletHolder(allRequestsServlet), "/*");
    context.addServlet(new ServletHolder(mirrorRequestsServlet), "/mirror");

    Server server = new Server(8080);
    server.setHandler(context);

    server.start();
    System.out.println("Server started");
    server.join();

  }

}
