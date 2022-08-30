package ai.plantdata.service;

import cn.hiboot.mcn.autoconfigure.jpa.BaseService;
import ai.plantdata.bean.po.User;
import ai.plantdata.dao.UserRepository;

public interface UserService extends BaseService<User,Integer, UserRepository> {
    User getByMobile(String mobile);
}