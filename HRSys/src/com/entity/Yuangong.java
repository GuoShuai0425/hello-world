package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="yuangong")
public class Yuangong implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="attendld")
	private Integer attendld;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="staffName")
	private String staffName;
	
	@ManyToOne( cascade = {CascadeType.PERSIST,CascadeType.MERGE} )
    @JoinColumn(name="deptld")
	private Bumen bm;
	
	@Column(name="attendDate")
	private Date attendDate;
	
	@Column(name="attendIn")
	private String attendIn;
	
	@Column(name="attendOut")
	private String attendOut;
	
	@Column(name="remark")
	private String remark;

	public Integer getAttendld() {
		return attendld;
	}

	public void setAttendld(Integer attendld) {
		this.attendld = attendld;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Bumen getBm() {
		return bm;
	}

	public void setBm(Bumen bm) {
		this.bm = bm;
	}

	public Date getAttendDate() {
		return attendDate;
	}

	public void setAttendDate(Date attendDate) {
		this.attendDate = attendDate;
	}

	public String getAttendIn() {
		return attendIn;
	}

	public void setAttendIn(String attendIn) {
		this.attendIn = attendIn;
	}

	public String getAttendOut() {
		return attendOut;
	}

	public void setAttendOut(String attendOut) {
		this.attendOut = attendOut;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
