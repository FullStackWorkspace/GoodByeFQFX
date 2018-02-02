package cn.fqfx.GoodByeFQFX.service;

import cn.fqfx.GoodByeFQFX.domain.User;
import cn.fqfx.GoodByeFQFX.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 获取用户分页
     *
     * @param pageRequest 分页请求
     * @return 用户分页
     */
    public Page<User> getUsersByPage(PageRequest pageRequest) {

        return userRepository.findAll(pageRequest);
    }
}
