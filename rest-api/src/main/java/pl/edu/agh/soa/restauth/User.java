package pl.edu.agh.soa.restauth;

public class User {
    private String login, password;

    public User (){}

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public void setLogin (String login) {
        this.login = login;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getLogin () {
        return login;
    }

    public String getPassword () {
        return password;
    }
}
