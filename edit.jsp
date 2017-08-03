<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/include/include.Taglib.jsp"%>
<html>
<head>
<title></title>
<base target="_self" />
<s:include value="/WEB-INF/pages/include/include.Scripts.jsp" />
<script type="text/javascript" src="<s:url value="/jquery/ui/jquery.ui.datepicker.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/jquery/jquery.alphanumeric.js"/>"></script>		
<script type="text/javascript" src="<s:url value="/ddscPlugin/ddsc.validation.plugin.js"/>"></script>
<script type="text/javascript" src="<s:url value="/js/ddsc.input.js"/>"></script>
<script language="javascript">
function validate() {
	$("#frm01003K").validate("clearPrompt");
	$("#custId").validateRequired({fieldText:'<s:text name="custId" />'});
	$("#custName").validateRequired({fieldText:'<s:text name="custName" />'});
	$("#custTel").validateRequired({fieldText:'<s:text name="custTel" />'});
	$("#birthDate").validateDate({fieldText:'<s:text name="birthDate" />'});
	$("#custAddress").validateRequired({fieldText:'<s:text name="custAddress" />'});
	$("#custLevel1").validateRequired({fieldText:'<s:text name="custLevel" />'});
	$("#custStatus1").validateRequired({fieldText:'<s:text name="custStatus" />'});
	return $("#frm01003K").validate("showPromptWithErrors");
}
</script>
</head>
<body>
<s:form id="frm01003K" method="post" theme="simple" action="%{progAction}" target="ifrConfirm">
	<s:hidden name="labCustMst.ver" />
	<div class="progTitle">
		<s:include value="/WEB-INF/pages/include/include.EditTitle.jsp" />
	</div>
	<div id="tb">
	<div>
		<table width="100%" border="0" cellpadding="4" cellspacing="0" >
			<tr class="trBgOdd">
				<td width="20%" class="colNameAlign required">*<s:text name="custId"/>：</td>
				<td width="30%">
					<s:textfield cssClass="enKey" id="custId" name="labCustMst.custId" readonly="progAction == 'updateSubmit'" size="50" maxlength="32" cssClass="enKey"/>
				</td>					
				<td width="20%" class="colNameAlign required">*<s:text name="custName"/>：</td>	
				<td width="30%">
					<s:textfield id="custName" name="labCustMst.custName" size="35" maxlength="64"/>
				</td>
			</tr>
			<tr class="trBgEven">
				<td width="20%" class="colNameAlign required">*<s:text name="custTel"/>：</td>
				<td width="30%">
					<s:textfield id="custTel" name="labCustMst.custTel" maxlength="20" size="50" cssClass="numKey" />
				</td>
				<td width="20%" class="colNameAlign">&nbsp;<s:text name="birthDate"/>：</td>
				<td>
					<s:textfield id="birthDate" name="labCustMst.birthDate" maxlength="10" size="20" cssClass="inputDate" />
				</td>
			</tr>
			<tr class="trBgOdd">
				<td width="20%" class="colNameAlign required">*<s:text name="custAddress"/>：</td>
				<td colspan="3">
					<s:textfield id="custAddress" name="labCustMst.custAddress" maxlength="128" size="120" />
				</td>
			</tr>
			<tr class="trBgEven">
				<td width="20%" class="colNameAlign required">*<s:text name="custLevel"/>：</td>
				<td width="30%">
					<input type="radio" id="custLevel0" name="labCustMst.custLevel" value="0" <s:if test='labCustMst.custLevel == "0"'>checked</s:if>/><label for="custLevel1"><s:text name="custLevel.0"/></label>
					<input type="radio" id="custLevel1" name="labCustMst.custLevel" value="1" <s:if test='labCustMst.custLevel == "1"'>checked</s:if>/><label for="custLevel2"><s:text name="custLevel.1"/></label>
					<input type="radio" id="custLevel2" name="labCustMst.custLevel" value="2" <s:if test='labCustMst.custLevel == "2"'>checked</s:if>/><label for="custLevel3"><s:text name="custLevel.2"/></label>
				</td>
				<td width="20%" class="colNameAlign required">*<s:text name="custStatus"/>：</td>
				<td width="30%">
					<input type="radio" id="custStatus0" name="labCustMst.custStatus" value="0" <s:if test='labCustMst.custStatus == "0"'>checked</s:if>/><label for="custStatus0"><s:text name="custStatus.0"/></label>
					<input type="radio" id="custStatus1" name="labCustMst.custStatus" value="1" <s:if test='custStatus == null || labCustMst.custStatus == "1"'>checked</s:if>/><label for="custStatus1"><s:text name="custStatus.1"/></label>
				</td>
			</tr>
		</table>
	</div>
	</div>
	<br>
	<!-- 按鍵組合 --> 
	<s:include value="/WEB-INF/pages/include/include.EditButton.jsp" />
	<!-- 按鍵組合 --> 
</s:form>
<iframe id="ifrConfirm" name="ifrConfirm" width="100%" height="768" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" style="display:none; border: 0px none"></iframe>
</body>
</html>