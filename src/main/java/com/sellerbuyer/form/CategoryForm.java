package com.sellerbuyer.form;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @program: sell
 * @description: 类目表单提交对象
 * @author: JunOba
 * @create: 2018-12-13 14:41
 */
@Data
public class CategoryForm {

    /** 类目id */
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;

}
