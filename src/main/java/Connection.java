import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Connection {
    @NotNull
    @Size(min = 2)
    String name;
    @NotNull
    String url;
    @NotNull
    String user;
    @NotNull
    String pass;

    public Connection() {
    }

    public Connection(String name, String url, String user, String pass) {
        this.name = name;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}