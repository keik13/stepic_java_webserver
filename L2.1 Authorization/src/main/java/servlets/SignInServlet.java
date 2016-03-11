package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Коба Андрей Александрович.
 */
public class SignInServlet extends HttpServlet {
  private final AccountService accountService;

  public SignInServlet(AccountService accountService) {
    this.accountService = accountService;
  }

  public void doPost(HttpServletRequest request,
                     HttpServletResponse response) throws ServletException, IOException
  {
    UserProfile user = accountService.getUserByLogin(request.getParameter("login"));
    if(user != null && user.getPass().equals(request.getParameter("password"))) {
      response.getWriter().println("Authorized: " + user.getLogin());
      response.setContentType("text/html;charset=utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
    } else {
      response.getWriter().println("Unauthorized");
      response.setContentType("text/html;charset=utf-8");
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
  }
}
