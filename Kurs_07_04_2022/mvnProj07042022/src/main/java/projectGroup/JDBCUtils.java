package projectGroup;

import java.util.ResourceBundle;

public class JDBCUtils {

    public static final String DATABASE_RESOURCE = "my_database";
    public static final String URL_KEY = "url";
    public static final String USER_KEY = "username";
    public static final String PASSWORD_KEY = "password";

    private static final ResourceBundle RESOURCE = ResourceBundle.getBundle(DATABASE_RESOURCE);

    public static String url = RESOURCE.getString(URL_KEY);
    public static String user = RESOURCE.getString(USER_KEY);
    public static String password = RESOURCE.getString(PASSWORD_KEY);

    public static String getValue(String key) {
        return RESOURCE.getString(key);
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static void updateParams() {
        url = RESOURCE.getString(URL_KEY);
        user = RESOURCE.getString(USER_KEY);
        password = RESOURCE.getString(PASSWORD_KEY);
    }
}
