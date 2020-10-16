package com.smart.goods.service;

import com.github.pagehelper.PageInfo;
import com.smart.goods.pojo.Brand;

import java.util.List;

public interface BrandService {


    List<Brand> findAll();

    Brand selectById(Integer id);

    int addBrand(Brand brand);

    int update(Brand brand);

    int deleteById(Integer id);

    List<Brand> selectByList(Brand brand);

    PageInfo<Brand> selectPage(Integer page,Integer size);

}
