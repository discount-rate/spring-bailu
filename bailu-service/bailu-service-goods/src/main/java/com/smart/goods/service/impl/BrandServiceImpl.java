package com.smart.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.goods.dao.BrandMapper;
import com.smart.goods.pojo.Brand;
import com.smart.goods.service.BrandService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

   @Resource
    BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand selectById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addBrand(Brand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int update(Brand brand) {
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteById(Integer id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Brand> selectByList(Brand brand) {

        Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Brand> selectPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Brand> brandList = brandMapper.selectAll();

        PageInfo pageInfo = new PageInfo(brandList);

        return pageInfo;
    }


    public Example createExample(Brand brand){
        //自定义条件搜索对象 Example
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();//条件构造器

        if (brand!=null){

            if (!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name","%"+brand.getName()+"%");
            }

            if (!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("letter",brand.getLetter());
            }
        }
        return example;
    }

}
