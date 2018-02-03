package cn.fqfx.GoodByeFQFX.web.rest;

import cn.fqfx.GoodByeFQFX.domain.Admin;
import cn.fqfx.GoodByeFQFX.domain.dto.BaseDTO;
import cn.fqfx.GoodByeFQFX.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@Slf4j
public class AdminResource {

    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录
     *
     * @return BaseDTO
     */
    @PostMapping("/login")
    public ResponseEntity<BaseDTO> login(Admin admin, HttpSession session, HttpServletRequest request) {
        BaseDTO result = adminService.login(admin.getAccount(), admin.getPassword(), request.getRemoteAddr(), session);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 管理员注销登录
     *
     * @param session
     * @return
     */
    @PostMapping("/logout")
    public ResponseEntity<BaseDTO> regist(HttpSession session) {
        BaseDTO result = adminService.logout(session);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 新增管理员
     *
     * @param admin
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<BaseDTO> add(Admin admin) {
        BaseDTO result = adminService.addNewAdmin(admin);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 所有管理员
     *
     * @return
     */
    @GetMapping("/all")
    public List<Admin> all() {
        return adminService.getAllAdmins();
    }
}
