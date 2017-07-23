package com.ddsc.km.lab.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;

import com.ddsc.core.dao.hibernate.GenericDaoHibernate;
import com.ddsc.core.entity.UserInfo;
import com.ddsc.core.exception.DdscApplicationException;
import com.ddsc.core.util.HibernateScalarHelper;
import com.ddsc.core.util.Pager;
import com.ddsc.km.lab.dao.ILabCustMstDao;
import com.ddsc.km.lab.entity.LabCustMst;

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

public class LabCustMstDaoHibernate extends GenericDaoHibernate<LabCustMst,String> implements ILabCustMstDao {

	@Override
	public Pager searchByConditions(Map<String, Object> conditions, Pager pager, UserInfo userInfo) throws DdscApplicationException {
		StringBuffer sbsql= new StringBuffer();
		sbsql.append("SELECT CUST.CUST_ID, CUST.CUST_NAME, CUST.CUST_TEL, CUST.CUST_ADDRESS, CUST.BIRTH_DATE, CUST.CUST_LEVEL, CUST.CUST_STATUS ");
		sbsql.append("FROM LAB_CUST_MST CUST ");
		

		String keyword= "WHERE ";
		List<Object> value= new ArrayList<Object>();
		if(StringUtils.isNotEmpty((String)conditions.get("custId"))){
			sbsql.append(keyword+"CUST_ID LIKE ? ");
			value.add(conditions.get("custId")+"%");
			keyword="AND ";
		}
		if(StringUtils.isNotEmpty((String)conditions.get("custName"))){
			sbsql.append(keyword+"CUST_NAME LIKE ? ");
			value.add("%"+conditions.get("custName")+"%");
			keyword="AND ";
		}
//		List<String> alist = (List<String>) conditions.get("custLevel");
//		if(alist != null && !alist.isEmpty()){
//			sbsql.append(keyword + " CUST_LEVEL IN ( " + this.getSqlQuestionMark(alist.size()));
//		}
		
//		List<String> blist = (List<String>) conditions.get("custStatus");
//		if(blist != null && !blist.isEmpty()){
//			sbsql.append(keyword + " CUST_STATUS IN ( " + this.getSqlQuestionMark(blist.size()));
//		}
		if (CollectionUtils.isNotEmpty((List<String>) conditions.get("custLevel"))) {
			sbsql.append(keyword + " CUST_LEVEL IN ( ");

			for (String custLevel : (List<String>) conditions.get("custLevel")) {
				if (StringUtils.isNotEmpty(custLevel)) {
					sbsql.append(" ?, ");
					value.add(custLevel);
				}
			}
			sbsql.deleteCharAt(sbsql.lastIndexOf(","));
			sbsql.append(") ");
			keyword = " AND ";
		}
		
		if (CollectionUtils.isNotEmpty((List<String>) conditions.get("custStatus"))) {
			sbsql.append(keyword + " CUST_STATUS IN ( ");

			for (String custLevel : (List<String>) conditions.get("custStatus")) {
				if (StringUtils.isNotEmpty(custLevel)) {
					sbsql.append(" ?, ");
					value.add(custLevel);
				}
			}
			sbsql.deleteCharAt(sbsql.lastIndexOf(","));
			sbsql.append(") ");
			keyword = " AND ";
		}
		sbsql.append("ORDER BY CUST.CUST_ID ");
		//建立List<HibernateScalarHelper> scalarList = new ArrayList<HibernateScalarHelper>(); 並add
		List<HibernateScalarHelper> scalarList = new ArrayList<HibernateScalarHelper>();
		scalarList.add(new HibernateScalarHelper("CUST_ID", Hibernate.STRING));
		scalarList.add(new HibernateScalarHelper("CUST_NAME", Hibernate.STRING));
		scalarList.add(new HibernateScalarHelper("CUST_TEL", Hibernate.STRING));
		scalarList.add(new HibernateScalarHelper("CUST_ADDRESS", Hibernate.STRING));
		scalarList.add(new HibernateScalarHelper("BIRTH_DATE", Hibernate.STRING));
		scalarList.add(new HibernateScalarHelper("CUST_LEVEL", Hibernate.STRING));
		scalarList.add(new HibernateScalarHelper("CUST_STATUS", Hibernate.STRING));
		//回傳
	
		return super.findBySQLQueryMapPagination(sbsql.toString(), pager, scalarList, value, userInfo);
	}

}
