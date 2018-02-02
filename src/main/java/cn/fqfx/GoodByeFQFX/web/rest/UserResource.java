package cn.fqfx.GoodByeFQFX.web.rest;

import cn.fqfx.GoodByeFQFX.domain.User;
import cn.fqfx.GoodByeFQFX.domain.dto.BaseDTO;
import cn.fqfx.GoodByeFQFX.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/user")
@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表 带分页
     *
     * @param page 第几页
     * @param size 每页几条记录
     * @return 分页后的用户列表
     */
    @GetMapping("/list")
    public ResponseEntity<BaseDTO<Page<User>>> list(int page, int size) {
        PageRequest pageRequest = new PageRequest(page, size);
        Page<User> result = userService.getUsersByPage(pageRequest);

        return ResponseEntity.ok(BaseDTO.ok(result));
    }
}
