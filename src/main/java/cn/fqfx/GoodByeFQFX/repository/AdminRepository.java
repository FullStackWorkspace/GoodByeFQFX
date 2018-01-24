package cn.fqfx.GoodByeFQFX.repository;

import cn.fqfx.GoodByeFQFX.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    /**
     * 通过账号查找
     *
     * @param account 账号
     * @return 唯一结果
     */
    Admin findByAccount(String account);
}
