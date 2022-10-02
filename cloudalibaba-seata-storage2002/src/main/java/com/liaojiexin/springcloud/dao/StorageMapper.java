package com.liaojiexin.springcloud.dao;

import com.liaojiexin.springcloud.entity.Storage;

public interface StorageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
}