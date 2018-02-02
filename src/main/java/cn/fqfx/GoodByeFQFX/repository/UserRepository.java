package cn.fqfx.GoodByeFQFX.repository;

import cn.fqfx.GoodByeFQFX.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
