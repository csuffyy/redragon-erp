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
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
request.setAttribute("decorator", "none");
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
%>

<%-- 导入面包屑 --%>
<jsp:include page="../common/nav.jsp"></jsp:include>

<div class="wrapper wrapper-content animated fadeInRight">

	<%-- 导入提示信息框 --%>
	<c:if test="${requestScope.hints!=null&&requestScope.hints!=''}">
		<jsp:include page="../common/alert/alert.jsp">
			<jsp:param value="hint" name="alertType"/>
			<jsp:param value="${fn:replace(requestScope.hints,';', '<br/>')}" name="alertMessage"/>
		</jsp:include>
	</c:if>

	<div class="row">
		<div class="col-lg-12">
			<div class="ibox ">
				<div class="ibox-title">
					<h4>角色编辑</h4>
					<div class="ibox-tools">
					</div>
				</div>

				<div class="ibox-content">
					<form action="web/sysRole/editSysRole" method="post">
					
						<div class="form-group  row">
							<label class="col-sm-2 col-form-label"><span class="text-danger">*</span>角色编码</label>
							<div class="col-sm-10">
								<input id="roleCode" name="roleCode" type="text" class="form-control" value="${requestScope.sysRole.roleCode}">
							</div>
						</div>
						<div class="hr-line-dashed"></div>

						<div class="form-group row">
							<label class="col-sm-2 col-form-label"><span class="text-danger">*</span>角色名称</label>
							<div class="col-sm-10">
								<input name="roleName" type="text" class="form-control" value="${requestScope.sysRole.roleName}">
							</div>
						</div>
						<div class="hr-line-dashed"></div>
						
						<div class="form-group row">
	                        <label class="col-sm-2 col-form-label"><span class="text-danger">*</span>状态</label>
	
	                        <div class="col-sm-10">
	                        <select class="form-control m-b" name="status" id="status">
	                            <option value="Y" selected="selected">有效</option>
	                            <option value="N">无效</option>
	                        </select>
	                        </div>
	                    </div>
	                    <div class="hr-line-dashed"></div>

						<div class="form-group row">
							<div class="col-sm-12 col-sm-offset-2 text-right">
								<button class="btn btn-white btn-lg" type="button" onclick="window.location.href='web/sysRole/getSysRoleList'">返回</button>&nbsp;
								<button class="ladda-button ladda-button-demo btn btn-primary btn-lg" data-style="expand-right">&nbsp;&nbsp;确定&nbsp;&nbsp;<i class="fa fa-check-square-o"></i></button>
							</div>
						</div>
						
						<input type="hidden" name="roleId" value="${requestScope.sysRole.roleId}">
						<input type="hidden" name="createdDate" value="${requestScope.sysRole.createdDate}">
						<input type="hidden" name="createdBy" value="${requestScope.sysRole.createdBy}">
					</form>
				</div>
			</div>
		</div>
	</div>
</div>


<script>
	$(document).ready(function() {
		//初始化status
		if("${requestScope.sysRole.status}"!=""){
			$("#status").val("${requestScope.sysRole.status}");
		}
		//初始化roleCode只读
		if("${requestScope.sysRole.roleCode}"!=""){
			$("#roleCode").prop("readonly", true);
		}
	
		var l = $('.ladda-button-demo').ladda();

		l.click(function() {
			$("form").valid();
			//l.ladda('stop');
		});

		$("form").validate({
			rules : {
				roleCode : {
					required : true,
				},
				roleName : {
					required : true,
				}
			},
			submitHandler: function(form) {
				l.ladda('start');
		        form.submit();
		    }
		});
	});
</script>