package auto.utils;

import com.codeborne.selenide.ElementsCollection;
import java.util.Random;

public class ListUtils {
    public static Integer getRandomIndexInList(ElementsCollection list) {
        Random rand = new Random();
        return rand.nextInt(list.size());
    }
}
