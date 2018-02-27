package org.jabosu.common.entity;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.jabosu.common.Model;
import org.jabosu.common.SystemConfig;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Accessors(fluent = true)
public abstract class BaseModel implements Model {
    
    private static Logger logger = LoggerFactory.getLogger(BaseModel.class.getName());

    @Column(name = "created_on")
    protected long createdOn;

    @Column(name="created_by")
    protected String createdBy;

    @Column(name = "created_by_email")
    protected String createdByEmail;

    @Column(name="last_updated_on")
    protected long lastUpdatedOn;

    @Column(name = "updated_by")
    protected String updatedBy;

    @Column(name="updated_by_email")
    protected String updatedByEmail;

    @JsonIgnore
    @Transient
    public String getLastUpdatedOnDate() {

        if (lastUpdatedOn == 0) {
            return null;
        }

        String timeZone = getTimeZone();

        DateTime date = null;
        if (timeZone != null) {
            date = new DateTime(lastUpdatedOn).withZone(DateTimeZone.forID(timeZone));
        } else {
            date = new DateTime(lastUpdatedOn);
        }

        return date.toString(DateTimeFormat.forPattern(SystemConfig.getDateTimeFormat()));
    }

    @JsonIgnore
    @Transient
    public String getCreatedOnDate() {
        if (createdOn == 0) {
            return null;
        }

        String timeZone = getTimeZone();
        DateTime date = null;
        
        if (timeZone != null) {
            date = new DateTime(createdOn).withZone(DateTimeZone.forID(timeZone));
        } else {
            date = new DateTime(createdOn);
        }
        
        return date.toString(DateTimeFormat.forPattern(SystemConfig.getDateTimeFormat()));
    }

    @JsonIgnore
    @Transient
    public String getTimeZone() {
        return null;
    }
    
    @JsonIgnore
    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            logger.error("Error in converting to json in BaseModel", ex);
            return "{}";
        }
    }

    //getter setter
    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByEmail() {
        return createdByEmail;
    }

    public void setCreatedByEmail(String createdByEmail) {
        this.createdByEmail = createdByEmail;
    }

    public long getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(long lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedByEmail() {
        return updatedByEmail;
    }

    public void setUpdatedByEmail(String updatedByEmail) {
        this.updatedByEmail = updatedByEmail;
    }
}
