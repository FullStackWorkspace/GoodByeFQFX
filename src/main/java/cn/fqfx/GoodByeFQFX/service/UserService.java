package cn.fqfx.GoodByeFQFX.service;

import cn.fqfx.GoodByeFQFX.domain.User;
import cn.fqfx.GoodByeFQFX.domain.dto.BaseDTO;
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
     * @param pageRequest 分页信息
     * @return 用户分页
     */
    public Page<User> getUsersByPage(PageRequest pageRequest) {

        // 查询删除状态为false的用户分页
        return userRepository.findAllByDeleted(false, pageRequest);
    }

    /**
     * 通过id删除用户
     *
     * @param id 用户id
     * @return 删除处理结果
     */
    public BaseDTO delById(Long id) {
        User user = userRepository.findOne(id);
        if (user != null) {
            user.setDeleted(true);
            user = userRepository.save(user);
            return BaseDTO.ok("删除成功", user);
        } else {
            return BaseDTO.error(1, "不存在的用户");
        }
    }
}
