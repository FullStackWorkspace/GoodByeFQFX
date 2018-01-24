package cn.fqfx.GoodByeFQFX.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;

/**
 * 带有创建更新时间戳信息的pojo抽象类
 *
 * @author wjh
 */
@MappedSuperclass
public abstract class AbstractTickPojo {

    /**
     * 创建时间
     */
    @Column(name = "gmt_create", nullable = false, updatable = false)
    protected Timestamp gmtCreate;

    /**
     * 更新时间
     */
    @Column(name = "gmt_modified", nullable = false)
    protected Timestamp gmtModified;

    @PrePersist
    private void beforeSave() {
        this.gmtCreate = new Timestamp(System.currentTimeMillis());
        this.gmtModified = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    private void beforeUpdate() {
        this.gmtModified = new Timestamp(System.currentTimeMillis());
    }

    public AbstractTickPojo() {
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }
}
