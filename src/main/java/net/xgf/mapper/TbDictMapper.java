package net.xgf.mapper;

import java.util.List;
import net.xgf.pojo.TbDict;
import net.xgf.pojo.TbDictExample;
import org.apache.ibatis.annotations.Param;

public interface TbDictMapper {
    int countByExample(TbDictExample example);

    int deleteByExample(TbDictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDict record);

    int insertSelective(TbDict record);

    List<TbDict> selectByExample(TbDictExample example);

    TbDict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDict record, @Param("example") TbDictExample example);

    int updateByExample(@Param("record") TbDict record, @Param("example") TbDictExample example);

    int updateByPrimaryKeySelective(TbDict record);

    int updateByPrimaryKey(TbDict record);
}