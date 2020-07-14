<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="admin_menu.jsp" %>
<!-- 用户添加 界面-->  
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_userlist.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_userinformation.jsp">业主信息</a><span class="crumb-step">&gt;</span><span>添加信息</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/jscss/admin/design/add" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>

                            <tr>
                                <th><i class="require-red">*</i>id：</th>
                                <td>
                                    <input class="common-text required" id="title" name="title" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>用户名：</th>
                                <td><input class="common-text" name="author" size="50" value="" type="text"></td>
                            </tr>
                            <tr>
                                <th>密码：</th>
                                <td><input class="common-text" name="author" size="50" value="" type="text"></td>
                            </tr>
                            <tr>
                                <th>业主编号：</th>
                                <td><input class="common-text" name="author" size="50" value="" type="text"></td>
                            </tr>
                            <tr>
                                <th>车牌号：</th>
                                <td><input class="common-text" name="author" size="50" value="" type="text"></td>
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