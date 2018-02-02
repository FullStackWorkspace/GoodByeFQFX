package cn.fqfx.GoodByeFQFX.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户状态枚举
 */
public enum UserStatus {
    NORMAL(1, "学生"), BANNED(2, "教师");

    private Integer key;
    private String content;
    private static Map<String, Integer> map = new HashMap<>();

    static {
        for (UserStatus o : UserStatus.values()) {
            map.put(o.content, o.key);
        }
    }

    UserStatus(Integer key, String content) {
        this.key = key;
        this.content = content;
    }

    public static Integer keyOfContent(String str) {
        return map.get(str);
    }

    public Integer getKey() {
        return key;
    }

    public String getContent() {
        return content;
    }
}
