package com.solvay.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 5300367959569982443L;
    private Long id;
    /**
     *   * 用户id 
     */
    private Long userId;
    /**
     *   * 总额度 
     */
    private BigDecimal total;
    /**
     *   * 已用额度 
     */
    private BigDecimal used;
    /**
     *   * 剩余额度 
     */
    private BigDecimal residue;
}
