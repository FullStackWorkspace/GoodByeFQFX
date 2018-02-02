package cn.fqfx.GoodByeFQFX.validate;

import cn.fqfx.GoodByeFQFX.constants.Consts;
import cn.fqfx.GoodByeFQFX.domain.Admin;
import cn.fqfx.GoodByeFQFX.domain.dto.BaseDTO;

public class AdminValidate {

    public static BaseDTO validate(Admin admin) {
        String account = admin.getAccount();
        String password = admin.getPassword();
        String name = admin.getName();

        if (!ValidateUtils.LengthBetween(account, Consts.ADMIN_ACCOUNT_LEN_MIN, Consts.ADMIN_ACCOUNT_LEN_MAX)) {
            return BaseDTO.error(2, String.format("账号限定长度%d-%d", Consts.ADMIN_ACCOUNT_LEN_MIN, Consts.ADMIN_ACCOUNT_LEN_MAX));
        }

        if (ValidateUtils.ExistSpace(account)) {
            return BaseDTO.error(3, "账号不能存在空格");
        }

        if (ValidateUtils.AllNumber(account)) {
            return BaseDTO.error(4, "账号不能为纯数字");
        }

        if (ValidateUtils.ExistChinese(account)) {
            return BaseDTO.error(5, "账号不能存在中文");
        }

        if (!ValidateUtils.LengthBetween(password, Consts.ADMIN_PASSWORD_LEN_MIN, Consts.ADMIN_PASSWORD_LEN_MAX)) {
            return BaseDTO.error(6, String.format("密码限定长度%d-%d", Consts.ADMIN_PASSWORD_LEN_MIN, Consts.ADMIN_PASSWORD_LEN_MAX));
        }

        if (ValidateUtils.ExistSpace(password)) {
            return BaseDTO.error(7, "密码不能存在空格");
        }

        if (!ValidateUtils.LengthBetween(name, Consts.ADMIN_NAME_LEN_MIN, Consts.ADMIN_NAME_LEN_MAX)) {
            return BaseDTO.error(8, String.format("昵称限定长度%d-%d", Consts.ADMIN_NAME_LEN_MIN, Consts.ADMIN_NAME_LEN_MAX));
        }

        if (ValidateUtils.ExistSpace(name)) {
            return BaseDTO.error(9, "昵称不能存在空格");
        }

        return BaseDTO.ok();
    }
}
