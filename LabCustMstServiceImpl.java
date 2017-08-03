package com.ddsc.km.lab.service.impl;

import java.util.List;
import java.util.Map;

import com.ddsc.core.entity.UserInfo;
import com.ddsc.core.exception.DdscApplicationException;
import com.ddsc.core.util.Pager;
import com.ddsc.km.lab.dao.ILabCustMstDao;
import com.ddsc.km.lab.entity.LabCustMst;
import com.ddsc.km.lab.service.ILabCustMstService;

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

public class LabCustMstServiceImpl implements ILabCustMstService {
	
	private ILabCustMstDao labCustMstDao;
	
	@Override
	public LabCustMst create(LabCustMst entity, UserInfo info) throws DdscApplicationException {
		try{		
			labCustMstDao.save(entity, info);
			return entity;
		} catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, info);
		}
	}

	@Override
	public LabCustMst update(LabCustMst entity, UserInfo info) throws DdscApplicationException {
		try{
			return labCustMstDao.update(entity, info);
		} catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, info);
		}
	}

	@Override
	public LabCustMst delete(LabCustMst entity, UserInfo info) throws DdscApplicationException {
		try {
			labCustMstDao.delete(entity, info);
			return entity;
		} catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, info);
		}
	}
	
	@Override
	public LabCustMst get(String id, UserInfo info) throws DdscApplicationException {
		try{	
			return this.labCustMstDao.get(id, info);
		} catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, info);
		}
	}

	@Override
	public List<LabCustMst> searchAll(UserInfo info) throws DdscApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager searchByConditions(Map<String, Object> conditions, Pager pager, UserInfo userInfo) throws DdscApplicationException {
		try{
			Pager resultPager = labCustMstDao.searchByConditions(conditions, pager, userInfo);
			return resultPager;
			
		} catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, userInfo);
		}
	}

	@Override
	public List<LabCustMst> searchByConditions(Map<String, Object> conditions, UserInfo userInfo) throws DdscApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> queryDataByParamsByService( Map<String, Object> conditions, UserInfo userInfo) throws DdscApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDataRowCountByConditions(Map<String, Object> conditions, UserInfo info) throws DdscApplicationException {
		try{
			return this.labCustMstDao.getDataRowCountByConditions(conditions, info);
		} catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, info);
		}
	}

	public ILabCustMstDao getLabCustMstDao() {
		return labCustMstDao;
	}

	public void setLabCustMstDao(ILabCustMstDao labCustMstDao) {
		this.labCustMstDao = labCustMstDao;
	}
}
