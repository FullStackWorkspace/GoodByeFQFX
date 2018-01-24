package cn.fqfx.GoodByeFQFX.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * 管理员日志记录实体类
 *
 * @author wjh
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AdminLog extends AbstractTickPojo {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 管理员外键
     */
    @ManyToOne
    private Admin admin;

    /**
     * 登录时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime loginTime;

    /**
     * 登录IP
     */
    @Column(length = 20)
    private String loginIp;
}
