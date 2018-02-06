package cn.fqfx.GoodByeFQFX.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 管理员实体
 *
 * @author wjh
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends AbstractTickPojo {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 账号
     */
    @Column(length = 24, unique = true, nullable = false)
    private String account;

    /**
     * 密码
     */
    @Column(length = 32)
    private String password;

    /**
     * 昵称
     */
    @Column(length = 12)
    private String name;

    /**
     * 账号状态 枚举
     */
    private Integer status;

    @OneToMany
    @JsonIgnore
    private Set<AdminLog> adminLogs;

    @JsonIgnore
    @OneToMany
    private Set<Upload> uploads = new HashSet<>();
}
