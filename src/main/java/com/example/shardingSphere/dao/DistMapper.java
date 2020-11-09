package com.example.shardingSphere.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingSphere.entity.DistInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: cat
 * @Date: 2020/11/09 11:39
 * @Description: user dao层
 */
@Mapper
public interface DistMapper extends BaseMapper<DistInfo> {


}
