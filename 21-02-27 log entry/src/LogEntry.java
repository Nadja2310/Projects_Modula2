public class LogEntry {
    private String login;
    private String url;
    private long timestamp;

    public LogEntry(String login, String url) {
        this.login = login;
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public String getUrl() {
        return url;
    }

}
