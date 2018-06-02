package com.iwill.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.iwill.service.api.IProductService;
import org.springframework.stereotype.Component;

@Service(interfaceClass = IProductService.class)
@Component
public class ProductService implements IProductService {
    /**
     * 根据产品ID获取产品名字
     *
     * @param productId
     * @return
     */
    @Override
    public String getProductName(long productId) {
        return "productName:" + productId;
    }
}
