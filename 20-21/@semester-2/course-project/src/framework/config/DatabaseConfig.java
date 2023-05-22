package framework.config;

import java.util.HashMap;

public class DatabaseConfig {

    private static final String env        = "development";

    private static HashMap envConfig = new HashMap(){{

        put("development", new HashMap<String, String>(){{
            put("url", "jdbc:mysql://localhost:3306/java_web_shop");
            put("user", "root");
            put("pass", "");
        }});

        put("stage", new HashMap<String, String>(){{
            put("url", "jdbc:mysql://154.0.1.1:3306/java_web_shop");
            put("user", "stage_admin");
            put("pass", "asdjhashkdgashgdasd");
        }});

        put("production", new HashMap<String, String>(){{
            put("url", "jdbc:mysql://192.168.27.1:3306/java_web_shop");
            put("user", "production_admin");
            put("pass", "sdfngdfhkjvgdfjvhhd");
        }});
    }};

    private static String getKey(String configKey) {

        HashMap<String, String> envHashmap = (HashMap<String, String>) envConfig.get(env);
        return envHashmap.get(configKey);
    }

    public static String getUrl() {
        return getKey("url");
    }

    public static String getUser() {
        return getKey("user");
    }

    public static String getPass() {
        return getKey("pass");
    }
}
