package cn.fqfx.GoodByeFQFX.repository;

import cn.fqfx.GoodByeFQFX.domain.Upload;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<Upload,Long>{
    Page<Upload> findAllByDeleted(Boolean deleted, Pageable pageable);
}
