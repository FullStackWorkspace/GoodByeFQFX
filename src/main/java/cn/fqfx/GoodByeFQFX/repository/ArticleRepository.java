package cn.fqfx.GoodByeFQFX.repository;

import cn.fqfx.GoodByeFQFX.domain.Article;
import cn.fqfx.GoodByeFQFX.domain.dto.BaseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long>{
    Page<Article> findAllByDeleted(Boolean deleted, Pageable pageable);

}
