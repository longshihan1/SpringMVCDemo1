package com.longshihan.resposite;

import com.longshihan.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 *  在JpaRepository中，定义了几个简化的操作数据库的方法：
 *  findAll()：查找表中所有记录；
 *  findOne(Integer id)：按id来查找某一条记录；
 *  findByXXX(Object xxx)：在这里XXX是一个字段名，根据该字段的值开查找所有记录；
 *  save()和delete()：添加一条记录以及删除一条记录。
 * Created by Administrator on 2016-7-24.
 */
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update UserEntity us set us.nickname=:qNickname, us.firstName=:qFirstName, us.lastName=:qLastName, us.password=:qPassword where us.id=:qId")
    public void updateUser(@Param("qNickname") String nickname, @Param("qFirstName") String firstName,
                           @Param("qLastName") String qLastName, @Param("qPassword") String password, @Param("qId") Integer id);

}
