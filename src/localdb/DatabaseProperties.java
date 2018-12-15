package localdb;

public class DatabaseProperties {

    public static final DatabaseProperties LOCAL_DB_PROPERTIES =
            new DatabaseProperties("localhost", 3306, "tools_database")
            .setUser("root")
            .setPassword("root");

    private final String host;

    private final int port;

    private final String database;

    private String user = "";

    private String password = "";

    public DatabaseProperties(String host, int port, String database) {
        this.host = host;
        this.port = port;
        this.database = database;
    }

    public DatabaseProperties setUser(String user) {
        this.user = user;
        return this;
    }

    public DatabaseProperties setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
