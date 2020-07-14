<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="sun_menu.jsp" %>  
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户信息</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/biqwy/sun/sun_domanselect" method="get">
                    <table class="search-tab">
                        <tr>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="/biqwy/sun/sun_domanselect" id="myform" method="post">
                
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selall(this)" type="checkbox"></th>
                            <th>id</th>
                            <th>用户名</th>
                            <th>密码</th>
                            <th>性别</th>
                            <th>地址</th>
                            <th>备注</th>
                         
                        </tr>
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selall(this)" type="checkbox"></th>
                            <td>8</td>
                            <td title=""><a target="_blank" href="#" title="">小白</a> 
                            </td>
                            <td>521</td>
                            <td>女</td>
                            <td>浙江杭州</td>
                            <td></td>     
                        </tr>
                         <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selall(this)" type="checkbox"></th>
                            <td>7</td>
                            <td title=""><a target="_blank" href="#" title="">sun</a> 
                            </td>
                            <td>123</td>
                            <td>女</td>
                            <td>浙江宁波</td>
                            <td></td>     
                        </tr>
                         <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selall(this)" type="checkbox"></th>
                            <td>5</td>
                            <td title=""><a target="_blank" href="#" title="">小新</a> 
                            </td>
                            <td>222222</td>
                            <td></td>
                            <td>浙江宁波</td>
                            <td></td>     
                        </tr>
                         <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selall(this)" type="checkbox"></th>
                            <td>4</td>
                            <td title=""><a target="_blank" href="#" title="">耿伟</a> 
                            </td>
                            <td>11111</td>
                            <td>女</td>
                            <td>江苏连云港</td>
                            <td></td>     
                        </tr>
                         <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selall(this)" type="checkbox"></th>
                            <td>2</td>
                            <td title=""><a target="_blank" href="#" title="">刘庆</a> 
                            </td>
                            <td>123456</td>
                            <td>女</td>
                            <td>浙江宁波</td>
                            <td></td>     
                        </tr>
                    </table>
                    <div class="list-page">
                                                              共${tsum}条记录，当前${cpage}/${tpage}页
                        <a href="admin_douserselect?cp=1${searchParams}">首页</a> 
                        <a href="admin_douserselect?cp=${cpage-1<1?1:cpage-1}${searchParams}">上一页</a>
                        <a href="admin_douserselect?cp=${cpage+1>tpage?tpage:cpage+1}${searchParams}">下一页</a>
                        <a href="admin_douserselect?cp=${tpage}${searchParams}">尾页</a>                                     
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>