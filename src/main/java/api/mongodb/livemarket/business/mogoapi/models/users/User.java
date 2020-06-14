package api.mongodb.livemarket.business.mogoapi.models.users;



import api.mongodb.livemarket.business.mogoapi.models.AuditModel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Document(collection = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AuditModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String username;

    @NotBlank
    @Size(max = 2048)
    private String password;

    private Boolean enabled;
    private String firstName;
    private String lastName;


    private String resetToken;




    private String email;


    @DBRef
    private Set<Role> roles = new HashSet<>();



}
