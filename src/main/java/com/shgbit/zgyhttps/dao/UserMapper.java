package com.shgbit.zgyhttps.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /*这些不需要加mapping*/
    //查询语句
    String sql="SELECT CourtID as court,'0' as [type] FROM [dbo].[Master_courtinfo]";

    @Select(sql)
    List<JSONObject> queryAll();
}
