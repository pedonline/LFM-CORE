package ped.lfm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.bson.types.ObjectId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
public class Person implements Serializable{
	
	@Id
	@GeneratedValue
	private long PersonID;
	
	@Column(name="PersonCode")
	private String PersonCode;
	
	@Column(name="FirstName")
	private String FirstName;
	
	@Column(name="LastName")
	private String LastName;
	
	@Column(name="GenderType")
	private String GenderType;
	
	@Column(name="Nationality")
	private String Nationality;
	
	@Column(name="NationalityFullName")
	private String NationalityFullName;
	
	@Column(name="Marital")
	private Integer Marital;
	
	@Column(name="BirthDate")
	private Date BirthDate;
	
		
	
	public long getPersonID() {
		return PersonID;
	}
	public void setPersonID(long personID) {
		PersonID = personID;
	}
	public String getPersonCode() {
		return PersonCode;
	}
	public void setPersonCode(String personCode) {
		PersonCode = personCode;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getGenderType() {
		return GenderType;
	}
	public void setGenderType(String genderType) {
		GenderType = genderType;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public String getNationalityFullName() {
		return NationalityFullName;
	}
	public void setNationalityFullName(String nationalityFullName) {
		NationalityFullName = nationalityFullName;
	}
	public Integer getMarital() {
		return Marital;
	}
	public void setMarital(Integer marital) {
		Marital = marital;
	}
	public Date getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [PersonID=");
		builder.append(PersonID);
		builder.append(", PersonCode=");
		builder.append(PersonCode);
		builder.append(", FirstName=");
		builder.append(FirstName);
		builder.append(", LastName=");
		builder.append(LastName);
		builder.append(", GenderType=");
		builder.append(GenderType);
		builder.append(", Nationality=");
		builder.append(Nationality);
		builder.append(", NationalityFullName=");
		builder.append(NationalityFullName);
		builder.append(", Marital=");
		builder.append(Marital);
		builder.append(", BirthDate=");
		builder.append(BirthDate);
		builder.append("]");
		return builder.toString();
	}

	

}
