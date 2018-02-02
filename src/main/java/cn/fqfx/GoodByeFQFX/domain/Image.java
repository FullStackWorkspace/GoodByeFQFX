package cn.fqfx.GoodByeFQFX.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Image extends AbstractTickPojo {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 24)
    private String name;
    
    @Column(length = 128)
    private String imageUrl;

    @Column(name = "is_deleted")
    private Boolean deleted;
}
