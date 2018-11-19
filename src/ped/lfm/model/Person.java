package ped.lfm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.bson.types.ObjectId;

@Entity
@Table(name = "Person")
public class Person implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId PersonID;
	private String PersonCode;
	private String FirstName;
	private String LastName;
	private String GenderType;
	private String Nationality;
	private String NationalityFullName;
	private Integer Marital;
	private Date BirthDate;
	public ObjectId getPersonID() {
		return PersonID;
	}
	public void setPersonID(ObjectId personID) {
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
