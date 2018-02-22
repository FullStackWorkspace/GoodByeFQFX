package cn.fqfx.GoodByeFQFX.service;


import cn.fqfx.GoodByeFQFX.AutoIncrLockNumber;
import cn.fqfx.GoodByeFQFX.constants.UploadConsts;
import cn.fqfx.GoodByeFQFX.domain.Admin;
import cn.fqfx.GoodByeFQFX.domain.Article;
import cn.fqfx.GoodByeFQFX.domain.Upload;
import cn.fqfx.GoodByeFQFX.domain.dto.BaseDTO;
import cn.fqfx.GoodByeFQFX.repository.UploadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.time.ZonedDateTime;
import java.util.Date;

@Slf4j
@Service
public class UploadService {

    @Autowired
    private AutoIncrLockNumber autoIncrLockNumber;
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
     * 文件上传
     * @param file 处理对象
     * @param request request对象
     * @return 处理结果集
     */
    public BaseDTO addUpload(MultipartFile file, HttpServletRequest request) {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //获取前台文件名称
        String name = request.getParameter("fileName");
        String adminId = request.getParameter("adminId");
        String articleId = request.getParameter("articleId");
        if (file.isEmpty()) {
            return BaseDTO.error(UploadConsts.ERROR_FILE_ADD_EMPTY_PARAM,"文件为空");
        }
        if((!suffixName.equals(".xls"))&&(!suffixName.equals(".xlsx"))&&(!suffixName.equals(".doc"))&&(!suffixName.equals(".docx"))){
            return BaseDTO.error(UploadConsts.ERROR_FILE_ADD_TYPE_PARAM,"文件上传格式错误");
        }

        String index = String.valueOf(autoIncrLockNumber.GetAndIncr());
        //String filePath = "D:/test";

        //获取当前可执行jar包所在目录
        String filePath = System.getProperty("java.class.path");
        //得到当前操作系统的分隔符，windows下是";"
        String pathSplit = System.getProperty("path.separator");
        //若没有其他依赖，则filePath的结果应当是该可运行jar包的绝对路径，
         // 此时我们只需要经过字符串解析，便可得到jar所在目录
        if(filePath.contains(pathSplit)){
            filePath = filePath.substring(0,filePath.indexOf(pathSplit));
        }else if (filePath.endsWith(".jar")) {
            //截取路径中的jar包名,可执行jar包运行的结果里包含".jar"
            filePath = filePath.substring(0, filePath.lastIndexOf(File.separator) + 1);
        }
        String newFileName = new Date().getTime() + index + name + suffixName;
        String realPath = filePath + "/upload/" + newFileName;
        int subIndex = realPath.indexOf("/upload");
        String savePath = realPath.substring(subIndex);
        File newFile = new File(realPath);
        //判断文件夹是否存在
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        try {
            //保存文件
            file.transferTo(newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //插入数据库
        Upload upload = new Upload();
        Admin admin = new Admin();
        admin.setId(Long.valueOf(adminId));
        upload.setAdmin(admin);
        Article article = new Article();
        article.setId(Long.valueOf(articleId));
        upload.setArticle(article);
        upload.setDeleted(false);
        upload.setFileName(name);
        upload.setPath(savePath);
        upload.setUploadTime(ZonedDateTime.now());
        uploadRepository.save(upload);
        return BaseDTO.ok("文件上传成功",realPath);
    }

    /**
     * 文件下载
     * @param request
     * @param response
     * @return
     */
    public BaseDTO download(HttpServletRequest request, HttpServletResponse response) {
        Long uploadId = Long.valueOf(request.getParameter("uploadId"));
        Upload upload = uploadRepository.findOne(uploadId);
        if(upload==null){
            BaseDTO.error(UploadConsts.ERROR_FILE_DOWNLOAD_NOEXITS_PARAM,"文件不存在");
        }
        String path = upload.getPath();
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(upload.getFileName() + path.substring(path.lastIndexOf(".")) ));
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try{
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(path)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return BaseDTO.ok("文件下载成功");
        }

    }
}
