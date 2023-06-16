package ws.tecnologia.gds.data.v1;



import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"id", "name", "rg", "cpf", "street", "number", "neighborhood", "zip_code", "city", "state"})
public class CustomerValueObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Mapping("id")
	@JsonProperty("id")
	private Long id;
	
	private String name;
	private String rg;
	private String cpf;
	
	@JsonProperty("street")
	private String streetAddress;
	
	@JsonProperty("number")
	private String numberAddress;
	private String neighborhood;
	
	@JsonProperty("zip_code")
	private String zipCodeAddress;
	
	@JsonProperty("city")
	private String cityAddress;
	
	@JsonProperty("state")
	private String stateAddress;
	
	public CustomerValueObject() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getNumberAddress() {
		return numberAddress;
	}

	public void setNumberAddress(String numberAddress) {
		this.numberAddress = numberAddress;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getZipCodeAddress() {
		return zipCodeAddress;
	}

	public void setZipCodeAddress(String zipCodeAddress) {
		this.zipCodeAddress = zipCodeAddress;
	}

	public String getCityAddress() {
		return cityAddress;
	}

	public void setCityAddress(String cityAddress) {
		this.cityAddress = cityAddress;
	}

	public String getStateAddress() {
		return stateAddress;
	}

	public void setStateAddress(String stateAddress) {
		this.stateAddress = stateAddress;
	}

}
