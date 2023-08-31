package com.linzb.guluuser.test.dao;

import com.linzb.guluuser.test.entity.EmpBasInfoExtCDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestDAO{
    int insert(EmpBasInfoExtCDO empBasInfoExtCDO);

    int insertBatch(List<EmpBasInfoExtCDO> list);

    int updateBatchByPrimaryKey(List<EmpBasInfoExtCDO> list);

    List<EmpBasInfoExtCDO> selectList(EmpBasInfoExtCDO empBasInfoExtCDO);

    EmpBasInfoExtCDO selectByPrimaryKey(EmpBasInfoExtCDO empBasInfoExtCDO);

    List<EmpBasInfoExtCDO> selectListByPrimaryKeys(List<EmpBasInfoExtCDO> list);

    int deleteByPrimaryKey(EmpBasInfoExtCDO empBasInfoExtCDO);

    int deleteBatchByPrimaryKey(List<EmpBasInfoExtCDO> list);

    int delete(EmpBasInfoExtCDO empBasInfoExtCDO);

    int updateByPrimaryKey(EmpBasInfoExtCDO empBasInfoExtCDO);

    int updateBtchByPkForFeilds(@Param("commonFeildDO")EmpBasInfoExtCDO commonFeildDO, @Param("list") List<EmpBasInfoExtCDO > list);


}
