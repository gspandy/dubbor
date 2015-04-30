package org.dboxes.dubbor.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dboxes.dubbor.common.annotation.MyBatisMapper;
import org.dboxes.dubbor.user.domain.User;


@MyBatisMapper
public interface UserMapper {

	User findOne(@Param("id") Long id);

	/*List<Goods> list(@Param("salesMode") String salesMode, @Param("offset") int offset, @Param("rows") int rows);*/

	/*List<Goods> trialTop2();*/

	/*int updateInventory(@Param("code") String code);*/
}