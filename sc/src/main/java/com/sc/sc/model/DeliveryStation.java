package com.sc.sc.model;
import jakarta.persistence.*;

@Entity
@Table(name = "DeliveryStation")
public class DeliveryStation {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String Location;

	// Getters
	public Long getId() {
		return id;
	}

	public String Location() {
		return Location;
	}
	//setters
    public void setId(Long id) {
		this.id = id;
	}

	public void setLocation(String Location) {
		this.Location = Location;
	}
}
