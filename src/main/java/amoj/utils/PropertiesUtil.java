package amoj.utils;

import java.util.ResourceBundle;

public class PropertiesUtil {
    private static final ResourceBundle resource = ResourceBundle.getBundle("amoj_config");
    public static final int PAGE_SIZE = 7;
    public static final String[]
            RESULT = {
            "Accepted",
            "Presentation Error",
            "Time Limit Exceeded",
            "Memory Limit Exceeded",
            "Wrong Answer",
            "Runtime Error",
            "Output Limit Exceeded",
            "Compile Error",
            "System Error"};

    public static final String[]
            LANGUAGE = {
            "",
            "c",
            "cpp",
            "java",};

    public PropertiesUtil() {
    }

    public static final String StringValue(String key) {
        return resource.getString(key);
    }

    public static final int IntegerValue(String key) {
        return Integer.parseInt(resource.getString(key));
    }

    public static final long LongValue(String key) {
        return Long.parseLong(resource.getString(key));
    }

    public static final boolean BoolValue(String key) {
        return Boolean.parseBoolean(resource.getString(key));
    }

}
