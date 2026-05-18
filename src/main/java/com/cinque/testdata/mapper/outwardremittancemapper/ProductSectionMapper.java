package com.cinque.testdata.mapper.outwardremittancemapper;

import com.cinque.testdata.DTO.outwardremittancedata.ProductSectionData;
import com.cinque.testdata.OutwardRemittanceTestData;

public class ProductSectionMapper {

    public static ProductSectionData map (OutwardRemittanceTestData data){
        return ProductSectionData.builder().country(data.getCountry()).
                currency(data.getCurrency()).
                producttype(data.getProducttype()).
                product(data.getProduct()).
                deliverymode(data.getDeliverymode()).
                build();
    }
}
