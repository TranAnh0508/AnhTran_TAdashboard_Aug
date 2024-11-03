package auto.model;

import auto.utils.Constants;
import auto.utils.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String username;
    private String password;

    public static User getValidAcc(String key) {
        return JsonUtils.to(Constants.VALID_ACCOUNTS_PATH, key, User.class);
    }

    public static User getInvalidAcc(String key) {
        return JsonUtils.to(Constants.INVALID_ACCOUNTS_PATH, key, User.class);
    }

    public static User getAdminAcc() {
        return getValidAcc("validAccount1");
    }
}
