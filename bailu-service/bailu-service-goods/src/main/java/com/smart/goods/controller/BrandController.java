package com.smart.goods.controller;

import com.smart.common.entity.Result;
import com.smart.common.entity.StatusCode;
import com.smart.goods.pojo.Brand;
import com.smart.goods.service.BrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/brand")
@CrossOrigin //跨域
public class BrandController {

    @Resource
    BrandService brandService;

    /**
     * 查询所有品牌集合
     * @return
     */
    @PostMapping("/findAll")
    public Result<List<Brand>> findAll(){
        List<Brand> brandList = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"成功",brandList);
    }

    /**
     * 根据id查询产品信息
     * @param id
     * @return
     */
    @PostMapping("/selectById")
    public Result<Brand> selectById(Integer id){
        Brand brandByid = brandService.selectById(id);
        return new Result<Brand>(true, StatusCode.OK,"成功",brandByid);
    }


    /**
     * 增加一个品牌
     * @param brand
     * @return
     */
    @PostMapping("/addBrand")
    public Result<Brand> addBrand(@RequestBody Brand brand){
        int count = brandService.addBrand(brand);
        return new Result<Brand>(true, StatusCode.OK,"成功",count);
    }


    /**
     * 更新品牌信息
     * @param id
     * @param brand
     * @return
     */
    @PostMapping("/uupdate")
    public Result<Brand> uupdate(@PathVariable(value = "id")Integer id,@RequestBody Brand brand){
        brand.setId(id);
        int update = brandService.update(brand);
        return new Result<Brand>(true, StatusCode.OK,"成功",update);
    }


    /**
     * 删除品牌
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public Result<Brand> delete(@PathVariable(value = "id")Integer id){
        int cound = brandService.deleteById(id);
        return new Result<Brand>(true, StatusCode.OK,"成功",cound);
    }

    /**
     * 条件查询
     * @param brand
     * @return
     */
    @PostMapping("/selectList")
    public Result<List<Brand>> selectList(Brand brand){
        List<Brand> brandList = brandService.selectByList(brand);
        return new Result<List<Brand>>(true, StatusCode.OK,"成功",brandList);
    }




}
