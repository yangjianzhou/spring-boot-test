package com.iwill.service.api;

public interface IProductService {

    /**
     * 根据产品ID获取产品名字
     * @param productId
     * @return
     */
    public String getProductName(long productId);
}
