package com.lc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class Order {
    private Integer id;
    private User user;
    private Menu menu;
    private Admin admin;
    private Date date;
    private String state;
}
