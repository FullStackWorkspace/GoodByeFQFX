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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    /**
     * 上传文件
     * @param file 文件对象
     * @param request
     * @return
     */
    @RequestMapping("/add")
    public ResponseEntity<BaseDTO> add(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        BaseDTO result = uploadService.addUpload(file,request);
        return ResponseEntity.ok(result);
    }

    /**
     * 下载文件
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/download")
    public ResponseEntity<BaseDTO> download(HttpServletRequest request, HttpServletResponse response){
        BaseDTO result = uploadService.download(request,response);
        return ResponseEntity.ok(result);
    }
}
