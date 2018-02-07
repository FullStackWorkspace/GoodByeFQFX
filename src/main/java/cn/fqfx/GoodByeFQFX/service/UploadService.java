package cn.fqfx.GoodByeFQFX.service;


import cn.fqfx.GoodByeFQFX.constants.UploadConsts;
import cn.fqfx.GoodByeFQFX.domain.Upload;
import cn.fqfx.GoodByeFQFX.domain.dto.BaseDTO;
import cn.fqfx.GoodByeFQFX.repository.UploadRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class UploadService {

    @Autowired
    private UploadRepository uploadRepository;

    /**
     * 获取上传列表分页
     * @param pageRequest 分页信息
     * @return 下载分页列表
     */
    public Page<Upload> getUploadListByPage(PageRequest pageRequest) {
        return uploadRepository.findAllByDeleted(false, pageRequest);
    }

    /**
     * 删除文件
     * @param id 文件主键id
     * @return 处理结果
     */
    public BaseDTO delById(Long id) {
        Upload upload = uploadRepository.findOne(id);
        if (upload != null){
            upload.setDeleted(true);
            upload = uploadRepository.save(upload);
            return BaseDTO.ok("删除文件成功",upload);
        }else{
            return BaseDTO.error(UploadConsts.ERROR_FILE_DELETE_EMPTY_PARAM,"该文件不存在");
        }
    }

    /**
     * 上传文件
     * @param file 文件
     * @return 处理结果
     */
    public BaseDTO addUpload(MultipartFile file) {
        final AtomicInteger count = new AtomicInteger(0);
        if (file.isEmpty()) {
            return BaseDTO.error(UploadConsts.ERROR_FILE_ADD_EMPTY_PARAM,"文件为空");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        count.incrementAndGet();
        Upload upload = new Upload();
        return BaseDTO.ok("文件上传成功",upload);
    }
}
