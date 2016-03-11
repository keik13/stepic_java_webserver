package accounts;

/**
 * @author Коба Андрей Александрович.
 */
public class UserProfile {
  private final String login;
  private final String pass;
  private final String email;

  public UserProfile(String login, String pass, String email) {
    this.login = login;
    this.pass = pass;
    this.email = email;
  }

  public UserProfile(String login, String pass) {
    this.login = login;
    this.pass = pass;
    this.email = login;
  }

  public UserProfile(String login) {
    this.login = login;
    this.pass = login;
    this.email = login;
  }

  public String getLogin() {
    return login;
  }

  public String getPass() {
    return pass;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object aO) {
    if (this == aO) return true;
    if (aO == null || getClass() != aO.getClass()) return false;

    UserProfile that = (UserProfile) aO;

    if (!login.equals(that.login)) return false;
    if (!pass.equals(that.pass)) return false;
    return email.equals(that.email);

  }

  @Override
  public int hashCode() {
    int result = login.hashCode();
    result = 31 * result + pass.hashCode();
    result = 31 * result + email.hashCode();
    return result;
  }
}
