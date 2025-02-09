package ca.sheridancollege.wangyana.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private Long custId;
	private String custName;
	private String custAddress;
	private String custRegion;
	private String custCountry;

}
