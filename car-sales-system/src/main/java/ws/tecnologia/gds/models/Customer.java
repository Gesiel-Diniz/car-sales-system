package ws.tecnologia.gds.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "customers")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length = 15)
	private String rg;
	
	@Column(nullable = false, length = 20)
	private String cpf;
	
	@Column(name = "street_address", nullable = false, length = 100)
	private String streetAddress;
	
	@Column(name = "number_address", nullable = false, length = 10)
	private String numberAddress;
	@Column(name = "zip_code_address", nullable = false, length = 10)
	private String zipCodeAddress;
	
	@Column(name = "city_address", nullable = false, length = 100)
	private String cityAddress;
	
	@Column(name = "state_address", nullable = false, length = 100)
	private String stateAddress;
	
	public Customer() {}

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
