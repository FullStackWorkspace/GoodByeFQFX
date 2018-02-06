package cn.fqfx.GoodByeFQFX.web.rest;

import cn.fqfx.GoodByeFQFX.domain.Upload;
import cn.fqfx.GoodByeFQFX.domain.User;
import cn.fqfx.GoodByeFQFX.domain.dto.BaseDTO;
import cn.fqfx.GoodByeFQFX.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/upload")
@RestController
public class UploadResource {

    @Autowired
    private UploadService uploadService;
    /**
     * 获取下载列表，带分页
     * @param page 第几页
     * @param size 一页个数
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<BaseDTO<Page<Upload>>> list(int page,int size){
        Page<Upload> result = uploadService.getUploadListByPage(new PageRequest(page,size));
        return  ResponseEntity.ok(BaseDTO.ok(result));
    }
}
