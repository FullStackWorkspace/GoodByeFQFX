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
public class Title {
	@Id
    @GeneratedValue
    private Long titleId;

    /**
     * 名称
     */
    @Column(length = 12)
    private String titleName;
    
    /**
     * 父级导航
     */
    @Column(length=10)
    private Long parendId;
    
    /**
     * 链接
     */ 
    @Column(length=200)
    private String linkUrl;
    
    @JsonIgnore
    @OneToMany(mappedBy = "title" ,fetch =FetchType.EAGER)
    private Set<Article> articles = new HashSet<>();
    
    
}
