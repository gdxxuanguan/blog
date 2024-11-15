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
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章id
     */
    private String articleId;

    private String userId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 发布时间
     */
    private LocalDateTime articleAddTime;

    /**
     * 内容
     */
    private String articleContext;

    /**
     * 点赞数
     */
    private Integer articleLikes;

    /**
     * 观看数
     */
    private Integer articleLooks;

    /**
     * 收藏数
     */
    private Integer articleColletions;


}
