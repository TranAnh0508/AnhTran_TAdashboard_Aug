package auto.utils;

import org.json.simple.JSONObject;

public class MessageUtils {
    public static String getAlertMessage(String key) {
        return JsonUtils.to(Constants.MESSAGES_PATH, JSONObject.class).get(key).toString();
    }
}
