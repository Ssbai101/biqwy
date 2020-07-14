<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="admin_menu.jsp" %>
<!-- 用户添加 界面-->  
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list">
            <i class="icon-font"></i><a href="/biqwy/manage/admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;</span>
            <a class="crumb-name" href="/jscss/admin/design/">管理员信息</a><span class="crumb-step">&gt;</span>
            <span>修改信息</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/biqwy/manage/admin_douserupdate" method="post" id="myform" name="myform" >
                    <input type="hidden" name="userstatus" value="${user.status}">
                    <input type="hidden" name="cpage" value="${cpage}">
                                      
                    <table class="insert-tab" width="100%">
                        <tbody>

                            <tr>
                                <th><i class="require-red">*</i>id：</th>
                                <td> <input class="common-text required" id="title" name="username" size="50" value="${user.id}" type="text"> </td>
                               </tr>
                            <tr>
                                <th>用户名：</th>
                                <td><input class="common-text" name="name" size="50" value="${user.name }" type="text"></td>
                            </tr>
                            <tr>
                                <th>密码：</th>
                                <td><input class="common-text" name="password" size="50" value="${user.password }" type="text"></td>
                            </tr>
                            <tr>
                               <th>性别：</th>
                            <td>
                               <input type="radio" name="sex" value="T"${user.sex=='T'?"checked":"" }>男
                               <input type="radio" name="sex" value="F"${user.sex=='F'?"checked":"" } >女                      
                            </td>
                            </tr>
                            <tr>
                                <th>地址：</th>
                                <td><input class="common-text" name="addr" size="50" value="${user.addr }" type="text"></td>
                            </t>
                            
                            <tr>
                                <th>备注：</th>
                                <td><textarea name="memo" class="common-textarea" id="content" cols="30" style="width: 98%;" rows="10"></textarea></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>