package moonrock.clisocialnetwork.utils;

public class RequestBody {

    private final String password;
    private final String login;
    private final String option;

    public RequestBody(String password, String login, String option) {
        this.password = password;
        this.login = login;
        this.option = option;
    }

    public String getPassword(){
        return this.password;
    }

    public String getLogin() {
        return this.login;
    }

    public String getOption() {
        return this.option;
    }
}

