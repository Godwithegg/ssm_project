package com.danhuang.mapper;

import com.danhuang.crop.Kinds;
import com.danhuang.crop.KindsExample;
import com.danhuang.crop.StatusCustom;
import com.danhuang.crop.StatusQueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KindsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kinds
     *
     * @mbggenerated Mon Jul 01 08:55:51 CST 2019
     */
    int countByExample(KindsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kinds
     *
     * @mbggenerated Mon Jul 01 08:55:51 CST 2019
     */
    int deleteByExample(KindsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kinds
     *
     * @mbggenerated Mon Jul 01 08:55:51 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kinds
     *
     * @mbggenerated Mon Jul 01 08:55:51 CST 2019
     */
    int insert(Kinds record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kinds
     *
     * @mbggenerated Mon Jul 01 08:55:51 CST 2019
     */
    int insertSelective(Kinds record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kinds
     *
     * @mbggenerated Mon Jul 01 08:55:51 CST 2019
     */
    List<Kinds> selectByExample(KindsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kinds
     *
     * @mbggenerated Mon Jul 01 08:55:51 CST 2019
     */
    Kinds selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kinds
     *
     * @mbggenerated Mon Jul 01 08:55:51 CST 2019
     */
    int updateByExampleSelective(@Param("record") Kinds record, @Param("example") KindsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kinds
     *
     * @mbggenerated Mon Jul 01 08:55:51 CST 2019
     */
    int updateByExample(@Param("record") Kinds record, @Param("example") KindsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kinds
     *
     * @mbggenerated Mon Jul 01 08:55:51 CST 2019
     */
    int updateByPrimaryKeySelective(Kinds record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kinds
     *
     * @mbggenerated Mon Jul 01 08:55:51 CST 2019
     */
    int updateByPrimaryKey(Kinds record);

}