package users;

public class BaseUser {
    private String apiKey;

    public BaseUser(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }
}
