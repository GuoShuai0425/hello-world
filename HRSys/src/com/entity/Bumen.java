package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bumen")
public class Bumen implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="deptld")
	private Integer deptld;
	
	@Column(name="deptName")
	private String deptName;

	public Integer getDeptld() {
		return deptld;
	}

	public void setDeptld(Integer deptld) {
		this.deptld = deptld;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
