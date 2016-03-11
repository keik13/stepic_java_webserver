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
public class SignUpServlet extends HttpServlet {
  private final AccountService accountService;

  public SignUpServlet(AccountService accountService) {
    this.accountService = accountService;
  }

  public void doPost(HttpServletRequest request,
                     HttpServletResponse response) throws ServletException, IOException
  {
    accountService.addNewUser(new UserProfile(request.getParameter("login"), request.getParameter("password")));
  }
}
