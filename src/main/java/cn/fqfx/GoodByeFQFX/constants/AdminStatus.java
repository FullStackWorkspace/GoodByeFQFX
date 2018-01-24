package cn.fqfx.GoodByeFQFX.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户状态枚举
 */
public enum AdminStatus {
    NORMAL(1, "正常"), BANNED(2, "禁用"), SUPER(3, "超级");

    private Integer key;
    private String content;
    private static Map<String, Integer> map = new HashMap<>();

    static {
        for (AdminStatus o : AdminStatus.values()) {
            map.put(o.content, o.key);
        }
    }

    AdminStatus(Integer key, String content) {
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
