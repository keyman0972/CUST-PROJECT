<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/include/include.Taglib.jsp"%>
<html>
<head>
<title></title>
<s:include value="/WEB-INF/pages/include/include.Scripts.jsp" />
<script type="text/javascript" src="<s:url value="/jquery/jquery.alphanumeric.js"/>"></script>
<script type="text/javascript" src="<s:url value="/ddscPlugin/ddsc.gridList.plugin.js"/>"></script>
<script type="text/javascript" src="<s:url value="/ddscPlugin/ddsc.popupWindow.plugin.js"/>"></script>	
<script type="text/javascript" src="<s:url value="/js/ddsc.input.js"/>"></script>
<script type="text/javascript">
function getParameter() {
	var param = "labCustMst.custId=" + $("#tblGrid").getSelectedRow().find('td').eq(2).text();
	return param;
}

function onCheckbox(){
	var index1 = $("#checkboxOfCustLevel input").length;
	var bool1 = false;
	
	for(var i=0;i<index1;i++){
		if($("#custLevel"+i).prop("checked") == true){
			bool1=true;
		}
	}
	if(!bool1){
		for(var i=0;i<index1;i++){
			$("#custLevel"+i).prop("checked", true);
		}
	}
	var index2 = $("#checkboxOfCustStatus input").length;
	var bool2 = false;
	for(var i=0;i<index2;i++){
		if($("#custStatus"+i).prop("checked") == true){
			bool2=true;
		}
	}
	if(!bool2){
		for(var i=0;i<index2;i++){
			$("#custStatus"+i).prop("checked", true);
		}
	}
}
$(document).ready(function() {
	$("#tblGrid").initGrid({lines:3});
	$('#tb').initPopupWindow({dailogWidth:'960', dailogHeight:'640'});
	onCheckbox();
});
</script>
</head>
<body> 
<s:form id="frm01002K" theme="simple" action="%{progAction}" >
	<div class="progTitle">
  		<s:include value="/WEB-INF/pages/include/include.Title.jsp" />
	</div>
	<div id="tb">
		<fieldset id="listFieldset">
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr class="trBgOdd">
				<td width="20%" class="colNameAlign">&nbsp;<s:text name="custId"/>：</td>
				<td width="30%"><s:textfield name="labCustMst.custId" cssClass="enKey" maxlength="32" size="16"/></td>
				<td width="20%" class="colNameAlign">&nbsp;<s:text name="custName"/>：</td>
				<td width="30%"><s:textfield name="labCustMst.custName" maxlength="32" size="32"/></td>
			</tr>
			<tr class="trBgEven">
				<td width="20%" class="colNameAlign">&nbsp;<s:text name="custLevel"/>：</td>
				<td width="30%">
					<span id="checkboxOfCustLevel">
						<input type="checkbox" id="custLevel0" name="custLevelList[0]" value="0" <s:if test="custLevelList[0] ==\"0\"">checked</s:if> /><s:text name="custLevel.0" />
						<input type="checkbox" id="custLevel1" name="custLevelList[1]" value="1" <s:if test="custLevelList[1] ==\"1\"">checked</s:if> /><s:text name="custLevel.1" />
						<input type="checkbox" id="custLevel2" name="custLevelList[2]" value="2" <s:if test="custLevelList[2] ==\"2\"">checked</s:if> /><s:text name="custLevel.2" />
					</span>
				</td>
				<td width="20%" class="colNameAlign">&nbsp;<s:text name="custStatus"/>：</td>
				<td width="30%">
					<span id="checkboxOfCustStatus">
						<input type="checkbox" id="custStatus0" name="custStatusList[0]" value="0" <s:if test="custStatusList[0] ==\"0\"">checked</s:if> /><s:text name="custStatus.0" />
						<input type="checkbox" id="custStatus1" name="custStatusList[1]" value="1" <s:if test="custStatusList[1] ==\"1\"">checked</s:if> /><s:text name="custStatus.1" />
					</span>
				</td>
			</tr>
		</table>
		<!-- 按鍵組合 --><s:include value="/WEB-INF/pages/include/include.ListButton.jsp" /><!-- 按鍵組合 --> 
		</fieldset>
		<table id="tblGrid" class ="labSuppMstList" width="100%" border="0" cellpadding="2" cellspacing="1">
			<thead>
				<tr align="center" bgcolor="#e3e3e3">
					<th width="3%"><s:text name="fix.00164" /></th>
					<th width="10%"><s:text name="fix.00090" /></th>
					<th width="15%"><s:text name="custId" /></th>   
					<th width="25%"><s:text name="custName" /></th> 
					<th width="17%"><s:text name="custTel" /></th>
					<th width="15%"><s:text name="custLevel" /></th>
					<th><s:text name="custStatus" /></th>			
				</tr>
			 </thead>
			 <tbody>
				 <s:iterator value="labCustMstList" status="status">
				 	<tr>
						<td width="3%" id="sn" align="center"><s:property value="#status.index+1" /></td>
						<!-- 表單按鍵 --> 
						<td width="10%"><s:include value="/WEB-INF/pages/include/include.actionButton.jsp" /></td>
						<!-- 表單按鍵 -->
						<td width="15%"><label><s:property value="CUST_ID" /></label></td>
						<td width="25%"><label><s:property value="CUST_NAME" /></label></td>
						<td width="17%"><label><s:property value="CUST_TEL" /></label></td>	
						<td width="15%">
							<label>
								<s:if test="CUST_LEVEL == \"0\""><s:property value="CUST_LEVEL" />-<s:text name="custLevel.0" /></s:if>
								<s:elseif test="CUST_LEVEL == \"1\""><s:property value="CUST_LEVEL" />-<s:text name="custLevel.1" /></s:elseif>
								<s:elseif test="CUST_LEVEL == \"2\""><s:property value="CUST_LEVEL" />-<s:text name="custLevel.2" /></s:elseif>
							</label>
						</td>
						<td>
							<label>
								<s:if test="CUST_STATUS == \"0\""><s:property value="CUST_STATUS"/>-<s:text name="custStatus.0" /></s:if>
								<s:elseif test="CUST_STATUS ==\"1\""><s:property value="CUST_STATUS"/>-<s:text name="custStatus.1" /></s:elseif>
							</label>
						</td>
					</tr>
				 </s:iterator>
			 </tbody>
		</table>
	</div>
	<!-- 分頁按鍵列 --><s:include value="/WEB-INF/pages/include/include.PaginationBar.jsp" /><!-- 分頁按鍵列 -->
</s:form>
</body>
</html>