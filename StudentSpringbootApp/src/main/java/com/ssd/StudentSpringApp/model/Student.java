package com.ssd.StudentSpringApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer stdId;

	@NotNull(message = "Name must not be null")

	@NotBlank(message = "Name must not be blank")

	@Size(min = 2, max = 50)

	@Pattern(regexp = "[a-zA-Z]+")

	private String name;

	@NotNull(message = "Name must not be null")

	@NotBlank(message = "Name must not be blank")

	@Pattern(regexp = "^(M|F|m|f|male|female|other)$", message = "Gender must be 'male', 'female', or 'other'")

	private String gender;

	@NotNull(message = "Email must not be null")

	@NotBlank(message = "Email must not be blank")

	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}+$", message = "Invalid email format")

	@Email
	@Column(unique = true)
	private String email;

	private String standard;

	@NotNull(message = "Email must not be null")

	@NotBlank(message = "Email must not be blank")

	@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
	private String phno;
	
	@Pattern(regexp = "\\d{12}", message = "Adhar number must be 12 digits")
	private String adhar;

	public Integer getStdId() {
		return stdId;
	}

	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getAdhar() {
		return adhar;
	}

	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", name=" + name + ", gender=" + gender + ", email=" + email + ", standard="
				+ standard + ", phno=" + phno + ", adhar=" + adhar + "]";
	}

	public Student(Integer stdId, String name, String gender, String email, String standard, String phno,
			String adhar) {
		super();
		this.stdId = stdId;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.standard = standard;
		this.phno = phno;
		this.adhar = adhar;
	}

	public Student() {
		super();
	}
	

}
