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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 删除文件
     * @param id 参数主键id
     * @return
     */
    @PutMapping("/remove/{id}")
    public ResponseEntity<BaseDTO> del(@PathVariable Long id){
        BaseDTO result = uploadService.delById(id);
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/add")
    public ResponseEntity<BaseDTO> add(@RequestParam("file") MultipartFile file){
        BaseDTO result = uploadService.addUpload(file);
        return ResponseEntity.ok(result);
    }
}
