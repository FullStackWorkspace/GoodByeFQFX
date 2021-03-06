package cn.fqfx.GoodByeFQFX.domain;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Article extends AbstractTickPojo {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 500)
    private String content;

    @Column(length = 20)
    private String name;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime uploadTime;
    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;

    @Column(name = "is_deleted")
    private Boolean deleted;
}
