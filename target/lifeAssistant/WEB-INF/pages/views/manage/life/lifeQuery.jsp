<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${ctxStatic}/layuidemo/plugin/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctxStatic}/layuidemo/css/list.min.css">
</head>
<body>

<div id="main-wrap" class="animated fadeIn">
    <div class="main-title">
        <h1>生活百科知识列表</h1>
        <div class="toolbar">
            <button class="layui-btn layui-btn-small do-action" data-type="doAdd" data-href="${ctx}/manage/life/lifeAdd">
                <i class="layui-icon">&#xe608;</i> 添加百科知识
            </button>
        </div>
    </div>
    <hr>
    <div class="main-content">
        <!--<blockquote class="layui-elem-quote">这里可以写列表的说明，没有就删了。</blockquote>-->
        <!-- table的class里添加table-zebra样式可将表格改为斑马线样式 -->

        <table class="table-sort table-box dataTable">
            <thead>
            <tr>
                <th><input type="checkbox" class="icheck"></th>
                <th>知识编号</th>
                <th>知识标题</th>
                <th>知识插图</th>
                <th>知识内容</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="life" items="${life}">
                <tr>
                    <td><input type="checkbox" name="uuid" class="icheck"></td>
                    <td>${life.number}</td>
                    <td>${life.title}</td>
                    <td onclick="showParentPic('${life.imgUrl}')">
                        <img style="width: 45px;" src="${life.imgUrl}">
                    </td>
                    <td>${life.message}</td>
                    <td><fmt:formatDate value="${life.createTime}" type="date"/></td>
                    <td>
                        <ul class="layui-nav" lay-filter="">
                            <li class="layui-nav-item">
                                <a href="javascript:;">操作</a>
                                <dl class="layui-nav-child">
                                    <dd><a href="javascript:;" class="do-action" data-type="doEdit" data-href="${ctx}/manage/life/lifeAdd?id=${life.id}"><i class="layui-icon">&#xe642;</i>编辑</a></dd>
                                    <dd><a href="javascript:;" class="do-action" onclick="alertDel(${life.id})"><i class="layui-icon">&#xe640;</i>删除</a></dd>
                                </dl>
                            </li>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>

<script src="${ctxStatic}/layuidemo/plugin/layui/layui.js"></script>
<script src="${ctxStatic}/layuidemo/js/list.min.js"></script>
<script src="${ctxStatic}/layuidemo/js/form.min.js"></script>
<script src="${ctxStatic}/layuidemo/js/jquery1.8.0.min.js"></script>
<script>
    layui.config({base:"${ctxStatic}/layuidemo/plugin/layui/lay/modules/mplus/"}).extend({common:"common.min",datatable:"datatable/jquery.dataTables.min",sweetalert:"sweetalert/sweetalert.min",echarts:"echarts/echarts.min",echarts_common:"echarts/echarts.common.min",echarts_simple:"echarts/echarts.simple.min",icheck:"iCheck/icheck.min",cropper:"cropper/cropper.min",chosen:"chosen/chosen.min"});layui.use(["layer","jquery","datatable","icheck","chosen"],function(){var a=layui.layer,b=layui.jquery;b(".icheck").iCheck({checkboxClass:"icheckbox_square-green"});b(".mplus-select").chosen({width:"100%"});b(".mplus-select ~ .layui-form-select").remove();b(function(){var c=b("table th input:checkbox");var d=b('input[name="uuid"]');c.on("ifChecked ifUnchecked",function(e){if(e.type=="ifChecked"){d.iCheck("check")}else{d.iCheck("uncheck")}});d.on("ifChanged",function(e){if(d.filter(":checked").length==d.length){c.prop("checked","checked")}else{c.removeProp("checked")}c.iCheck("update")});d.on("ifChanged",function(e){if(d.filter(":checked").length>1){b("#batch_delete_btn").show()}else{b("#batch_delete_btn").hide()}});b(".dataTable").dataTable({searching:true,paging:true,lengthChange:true,info:true,ordering:true,order:[1,"desc"],orderMulti:true,columnDefs:[{targets:0,searchable:false},{orderable:false,targets:0},{orderable:false,targets:6}],processing:true,autoWidth:false,deferRender:true,lengthMenu:[5,10,25,50,100],pageLength:10,orderClasses:false,pagingType:"full_numbers",language:{emptyTable:"暂无数据！",info:"显示第 _START_ 条到第 _END_ 条，共 _TOTAL_ 条",infoEmpty:"共 _TOTAL_ 条",infoFiltered:"(从 _MAX_ 条数据中过滤)",lengthMenu:"每页显示 _MENU_ 条",loadingRecords:"加载中，请稍等。。。",paginate:{first:"首页",last:"尾页",next:"下一页",previous:"上一页"},processing:"数据处理中。。。",zeroRecords:"暂无匹配的记录"},stateSave:true});b(".table-sort tbody").on("click","tr",function(){if(b(this).hasClass("selected")){b(this).removeClass("selected")}else{b("tr.selected").removeClass("selected");b(this).addClass("selected")}})});if(self.frameElement.tagName=="IFRAME"){parent.layer.closeAll()}});changeMainHeight();window.onresize=function(){changeMainHeight()};function changeMainHeight(){var a=document.getElementById("main-wrap");if(a){a.style.minHeight=window.parent.document.documentElement.clientHeight-185+"px"}};
    function showParentPic(picUrl) {
        layui.use('layer', function() {
            var $ = layui.jquery,
                    layer = layui.layer;
            layer.open({
                title: false,
                type: 1,
                content: '<img src=' + picUrl + '>',
                area: ['650px', '350px'],
                shadeClose: true
            });
        });
    }

    function alertDel(id) {
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.open({
                content: '确定删除该条信息吗？'
                ,btn: ['确定', '取消']
                ,yes: function(index, layero){
                    $.ajax({
                        type: 'POST',
                        url: '${ctx}/manage/life/lifeDel',
                        data: {"id": id},
                        dataType: "JSON",
                        beforeSend:function(){
                            layer.load(2);
                        },
                        success: function (data) {
                            layer.closeAll();
                            window.location.href="${ctx}/manage/life/lifeQuery"
                        },
                        error: function (e) {
                            alert("删除失败！");
                            layer.closeAll();
                        }
                    });

                }
                ,btn2: function(index, layero){

                    //return false 开启该代码可禁止点击该按钮关闭
                }
                ,cancel: function(){
                    //右上角关闭回调
                    //return false 开启该代码可禁止点击该按钮关闭
                }
            });

        });
    }
</script>
</body>
</html>
