
package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet {


    private Boolean Complete;

    private Long Id;

    private Long PetId;

    private Integer Quantity;

    private String ShipDate;

    private String Status;




}
