package ai.plantdata.rest;

import cn.hiboot.mcn.autoconfigure.jpa.Specifications;
import cn.hiboot.mcn.autoconfigure.jpa.predicate.DateBetweenPredicate;
import cn.hiboot.mcn.autoconfigure.jpa.predicate.FieldLikePredicate;
import cn.hiboot.mcn.autoconfigure.validator.group.DefaultCrud;
import cn.hiboot.mcn.core.model.result.RestResp;
import ai.plantdata.bean.param.UserParam;
import ai.plantdata.bean.po.User;
import ai.plantdata.bean.search.UserSearch;
import ai.plantdata.bean.struct.BeanStruct;
import ai.plantdata.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@Api(tags = "用户模块")
public class UserRestApi {

    @Autowired
    private BeanStruct beanStruct;

    private final UserService userService;

    public UserRestApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("save")
    @ApiOperation("新增")
    public RestResp<User> add(@Validated(DefaultCrud.Create.class) @RequestBody UserParam userParam) {
        User userBean = beanStruct.toUser(userParam);
        userService.save(userBean);
        return new RestResp<>(userBean);
    }

    @PostMapping("delete/{id}")
    @ApiOperation("删除")
    public RestResp<?> delete(@ApiParam(value = "用户id") @PathVariable Integer id) {
        userService.deleteById(id);
        return new RestResp<>();
    }

    @PostMapping("update/{id}")
    @ApiOperation("修改")
    @ApiImplicitParam(name = "id",value = "用户id",paramType = "path")
    public RestResp<?> update(@PathVariable Integer id,@Validated(DefaultCrud.Update.class) @RequestBody UserParam userParam) {
        userService.updateById(id,beanStruct.toUser(userParam));
        return new RestResp<>();
    }

    @PostMapping("page")
    @ApiOperation("分页")
    public RestResp<List<User>> listPage(@RequestBody UserSearch userSearch) {
        User userBean = new User();
        userBean.setNickname(userSearch.getStatus());
        return userService.page(Specifications.withAnd(userBean
                ,new FieldLikePredicate<>("nickname", userSearch.getName())
                ,new DateBetweenPredicate<>("createAt", userSearch.getStarTime(), userSearch.getEndTime())),userSearch);
    }

    @GetMapping("get/{id}")
    @ApiOperation("获取")
    @ApiImplicitParam(name = "id",value = "用户id",paramType = "path")
    public RestResp<User> get(@PathVariable Integer id) {
        return new RestResp<>(userService.getById(id));
    }

}
