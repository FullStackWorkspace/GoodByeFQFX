package cn.fqfx.GoodByeFQFX.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Title extends AbstractTickPojo {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 名称
     */
    @Column(length = 24)
    private String name;

    /**
     * 父级导航
     */
    @Column
    private Long parentId;

    /**
     * 链接
     */
    @Column(length = 128)
    private String linkUrl;


}
