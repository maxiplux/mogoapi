package api.mongodb.livemarket.business.mogoapi.models.users;

import api.mongodb.livemarket.business.mogoapi.models.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "roles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AuditModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private String  id;
    private String name;

}
