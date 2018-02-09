package cn.fqfx.GoodByeFQFX.service;

import cn.fqfx.GoodByeFQFX.constants.ArticleConsts;
import cn.fqfx.GoodByeFQFX.domain.Article;
import cn.fqfx.GoodByeFQFX.domain.dto.BaseDTO;
import cn.fqfx.GoodByeFQFX.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.fqfx.GoodByeFQFX.constants.ArticleConsts;

import java.time.ZonedDateTime;

@Slf4j
@Service
@Transactional
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 分页查找文章
     * @param pageRequest
     * @return
     */
    public Page<Article> getArticleListByPage(PageRequest pageRequest) {
        return articleRepository.findAllByDeleted(false, pageRequest);
    }

    /**
     * 删除文章
     * @param id 主键id
     * @return
     */
    public BaseDTO delById(Long id) {
        Article article = articleRepository.findOne(id);
        if(article!=null){
            article.setDeleted(true);
            articleRepository.save(article);
            return BaseDTO.ok("文件删除成功",article);
        }
        return BaseDTO.error(ArticleConsts.ERROR_ARTICLE_EMPTY_PARAM,"该文章不存在");
    }

    /**
     * 新增文章
     * @param article 文章对象
     * @return
     */
    public BaseDTO addArticle(Article article) {
        article.setUploadTime(ZonedDateTime.now());
        articleRepository.save(article);
        return BaseDTO.ok();
    }
}
