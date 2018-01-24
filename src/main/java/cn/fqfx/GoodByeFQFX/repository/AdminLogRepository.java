package cn.fqfx.GoodByeFQFX.repository;

import cn.fqfx.GoodByeFQFX.domain.AdminLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminLogRepository extends JpaRepository<AdminLog, Long> {
}
