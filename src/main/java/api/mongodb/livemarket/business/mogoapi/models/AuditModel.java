package api.mongodb.livemarket.business.mogoapi.models;

/**
 * User: franc
 * Date: 09/09/2018
 * Time: 4:14
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
@Data
public   class AuditModel implements Serializable, AuditorAware<String> {

    @CreatedDate
    private LocalDateTime createdAt;



    @Override
    public Optional<String> getCurrentAuditor() {

        // get your user name here
        String uname="admin";
        try {
            uname = SecurityContextHolder.getContext().getAuthentication().getName();
        }
        catch (Exception ex){
        }

        return Optional.of(uname);

    }

    @LastModifiedDate
    private LocalDateTime updatedAt;

    // Getters and Setters (Omitted for brevity)


    public AuditModel() {
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        if (this.createdAt == null)
        {
            this.createdAt = LocalDateTime.now();

        }

    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        if (updatedAt == null)
        {
            this.updatedAt = LocalDateTime.now();

        }

    }


}
