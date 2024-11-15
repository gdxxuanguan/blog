package com.blog.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhb
 * @since 2024-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 友情链接id
     */
    private String linkId;

    /**
     * 链接标题
     */
    private String linkTitle;

    /**
     * 链接地址
     */
    private String linkUrl;

    /**
     * 链接logo
     */
    private String linkLogoUrl;

    /**
     * 添加时间
     */
    private LocalDateTime linkAddTime;


}
