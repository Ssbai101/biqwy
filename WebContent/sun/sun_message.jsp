<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="sun_menu.jsp" %>
<!-- 用户添加 界面-->  
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">留言管理</a><span class="crumb-step">&gt;<</div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/biqwy/manage/admin_douseradd" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>

                            <tr>
                                <th><i class="require-red">*</i>id：</th>
                                <td> <input class="common-text required" id="title" name="username" size="50" value="" type="text"> </td>
                               </tr>
                            <tr>
                                <th>作者：</th>
                                <td><input class="common-text" name="name" size="50" value="" type="text"></td>
                            </tr>
                            <tr>
                                <th>标题：</th>
                                <td><input class="common-text" name="password" size="50" value="" type="text"></td>
                            </tr>                 
                            <tr>
                                <th>内容：</th>
                                <td><textarea name="memo" class="common-textarea" id="content" cols="30" style="width: 98%;" rows="10"></textarea></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="发表" type="submit">
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