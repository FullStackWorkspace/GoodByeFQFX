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
public class image {
	@Id
    @GeneratedValue
    private Long imageId;
	
	
	@Column(length=20)
	private String imageTitle;

	
	@Column(length=200)
	private String imageUrl;
}
