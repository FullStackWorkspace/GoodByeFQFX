package cn.fqfx.GoodByeFQFX.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String articleTitle;

    @Column(length = 20)
    private Date uploadTime;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;
}
