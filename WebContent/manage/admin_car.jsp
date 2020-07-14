<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="admin_menu.jsp" %>  
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">停车管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_useradd.jsp"><i class="icon-font"></i>添加信息</a>
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                        
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></t>
                            <th>编号</th>
                            <th>业主名</th>
 
                            <th>车牌号</th>
                            <th>车位状态</th>
                            <th>操作</th>
                        </tr>
                        <tr>
                            <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                            <td>1</td>
                            <td>
                                <input name="ids[]" value="59" type="hidden">小新
                             
                            </td>
                            <td>浙B7787</td>
                            <td title="发哥经典"><a  href="#" title="发布日期">1</a> 
                            </td>
                            <td>
                                <a class="link-update" href="#">修改</a>
                                <a class="link-del" href="#">删除</a>
                            </td>

                        </tr>
                        <tr>
                            <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                            <td>2</td>
                            <td>
                                <input name="ids[]" value="59" type="hidden">耿伟
                             
                            </td>
                            <td>浙B6643</td>
                            <td title="发哥经典"><a  href="#" title="发布日期">2</a> 
                            </td>
                            <td>
                                <a class="link-update" href="#">修改</a>
                                <a class="link-del" href="#">删除</a>
                            </td>

                        </tr>
                        <tr>
                            <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                            <td>3</td>
                            <td>
                                <input name="ids[]" value="59" type="hidden">小白
                             
                            </td>
                            <td>浙B5536</td>
                            <td title="发哥经典"><a  href="#" title="发布日期">1</a> 
                            </td>
                            <td>
                                <a class="link-update" href="#">修改</a>
                                <a class="link-del" href="#">删除</a>
                            </td>

                        </tr>
                       
                    </table>
                    <div class="list-page">
                                                              共3条记录，当前1/1页
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