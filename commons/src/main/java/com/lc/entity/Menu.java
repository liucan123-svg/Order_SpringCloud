package com.lc.entity;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author ：lc
 * @date ：Created in 2020/8/21 16:31
 * @description：
 * @modified By：
 * @version: $
 */

@Data  //自动为所有字段添加@ToString, @EqualsAndHashCode, @Getter方法，为非final字段添加@Setter
@Accessors(chain = true)       //chain为true,则setter方法返回当前对象
@NoArgsConstructor  //自动生成无参数构造函数。
@AllArgsConstructor //自动生成全参数构造函数
@ToString
public class Menu {
    private Integer id;
    private String name;
    private Double price;
    private String flavor;
    //private Integer tid;
    private Type type;
}
