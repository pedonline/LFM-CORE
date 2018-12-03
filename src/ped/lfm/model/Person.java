package ped.lfm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.bson.types.ObjectId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Indexed;

import com.plw.util.Common;

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
	
	@Version
	@Column(name = "Version")
	private Integer Version;
	private Integer DataStatus;
	private Date CreateTime;
	private String CreateUser;
	private Date ModifyTime;
	private String ModifyUser;
	private Date DeletedTime;
	private String DeletedUser;
	private Integer OwnerSUID;
	private Integer OwnerSGID;
	
	public Person() {
		this.DataStatus = -1;
		this.CreateTime = Common.GetCurrTime();
		this.CreateUser = "System User";
		this.ModifyTime = Common.GetCurrTime();
		this.ModifyUser = "System User";
		this.DeletedTime = null;
		this.DeletedUser = null;
		this.OwnerSUID = -1;
		this.OwnerSGID = -1;
		this.Version = null;
	}	
	
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
	
	public Integer getVersion() {
		return Version;
	}

	public void setVersion(Integer version) {
		Version = version;
	}

	public Integer getDataStatus() {
		return DataStatus;
	}

	public void setDataStatus(Integer dataStatus) {
		DataStatus = dataStatus;
	}

	public Date getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}

	public String getCreateUser() {
		return CreateUser;
	}

	public void setCreateUser(String createUser) {
		CreateUser = createUser;
	}

	public Date getModifyTime() {
		return ModifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		ModifyTime = modifyTime;
	}

	public String getModifyUser() {
		return ModifyUser;
	}

	public void setModifyUser(String modifyUser) {
		ModifyUser = modifyUser;
	}

	public Date getDeletedTime() {
		return DeletedTime;
	}

	public void setDeletedTime(Date deletedTime) {
		DeletedTime = deletedTime;
	}

	public String getDeletedUser() {
		return DeletedUser;
	}

	public void setDeletedUser(String deletedUser) {
		DeletedUser = deletedUser;
	}

	public Integer getOwnerSUID() {
		return OwnerSUID;
	}

	public void setOwnerSUID(Integer ownerSUID) {
		OwnerSUID = ownerSUID;
	}

	public Integer getOwnerSGID() {
		return OwnerSGID;
	}

	public void setOwnerSGID(Integer ownerSGID) {
		OwnerSGID = ownerSGID;
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
		builder.append(", Version=");
		builder.append(Version);
		builder.append(", DataStatus=");
		builder.append(DataStatus);
		builder.append(", CreateTime=");
		builder.append(CreateTime);
		builder.append(", CreateUser=");
		builder.append(CreateUser);
		builder.append(", ModifyTime=");
		builder.append(ModifyTime);
		builder.append(", ModifyUser=");
		builder.append(ModifyUser);
		builder.append(", DeletedTime=");
		builder.append(DeletedTime);
		builder.append(", DeletedUser=");
		builder.append(DeletedUser);
		builder.append(", OwnerSUID=");
		builder.append(OwnerSUID);
		builder.append(", OwnerSGID=");
		builder.append(OwnerSGID);
		builder.append("]");
		return builder.toString();
	}

	

}
