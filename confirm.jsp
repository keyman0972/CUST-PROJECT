<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/include/include.Taglib.jsp"%>
<html>
<head>
<title></title>
<base target="_self" />
<s:include value="/WEB-INF/pages/include/include.Scripts.jsp" />
<script type="text/javascript" src="<s:url value="/jquery/ui/jquery.ui.datepicker.min.js"/>"></script>
<script type="text/javascript">
</script>
</head>
<body>
<s:form method="post" theme="simple" action="%{progAction}" >
	<s:hidden name="labCustMst.ver" />
	<div class="progTitle">
		<s:include value="/WEB-INF/pages/include/include.ConfirmTitle.jsp" />
	</div>
	<div id="tb">
	<div>
		<table width="100%" border="0" cellpadding="4" cellspacing="0">
			<tr class="trBgOdd">
				<td width="20%" class="colNameAlign required">*<s:text name="custId"/>：</td>
				<td width="30%">
					<label>
						<s:property value="labCustMst.custId"/>
						<s:hidden name="labCustMst.custId" />
					</label>
				</td>					
				<td width="20%" class="colNameAlign required">*<s:text name="custName"/>：</td>		
				<td width="30%">
					<label>
						<s:property value="labCustMst.custName"/>
						<s:hidden name="labCustMst.custName" />
					</label>
				</td>
			</tr>
			<tr class="trBgEven">
				<td width="20%" class="colNameAlign required">*<s:text name="custTel"/>：</td>
				<td width="30%">
					<label>
						<s:property value="labCustMst.custTel"/>
						<s:hidden name="labCustMst.custTel" />
					</label>
				</td>
				<td width="20%" class="colNameAlign">&nbsp;<s:text name="birthDate"/>：</td>
				<td width="30%">
					<label>
						<s:property value="labCustMst.birthDate"/>
						<s:hidden name="labCustMst.birthDate" />
					</label>
				</td>
			</tr>
			<tr class="trBgOdd">
				<td width="20%" class="colNameAlign required">*<s:text name="custAddress"/>：</td>
				<td width="30%">
					<label>
						<s:property value="labCustMst.custAddress"/>
						<s:hidden name="labCustMst.custAddress" />
					</label>
				</td>
			</tr>
			<tr class="trBgEven">
				<td width="20%" class="colNameAlign required">*<s:text name="custLevel"/>：</td>
				<td width="30%">
					<label>
						<input type="radio" id="custLevel0" name="labCustMst.custLevel" value="%{labCustMst.custLevel}" disabled <s:if test='labCustMst.custLevel =="0"'>checked</s:if> /><s:text name="custLevel.0" />
						<input type="radio" id="custLevel1" name="labCustMst.custLevel" value="%{labCustMst.custLevel}" disabled <s:if test='labCustMst.custLevel =="1"'>checked</s:if> /><s:text name="custLevel.1" />
						<input type="radio" id="custLevel2" name="labCustMst.custLevel" value="%{labCustMst.custLevel}" disabled <s:if test='labCustMst.custLevel =="2"'>checked</s:if> /><s:text name="custLevel.2" />
						<s:hidden name="labCustMst.custLevel"></s:hidden>
					</label>
				</td>
				<td width="20%" class="colNameAlign required">*<s:text name="custStatus"/>：</td>
				<td width="30%">
					<label>
						<input type="radio" id="custLevel0" name="labCustMst.custStatus" value="%{labCustMst.custStatus}" disabled <s:if test='labCustMst.custStatus =="0"'>checked</s:if> /><s:text name="custStatus.0" />
						<input type="radio" id="custLevel1" name="labCustMst.custStatus" value="%{labCustMst.custStatus}" disabled <s:if test='labCustMst.custStatus =="1"'>checked</s:if> /><s:text name="custStatus.1" />
						<s:hidden name="labCustMst.custStatus"></s:hidden>
					</label>
				</td>
			</tr>
		</table>
	</div>
	</div>
	<br>
	<!-- 按鍵組合 --> 
	<s:include value="/WEB-INF/pages/include/include.ConfirmButton.jsp" />
	<!-- 按鍵組合 -->
</s:form>
</body>
</html>