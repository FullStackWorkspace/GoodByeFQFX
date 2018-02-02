package cn.fqfx.GoodByeFQFX.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractTickPojo {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 账号
     */
    @Column(length = 24, unique = true, nullable = false)
    private String userAccount;

    /**
     * 密码
     */
    @Column(length = 32)
    private String userPassword;

    /**
     * 昵称
     */
    @Column(length = 12)
    private String userName;

    /**
     * 院系
     */
    @Column(length = 12)
    private String faculty;

    /**
     * 专业
     */
    @Column(length = 12)
    private String major;
}
