package com.ddsc.km.lab.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.ddsc.core.entity.BaseEntity;

/**
 * <table>
 * <tr>
 * <th>版本</th>
 * <th>日期</th>
 * <th>詳細說明</th>
 * <th>modifier</th>
 * </tr>
 * <tr>
 * <td>1.0</td>
 * <td>2017/7/6</td>
 * <td>新建檔案</td>
 * <td>"keyman"</td>
 * </tr>
 * </table>
 * @author "keyman"
 *
 * 類別說明 :
 *
 *
 * 版權所有 Copyright 2008 © 中菲電腦股份有限公司 本網站內容享有著作權，禁止侵害，違者必究。 <br>
 * (C) Copyright Dimerco Data System Corporation Inc., Ltd. 2009 All Rights
 */

@Entity
@Table(name = "LAB_CUST_MST")
@NamedQuery(name = "findLabCustMst", query = "Select o.custId, o.custName, o.custStatus From LabCustMst o Where o.custId = :custId order by o.custId ")
public class LabCustMst extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -5761965285579289449L;
	
	private String custId;
	private String custName;
	private String custTel;
	private String custAddress;
	private String birthDate;
	private String custLevel;
	private String custStatus;
	
	@Id
	@Column(name = "CUST_ID")
	public String getCustId() {
		return custId;
	}
	
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	@Column(name = "CUST_NAME")
	public String getCustName() {
		return custName;
	}
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	@Column(name = "CUST_TEL")
	public String getCustTel() {
		return custTel;
	}
	
	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}
	
	@Column(name = "CUST_ADDRESS")
	public String getCustAddress() {
		return custAddress;
	}
	
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	
	@Column(name = "BIRTH_DATE")
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	@Column(name = "CUST_LEVEL")
	public String getCustLevel() {
		return custLevel;
	}
	
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	
	@Column(name = "CUST_STATUS")
	public String getCustStatus() {
		return custStatus;
	}
	
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	
}
