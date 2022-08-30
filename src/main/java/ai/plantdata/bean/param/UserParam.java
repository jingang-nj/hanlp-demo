package ai.plantdata.bean.param;

import cn.hiboot.mcn.autoconfigure.validator.annotation.Phone;
import cn.hiboot.mcn.autoconfigure.validator.group.DefaultCrud;
import ai.plantdata.validator.Username;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * UserParam
 *
 * @author DingHao
 * @since 2021/7/27 10:25
 */
@Setter
@Getter
public class UserParam {

    @Phone
    @NotEmpty(groups = DefaultCrud.Create.class)
    @Username
    @ApiModelProperty(value = "用户名(手机号)",required = true)
    private String username;

    @NotEmpty(groups = DefaultCrud.Create.class)
    @ApiModelProperty(value = "昵称",required = true)
    private String nickname;

    @Email
    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("性别")
    private String gender;

}
