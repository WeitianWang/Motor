package org.motor.bss.stuff.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 员工实体类
 * @author  WeitienWong
 */
@Entity
@Table(name = "M_STUFF", schema = "MOTOR")
public class Stuff implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String organCode;
	private String job;
	private String hiredate;
	private String jobStatus;
	private String termdate;
	private String phone;
	private String tel;
	private String addr;
	private String qq;
	private String wechart;
	private String idCard;
	private Character gender;
	private String birthday;
	private String nation;
	private String nativeplace;
	private Character maritalStatus;
	private String domicilePlace;
	private String education;
	private String major;
	private String politicalStatus;

	public Stuff() {
	}

	public Stuff(String id) {
		this.id = id;
	}


	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",strategy="uuid")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ORGANCODE", length = 36)
	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	@Column(name = "JOB", length = 36)
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "HIREDATE", length = 10)
	public String getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Column(name = "JOBSTATUS", length = 2)
	public String getJobStatus() {
		return this.jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	@Column(name = "TERMDATE", length = 10)
	public String getTermdate() {
		return this.termdate;
	}

	public void setTermdate(String termdate) {
		this.termdate = termdate;
	}

	@Column(name = "PHONE", length = 11)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "TEL", length = 13)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "ADDR", length = 100)
	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Column(name = "QQ", length = 13)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "WECHART", length = 30)
	public String getWechart() {
		return this.wechart;
	}

	public void setWechart(String wechart) {
		this.wechart = wechart;
	}

	@Column(name = "IDCARD", length = 18)
	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "GENDER", length = 1)
	public Character getGender() {
		return this.gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	@Column(name = "BIRTHDAY", length = 10)
	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column(name = "NATION", length = 10)
	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Column(name = "NATIVEPLACE", length = 30)
	public String getNativeplace() {
		return this.nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	@Column(name = "MARITALSTATUS", length = 1)
	public Character getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(Character maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Column(name = "DOMICILEPLACE", length = 30)
	public String getDomicilePlace() {
		return this.domicilePlace;
	}

	public void setDomicilePlace(String domicilePlace) {
		this.domicilePlace = domicilePlace;
	}

	@Column(name = "EDUCATION", length = 6)
	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Column(name = "MAJOR", length = 30)
	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "POLITICALSTATUS", length = 6)
	public String getPoliticalStatus() {
		return this.politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

}
