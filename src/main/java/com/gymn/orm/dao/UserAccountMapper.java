package com.gymn.orm.dao;

import com.gymn.orm.entity.UserAccount;
import com.gymn.orm.entity.UserAccountExample;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface UserAccountMapper {
    int countByExample(UserAccountExample example);

    int deleteByExample(UserAccountExample example);

    int deleteByPrimaryKey(Integer ID);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    List<UserAccount> selectByExample(UserAccountExample example);

    UserAccount selectByPrimaryKey(Integer ID);

    int updateByExampleSelective(@Param("record") UserAccount record, @Param("example") UserAccountExample example);

    int updateByExample(@Param("record") UserAccount record, @Param("example") UserAccountExample example);

    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);

    Map<String, Object> selectAsMap(Integer ID);

    List<UserAccount> selectByIds(@Param("ids") Collection<Integer> ids);
}