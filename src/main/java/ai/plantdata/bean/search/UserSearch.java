package ai.plantdata.bean.search;

import cn.hiboot.mcn.core.model.base.PageSort;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * UserBeanSearch
 *
 * @author DingHao
 * @since 2022/1/27 13:39
 */
@Setter
@Getter
public class UserSearch extends PageSort {
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("用户状态")
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("用户过滤的开始时间")
    private Date starTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("用户过滤的结束时间")
    private Date endTime;
}
