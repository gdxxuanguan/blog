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
public class CommentReply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回复ID
     */
    private String commentReplyId;

    /**
     * 评论ID
     */
    private String commentId;

    /**
     * 回复人ID
     */
    private String replyUserId;

    /**
     * 继续回复人id
     */
    private String secondUserId;

    /**
     * 回复时间
     */
    private LocalDateTime commentReplyTime;


}
