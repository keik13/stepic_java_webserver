package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;
import servlets.MirrorRequestsServlet;

/**
 * Приложение генерит ответ на первое задание и содержит обновленный до послдених версий jetty и freemaker
 * часть кода взята из примеров к первой части курса на stepic.org "Создание веб-сервиса"
 *
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
