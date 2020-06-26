package api.mongodb.livemarket.business.mogoapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Serializable{

	
	private static final long serialVersionUID = -2772158462042804334L;

	@Id
	private String id ;

	private double amount ;
	private String type ;
	private String creationDate; 
	private int accountId;

}
