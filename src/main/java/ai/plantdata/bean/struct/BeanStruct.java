package ai.plantdata.bean.struct;


import ai.plantdata.bean.param.UserParam;
import ai.plantdata.bean.po.User;
import org.mapstruct.Mapper;

/**
 * bean转换
 *
 * @author DingHao
 * @since 2021/2/23 22:16
 */
@Mapper(componentModel = "spring")
public interface BeanStruct {

    User toUser(UserParam userParam);

}
