package com.jiok.purchase.web.dto.response;

import com.jiok.purchase.domain.userProduct.CarProduct;
import com.jiok.purchase.domain.userProduct.GeneralProduct;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ResponseGetUserProductManagement {
    private Long userProdNo;
    private Integer usedPeriod;
    private Long mbrId;
    private String mbrPhone;

    @Builder
    public ResponseGetUserProductManagement(Long userProdNo, Integer usedPeriod, Long mbrId, String mbrPhone) {
        this.userProdNo = userProdNo;
        this.usedPeriod = usedPeriod;
        this.mbrId = mbrId;
        this.mbrPhone = mbrPhone;
    }

    public static List<ResponseGetUserProductManagement> toGeneralDto(List<GeneralProduct> generalProductList) {
        return generalProductList.stream()
                .map(item -> ResponseGetUserProductManagement.builder()
                        .userProdNo(item.getUserProdNo())
                        .usedPeriod(item.getUsedPeriod())
                        .mbrId(item.getMembers().getMbrId())
                        .mbrPhone(item.getMembers().getMbrPhone())
                        .build())
                .collect(Collectors.toList());
    }

    public ResponseGetUserProductManagement toCarDto(CarProduct carProduct) {
        return ResponseGetUserProductManagement.builder()
                .userProdNo(carProduct.getUserProdNo())
                .usedPeriod(carProduct.getUsedPeriod())
                .mbrId(carProduct.getMembers().getMbrId())
                .build();
    }

}
