package ai.plantdata.dao;

import cn.hiboot.mcn.autoconfigure.jpa.BaseRepository;
import ai.plantdata.bean.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Integer> {

    User findByUsername(String username);

}