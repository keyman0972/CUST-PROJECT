<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/include/include.Taglib.jsp"%>
<html>
<head>
<title></title>
<base target="_self" />
<s:include value="/WEB-INF/pages/include/include.Scripts.jsp" />
</head>
<body>
<s:form method="post" theme="simple" action="%{progAction}" >
	<s:hidden name="labCustMst.ver" />
	<div class="progTitle">
		<s:include value="/WEB-INF/pages/include/include.ShowTitle.jsp" />
	</div>
	<div id="tb">
	<div>
		<table width="100%" border="0" cellpadding="4" cellspacing="0">
			<tr class="trBgOdd">
				<td width="20%" class="colNameAlign required">*<s:text name="custId"/>：</td>
				<td width="30%">
					<s:property value="labCustMst.custId"/>
				</td>					
				<td width="20%" class="colNameAlign required">*<s:text name="custName"/>：</td>		
				<td width="30%">
					<s:property value="labCustMst.custName"/>
				</td>
			</tr>
			<tr class="trBgEven">
				<td width="20%" class="colNameAlign  required">*<s:text name="custTel"/>：</td>
				<td width="30%">
					<s:property value="labCustMst.custTel"/>
				</td>
				<td width="20%" class="colNameAlign">&nbsp;<s:text name="birthDate"/>：</td>
				<td width="30%">
					<s:property value="labCustMst.birthDate"/>
				</td>
			</tr>
			<tr class="trBgOdd">
				<td width="20%" class="colNameAlign required">*<s:text name="custAddress"/>：</td>
				<td colspan="3">
					<s:property value="labCustMst.custAddress"/>
				</td>
			</tr>
			<tr class="trBgEven">
				<td width="20%" class="colNameAlign required">*<s:text name="custLevel"/>：</td>
				<td width="30%">
					<input type="radio" id="custLevel0" name="labCustMst.custLevel" value="%{labCustMst.custLevel}" disabled <s:if test='labCustMst.custLevel =="0"'>checked</s:if> /><s:text name="custLevel.0" />
					<input type="radio" id="custLevel1" name="labCustMst.custLevel" value="%{labCustMst.custLevel}" disabled <s:if test='labCustMst.custLevel =="1"'>checked</s:if> /><s:text name="custLevel.1" />
					<input type="radio" id="custLevel2" name="labCustMst.custLevel" value="%{labCustMst.custLevel}" disabled <s:if test='labCustMst.custLevel =="2"'>checked</s:if> /><s:text name="custLevel.2" />
				</td>
				<td width="20%" class="colNameAlign required">*<s:text name="custStatus"/>：</td>
				<td width="30%">
					<input type="radio" id="custLevel0" name="labCustMst.custStatus" value="%{labCustMst.custStatus}" disabled <s:if test='labCustMst.custStatus =="0"'>checked</s:if> /><s:text name="custStatus.0" />
					<input type="radio" id="custLevel1" name="labCustMst.custStatus" value="%{labCustMst.custStatus}" disabled <s:if test='labCustMst.custStatus =="1"'>checked</s:if> /><s:text name="custStatus.1" />
				</td>
			</tr>
		</table>
	</div>
	</div>
	<br>
	<!-- 按鍵組合 --> 
	<s:include value="/WEB-INF/pages/include/include.ShowButton.jsp" />
	<!-- 按鍵組合 -->
</s:form>
</body>
</html>