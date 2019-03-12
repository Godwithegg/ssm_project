package com.danhuang.mapper;

import com.danhuang.crop.Status;
import com.danhuang.crop.StatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatusMapper {
	int countByExample(StatusExample example);

	int deleteByExample(StatusExample example);

	int deleteByPrimaryKey(String name);

	int insert(Status record);

	int insertSelective(Status record);

	List<Status> selectByExample(StatusExample example);

	Status selectByPrimaryKey(String name);

	int updateByExampleSelective(@Param("record") Status record, @Param("example") StatusExample example);

	int updateByExample(@Param("record") Status record, @Param("example") StatusExample example);

	int updateByPrimaryKeySelective(Status record);

	int updateByPrimaryKey(Status record);
}