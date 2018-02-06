package cn.fqfx.GoodByeFQFX.service;


import cn.fqfx.GoodByeFQFX.domain.Upload;
import cn.fqfx.GoodByeFQFX.repository.UploadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
        return uploadRepository.findAll(pageRequest);
    }
}
