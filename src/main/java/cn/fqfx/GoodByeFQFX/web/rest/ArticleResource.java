package cn.fqfx.GoodByeFQFX.web.rest;

import cn.fqfx.GoodByeFQFX.domain.Article;
import cn.fqfx.GoodByeFQFX.domain.Upload;
import cn.fqfx.GoodByeFQFX.domain.dto.BaseDTO;
import cn.fqfx.GoodByeFQFX.service.ArticleService;
import cn.fqfx.GoodByeFQFX.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequestMapping("/api/article")
@RestController
public class ArticleResource {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取文章列表，带分页
     * @param page 第几页
     * @param size 一页个数
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<BaseDTO<Page<Article>>> list(int page, int size){
        Page<Article> result = articleService.getArticleListByPage(new PageRequest(page,size));
        return  ResponseEntity.ok(BaseDTO.ok(result));
    }

    /**
     * 删除文章
     * @param id 文章主键id
     * @return
     */
    @PutMapping("/remove/{id}")
    public ResponseEntity<BaseDTO> remove(@PathVariable Long id){
        BaseDTO result = articleService.delById(id);
        return  ResponseEntity.ok(result);
    }

    /**
     * 新增文章
     * @param article 文章对象
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<BaseDTO> add(Article article){
        BaseDTO result = articleService.addArticle(article);
        return ResponseEntity.ok(result);
    }
}
