package auto.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.Random;

public class NameUtils {
    public static String trimName(String pageName) {
        return pageName.replace(" ", " ");
    }

    public static String replaceNameSpace(String pageName) {
        return pageName.replaceAll("-", " ");
    }

    public static String getRandomNameInList(List<String> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public static String getRandomString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    /**
     * get random Page Name
     */
    public static String getRandomPageName() {
        return "Page" + NameUtils.getRandomString(3);
    }

    /**
     * get random PanelSuper Name
     * @return
     */
    public static String getRandomPanelName() { return "PanelSuper " + NameUtils.getRandomString(3); }

    /**
     * Get Random Name
     */
    public static String getRandomName(String objectName, int number) {
        return objectName + getRandomString(number);
    }
}
