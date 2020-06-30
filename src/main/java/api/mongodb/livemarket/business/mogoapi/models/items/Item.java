package api.mongodb.livemarket.business.mogoapi.models.items;

import api.mongodb.livemarket.business.mogoapi.models.AuditModel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Item extends AuditModel {

    @Id
    private String id;

    @NotBlank
    private String name;

    private Category category;




    @Min(value = 0)
    private Double quality;

    @Min(value = 1)
    private Double price;


    private String picture;

    public Double getPriceWithTaxes() {
        return this.price;
    }
}
