package com.ddsc.km.lab.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ddsc.core.action.AbstractAction;
import com.ddsc.core.action.IBaseAction;
import com.ddsc.core.exception.DdscApplicationException;
import com.ddsc.core.exception.DdscAuthException;
import com.ddsc.core.util.Pager;
import com.ddsc.km.lab.entity.LabCustMst;
import com.ddsc.km.lab.entity.LabSuppMst;
import com.ddsc.km.lab.service.ILabCustMstService;
import com.ddsc.km.lab.service.impl.LabCustMstServiceImpl;

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

public class Lab01003KAction extends AbstractAction implements IBaseAction {

	private ILabCustMstService labCustMstService;
	private List<LabCustMst> labCustMstList;
	private LabCustMst labCustMst;
	
	private List<String> custLevelList;
	private List<String> custStatusList;
	
	@Override
	public String init() throws Exception {
		try {
		} 
		catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()),e.getMsgFullMessage() }));
		}
		setNextAction(ACTION_SEARCH);
		return SUCCESS;
	}

	@Override
	public String create() throws Exception {
		try {
		}
		catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
		setNextAction(ACTION_CREATE_SUBMIT);
		return SUCCESS;
	}

	@Override
	public String createSubmit() throws Exception {
		try {
			if (this.hasConfirm() == true) {
				// 有確認頁
				setNextAction(ACTION_CREATE_CONFIRM);
				return RESULT_CONFIRM;
			}
			else {
				// 沒有確認頁, 直接存檔
				return this.createConfirm();
			}
		}catch (DdscApplicationException e) {
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
			return RESULT_EDIT;
		}catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
			return RESULT_EDIT;
		}
	}

	@Override
	public String createConfirm() throws Exception {
		try{
			labCustMst = getLabCustMstService().create(labCustMst, getUserInfo());
			setNextAction(ACTION_CREATE);
			return RESULT_SHOW;
		}catch (DdscApplicationException e) {
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
			setNextAction(ACTION_CREATE_SUBMIT);
			return RESULT_EDIT;
		}catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
			setNextAction(ACTION_CREATE_SUBMIT);
			return RESULT_EDIT;
		}
	}

	@Override
	public String update() throws Exception {
		try{
			labCustMst = getLabCustMstService().get(labCustMst.getCustId(),  this.getUserInfo());
		}catch (DdscApplicationException e) {
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
		setNextAction(ACTION_UPDATE_SUBMIT);
		return SUCCESS;
	}

	@Override
	public String updateSubmit() throws Exception {
		try {
			if (hasConfirm()) {
				setNextAction(ACTION_UPDATE_CONFIRM);
				return RESULT_CONFIRM;
			}else {
				return this.updateConfirm();
			}
		}catch (DdscApplicationException e) {
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
			setNextAction(ACTION_UPDATE_SUBMIT);
			return RESULT_EDIT;
		}catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
			setNextAction(ACTION_UPDATE_SUBMIT);
			return RESULT_EDIT;
		}
	}

	@Override
	public String updateConfirm() throws Exception {
		try{
			labCustMst = getLabCustMstService().update(labCustMst, getUserInfo());
			setNextAction(ACTION_UPDATE);
			return RESULT_SHOW;
		}catch (DdscApplicationException e) {
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
			setNextAction(ACTION_UPDATE_SUBMIT);
			return RESULT_EDIT;
		}catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
			setNextAction(ACTION_UPDATE_SUBMIT);
			return RESULT_EDIT;
		}
	}

	@Override
	public String delete() throws Exception {
		try{
			labCustMst = getLabCustMstService().get(labCustMst.getCustId(),  this.getUserInfo());
		}catch (DdscApplicationException e) {
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
		setNextAction(ACTION_DELETE_CONFIRM);
		return SUCCESS;
	}

	@Override
	public String deleteConfirm() throws Exception {
		try {
			labCustMst = getLabCustMstService().delete(labCustMst, this.getUserInfo());
			setNextAction(ACTION_DELETE);
			return RESULT_SHOW;
		}catch (DdscApplicationException e) {
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
			setNextAction(ACTION_DELETE_CONFIRM);
			return RESULT_CONFIRM;
		}catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
			setNextAction(ACTION_DELETE_CONFIRM);
			return RESULT_CONFIRM;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public String search() throws Exception {
		try {
			Map<String, Object> conditions = new HashMap<String, Object>();
			conditions.put("custId", labCustMst.getCustId());
			conditions.put("custName", labCustMst.getCustName());
			conditions.put("custLevel", custLevelList);
			conditions.put("custStatus", custStatusList);
			Pager resultPager = getLabCustMstService().searchByConditions(conditions, getPager(), this.getUserInfo());
			labCustMstList = (List<LabCustMst>) resultPager.getData();
			this.setLabCustMstList(labCustMstList);
			setPager(resultPager);
			if (labCustMstList == null || labCustMstList.size() <= 0) {
				this.addActionError(this.getText("w.0001"));
			}
		} catch (DdscApplicationException e) {
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()),e.getMsgFullMessage() }));
		} catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()),e.getMsgFullMessage() }));
		}
		setNextAction(ACTION_SEARCH);
		return SUCCESS;
	}
	
	@Override
	public String query() throws Exception {
		try{
			labCustMst = getLabCustMstService().get(labCustMst.getCustId(), this.getUserInfo());		
		} catch (DdscApplicationException e) {
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()),e.getMsgFullMessage() }));
		} catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()),e.getMsgFullMessage() }));
		}
		setNextAction(ACTION_QUERY);
		return SUCCESS;
	}

	@Override
	public String copy() throws Exception {
		try {
			labCustMst = getLabCustMstService().get(labCustMst.getCustId(), this.getUserInfo());
		}catch (DdscApplicationException e) {
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
		setNextAction(ACTION_COPY_SUBMIT);
		return SUCCESS;
	}

	@Override
	public String copySubmit() throws Exception {
		try {
			if (this.hasConfirm() == true) {
				// 有確認頁
				setNextAction(ACTION_COPY_CONFIRM);
				return RESULT_CONFIRM;
			}
			else {
				// 沒有確認頁, 直接存檔
				return this.copyConfirm();
			}
		}catch (DdscApplicationException e) {
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
			setNextAction(ACTION_COPY_SUBMIT);
			return RESULT_EDIT;
		}catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
			setNextAction(ACTION_COPY_SUBMIT);
			return SUCCESS;
		}
	}

	@Override
	public String copyConfirm() throws Exception {
		try {
			labCustMst = getLabCustMstService().create(labCustMst, getUserInfo());
			setNextAction(ACTION_COPY);
			return RESULT_SHOW;
		}catch (DdscApplicationException e) {
			// 取得 SQL 錯誤碼，並依多國語系設定顯示於Message box
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
			setNextAction(ACTION_COPY_SUBMIT);
			return RESULT_EDIT;
		}catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
			setNextAction(ACTION_COPY_SUBMIT);
			return RESULT_EDIT;
		}
	}
	
	@Override
	public String approve() throws Exception {
		return null;
	}
	
	@Override
	public void validate() {
		try {
			setUpInfo();
		}
		catch (DdscAuthException e) {
			throw e;
		}
		catch (DdscApplicationException e) {
			// 取得 SQL 錯誤碼，並依多國語系設定顯示於Message box
			this.addActionError(this.getText("eP.0022", new String[] { e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage() }));
		}
		catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] { e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage() }));
		}
	}
	
	/**
	 * 檢核 - 按送出鈕(新增頁)
	 */
	public void validateCreateSubmit() {
		try {
			this.checkValidateRule();
			this.checkPrimaryKey();
		}
		catch (DdscAuthException e) {
			throw e;
		}
		catch (DdscApplicationException e) {
			// 取得 SQL 錯誤碼，並依多國語系設定顯示於Message box
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
		catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
	}

	/**
	 * 檢核 - 按確定鈕(新增頁)
	 */
	public void validateCreateConfirm() {
		// 先執行Action所對應的 validate, 再執行 validate(). (即 validateCreateSubmit 執行完後, 再執行 validate())
		try {
			this.checkValidateRule();
			this.checkPrimaryKey();
		}
		catch (DdscAuthException e) {
			throw e;
		}
		catch (DdscApplicationException e) {
			// 取得 SQL 錯誤碼，並依多國語系設定顯示於Message box
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
		catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
	}

	/**
	 * 檢核 - 按送出鈕(新增頁)
	 */
	public void validateUpdateSubmit() {
		try {
			this.checkValidateRule();
		}
		catch (DdscAuthException e) {
			throw e;
		}
		catch (DdscApplicationException e) {
			// 取得 SQL 錯誤碼，並依多國語系設定顯示於Message box
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
		catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
	}

	/**
	 * 檢核 - 按確定鈕(新增頁)
	 */
	public void validateUpdateConfirm() {
		// 先執行Action所對應的 validate, 再執行 validate(). (即 validateCreateSubmit 執行完後, 再執行 validate())
		try {
			this.checkValidateRule();
		}catch (DdscAuthException e) {
			throw e;
		}
		catch (DdscApplicationException e) {
			// 取得 SQL 錯誤碼，並依多國語系設定顯示於Message box
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
	}


	/**
	 * 檢核 - 按送出鈕(複製頁)
	 */
	public void validateCopySubmit() {
		// 先執行Action所對應的 validate, 再執行 validate(). (即 validateCreateSubmit 執行完後, 再執行 validate())
		try {
			this.checkPrimaryKey();
		}
		catch (DdscAuthException e) {
			throw e;
		}
		catch (DdscApplicationException e) {
			// 取得 SQL 錯誤碼，並依多國語系設定顯示於Message box
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
		catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
	}

	/**
	 * 檢核 - 按確定鈕(複製頁)
	 */
	public void validateCopyConfirm() {
		// 先執行Action所對應的 validate, 再執行 validate(). (即 validateCreateSubmit 執行完後, 再執行 validate())
		try {
			this.checkPrimaryKey();
		}
		catch (DdscAuthException e) {
			throw e;
		}
		catch (DdscApplicationException e) {
			// 取得 SQL 錯誤碼，並依多國語系設定顯示於Message box
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
		catch (Exception ex) {
			DdscApplicationException e = new DdscApplicationException(ex, this.getUserInfo());
			this.addActionError(this.getText("eP.0022", new String[] {e.getMsgCode(), this.getText(e.getMsgCode()), e.getMsgFullMessage()}));
		}
	}

	/**
	 * 檢核ID是否重複
	 * 
	 * @return
	 * @throws Exception
	 */
	private boolean checkPrimaryKey() throws Exception {
		boolean isValid = true;
		
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("custId", labCustMst.getCustId());
		if (labCustMstService.getDataRowCountByConditions(conditions, this.getUserInfo()) > 0) {
			this.addFieldError("custId", this.getText("custId") + this.getText("eP.0004"));
			isValid = false;
		}

		return isValid;
	}
	
	private boolean checkValidateRule() throws Exception {
		boolean isValid = true;
		
		return isValid;
	}

	public ILabCustMstService getLabCustMstService() {
		return labCustMstService;
	}

	public void setLabCustMstService(ILabCustMstService labCustMstService) {
		this.labCustMstService = labCustMstService;
	}

	public List<LabCustMst> getLabCustMstList() {
		return labCustMstList;
	}

	public void setLabCustMstList(List<LabCustMst> labCustMstList) {
		this.labCustMstList = labCustMstList;
	}

	public LabCustMst getLabCustMst() {
		return labCustMst;
	}

	public void setLabCustMst(LabCustMst labCustMst) {
		this.labCustMst = labCustMst;
	}

	public List<String> getCustLevelList() {
		return custLevelList;
	}

	public void setCustLevelList(List<String> custLevelList) {
		this.custLevelList = custLevelList;
	}

	public List<String> getCustStatusList() {
		return custStatusList;
	}

	public void setCustStatusList(List<String> custStatusList) {
		this.custStatusList = custStatusList;
	}
}
