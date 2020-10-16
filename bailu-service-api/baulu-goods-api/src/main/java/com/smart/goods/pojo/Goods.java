package com.smart.goods.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 描述
 *
 * @author www.itheima.com
 * @version 1.0
 * @package com.changgou.goods.pojo *
 * @since 1.0
 */
public class Goods implements Serializable {
    private com.smart.goods.pojo.Spu spu;
    private List<com.smart.goods.pojo.Sku> skuList;

    public com.smart.goods.pojo.Spu getSpu() {
        return spu;
    }

    public void setSpu(com.smart.goods.pojo.Spu spu) {
        this.spu = spu;
    }

    public List<com.smart.goods.pojo.Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<com.smart.goods.pojo.Sku> skuList) {
        this.skuList = skuList;
    }
}
