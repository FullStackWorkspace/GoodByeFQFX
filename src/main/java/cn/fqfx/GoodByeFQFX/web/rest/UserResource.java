package cn.fqfx.GoodByeFQFX.web.rest;

import cn.fqfx.GoodByeFQFX.domain.User;
import cn.fqfx.GoodByeFQFX.domain.dto.BaseDTO;
import cn.fqfx.GoodByeFQFX.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/user")
@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表 带分页
     *
     * @param page 第几页(0是第一页)
     * @param size 每页记录数
     * @return User分页
     */
    @GetMapping("/list")
    public ResponseEntity<BaseDTO<Page<User>>> list(int page, int size) {
        Page<User> result = userService.getUsersByPage(new PageRequest(page, size));

        return ResponseEntity.ok(BaseDTO.ok(result));
    }

    @PutMapping("/remove/{id}")
    public ResponseEntity<BaseDTO> del(@PathVariable Long id) {
        BaseDTO result = userService.delById(id);

        return ResponseEntity.ok(result);
    }
}
