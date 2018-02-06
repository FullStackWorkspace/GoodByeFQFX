package cn.fqfx.GoodByeFQFX.domain;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Upload extends AbstractTickPojo{
    /**
     * 主键id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    /**
     * 上传用户，外键
     */
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    /**
     * 上传时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime uploadTime;

    /**
     * 路径
     */
    @Column(length = 50)
    private String path;

    /**
     * 文件名
     */
    @Column(length = 50)
    private String fileName;

}
