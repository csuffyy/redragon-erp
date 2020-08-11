<%--

	Copyright 2020-2021 redragon.dongbin

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

      https://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
	
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<div class="modal" id="addBankDiv" tabindex="-1" role="dialog" aria-hidden="true">

	<div class="modal-dialog" role="document">

		<div class="modal-content animated bounceInRight">

			<div class="modal-header">
				<h4 class="modal-title">银行编辑</h4>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			</div>

			<div class="modal-body" style="padding-bottom: 20px;">
				<%-- 导入提示信息框 --%>
				<c:if test="${requestScope.hints!=null&&requestScope.hints!=''}">
					<jsp:include page="../../common/alert/alert.jsp">
						<jsp:param value="hint" name="alertType"/>
						<jsp:param value="${fn:replace(requestScope.hints,';', '<br/>')}" name="alertMessage"/>
					</jsp:include>
				</c:if>
			
				<form id="bform">
					<div class="form-group row">
						<label class="col-sm-3 col-form-label"><span class="text-danger">*</span>银行编码</label>
						<div class="col-sm-9">
							<select class="form-control" name="bankCode" id="bankCode">
	                        	<option value="" selected="selected">请选择...</option>
	                        	<c:forEach items="${requestScope.bankMap}" var="bank">
	                        		<option value="${bank.key}">${bank.value}</option>
	                        	</c:forEach>
	                        </select>
						</div>
					</div>
					<div class="hr-line-dashed"></div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">分行名称</label>
						<div class="col-sm-9">
							<input id="subBankCode" name="subBankCode" type="text" class="form-control" value="${requestScope.mdCustomerBank.subBankCode}">
						</div>
					</div>
					<div class="hr-line-dashed"></div>
					
					<div class="form-group row">
						<label class="col-sm-3 col-form-label"><span class="text-danger">*</span>银行账户</label>
						<div class="col-sm-9">
							<input id="bankAccount" name="bankAccount" type="text" class="form-control" value="${requestScope.mdCustomerBank.bankAccount}">
						</div>
					</div>
					<div class="hr-line-dashed"></div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label"><span class="text-danger">*</span>状态</label>

						<div class="col-sm-9">
							<select class="form-control m-b" name="status" id="status">
								<option value="Y" selected="selected">有效</option>
								<option value="N">无效</option>
							</select>
						</div>
					</div>
					<div class="hr-line-dashed"></div>

					<div class="form-group row m-b-none">
						<div class="col-sm-12 col-sm-offset-2 text-right">
							<button class="btn btn-white btn-lg" type="button"
								data-dismiss="modal">返回</button>
							&nbsp;
							<button
								class="ladda-button ladda-button-demo btn btn-primary btn-lg"
								data-style="expand-right">
								&nbsp;&nbsp;确定&nbsp;&nbsp;<i class="fa fa-check-square-o"></i>
							</button>
						</div>
					</div>
					
					<input type="hidden" id="customerCode" name="customerCode" value="${param.customerCode}"> 
					<input type="hidden" id="bankId" name="bankId" value="${requestScope.mdCustomerBank.bankId}"> 
					<input type="hidden" id="createdDate" name="createdDate" value="${requestScope.mdCustomerBank.createdDate}"> 
					<input type="hidden" id="createdBy" name="createdBy" value="${requestScope.mdCustomerBank.createdBy}">
				</form>
			</div>

		</div>

	</div>

</div>

<script>
	$(document).ready(function() {
		//初始化status
		if("${requestScope.mdCustomerBank.status}"!=""){
			$("#status").val("${requestScope.mdCustomerBank.status}");
		}
		//初始化bankCode
		if("${requestScope.mdCustomerBank.bankCode}"!=""){
			$("#bankCode").val("${requestScope.mdCustomerBank.bankCode}");
		}
		
		var l = $('.ladda-button-demo').ladda();

		l.click(function() {
			$("#bform").valid();
			//l.ladda('stop');
		});

		$("#bform").validate({
			rules : {
				bankCode : {
					required : true,
				},
				bankAccount : {
					required : true,
				}
			},
			submitHandler: function(form) {
				l.ladda('start');
				editBank();
		    }
		});
		
	});
	
	//异步编辑联系人
	function editBank(){
		redragonJS.loading("tabDiv");
	
		$.ajax({
			type: "post",
			url: "web/mdCustomerBank/editMdCustomerBank",
			data: JSON.stringify({"bankCode": $("#bankCode").val(), "subBankCode": $("#subBankCode").val(), "bankAccount": $("#bankAccount").val(), 
								"status": $("#status").val(), "bankId": $("#bankId").val(), "createdDate": $("#createdDate").val(), "createdBy": $("#createdBy").val(), 
								"customerCode": $("#customerCode").val()}),
			async: false,
			dataType: "html",
			contentType: "application/json",
			cache: false,
			success: function(data){
				redragonJS.removeLoading("tabDiv");
				$('#addBankDiv').modal('hide');
				$('.ladda-button-demo').ladda('stop');
				
				var json = JSON.parse(data);
				if(json.result=="success"){
					getBankTab($("#customerCode").val());
				}else{
					redragonJS.alert("编辑银行错误");
				}
				
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				redragonJS.alert(textStatus);
			}
		});
	}
</script>
