package ai.plantdata.service.impl;

import cn.hiboot.mcn.core.exception.ServiceException;
import ai.plantdata.bean.po.User;
import ai.plantdata.dao.UserRepository;
import ai.plantdata.exception.ErrorCodes;
import ai.plantdata.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }

    @Override
    public User getByMobile(String mobile) {
        User userBean = getRepository().findByUsername(mobile);
        if(Objects.isNull(userBean)){
            log.error("{} not exist",mobile);
            throw ServiceException.newInstance(ErrorCodes.USER_NOT_FOUND);
        }
        return userBean;
    }

}