<#include "/ftl/common/head.ftl">
<body>
<div class="task_list_detail pd-md-bottom">
    <ul class="p">
        <li class="list-item">
            <a class="display-block task-list-detail-item" href="/timo/business/tasklist/tasklistdetail/taskdetailinfo.html?taskId=1">
                <div class="">
                    <div class="detail-item">
                        <div class="pd-xs">
                            <span>背诵单词连续7天</span>
                            <span class="float-right">测试正确率不低于90%</span>
                        </div>
                        <div class="pd-xs mr-md-top">
                            <span>每日新单词不少于20个</span>
                            <span class="float-right">飞机票:20元</span>
                        </div>
                    </div>
                </div>
            </a>
        </li>
        <li class="list-item">
            <a class="display-block task-list-detail-item">
                <div class="">
                    <div class="detail-item">
                        <div class="pd-xs">
                            <span>背诵单词连续7天</span>
                            <span class="float-right">测试正确率不低于90%</span>
                        </div>
                        <div class="pd-xs mr-md-top">
                            <span>每日新单词不少于20个</span>
                            <span class="float-right">飞机票:20元</span>
                        </div>
                    </div>
                </div>
            </a>
        </li>
        <li class="list-item">
            <a class="display-block task-list-detail-item">
                <div class="">
                    <div class="detail-item">
                        <div class="pd-xs">
                            <span>背诵单词连续7天</span>
                            <span class="float-right">测试正确率不低于90%</span>
                        </div>
                        <div class="pd-xs mr-md-top">
                            <span>每日新单词不少于20个</span>
                            <span class="float-right">飞机票:20元</span>
                        </div>
                    </div>
                </div>
            </a>
        </li>
    </ul>
</div>
<script>
    $(function(){
        // 页数
        var page = 0;
        // 每页展示10个
        var size = 10;

        $(".task_list_detail").dropload({
            scrollArea : window,
            domDown : {
                domClass   : 'dropload-down',
                domRefresh : '<div class="dropload-refresh">↑上拉加载</div>',
                domLoad    : '<div class="dropload-load"><span class="loading"></span>加载中...</div>',
                domNoData  : '<div class="dropload-noData">暂无数据</div>'
            },
            loadDownFn : function(me){
                page++;
                // 拼接HTML
                var result = '';
                $.ajax({
                    type: 'GET',
                    url: 'http://ons.me/tools/dropload/json.php?page='+page+'&size='+size,
                    dataType: 'json',
                    success: function(data){
                        var arrLen = data.length;
                        var temporaryArray = [];
                        if(arrLen > 0){
                            for(var i=0; i<arrLen; i++){
                                result =  '<li class="list-item">'+
                                                '<a class="display-block task-list-detail-item">'+
                                                    '<div class="">'+
                                                        '<div class="detail-item">'+
                                                            '<div class="pd-xs">'+
                                                                '<span>背诵单词连续7天</span>'+
                                                                '<span class="float-right">测试正确率不低于90%</span>'+
                                                            '</div>'+
                                                            '<div class="pd-xs mr-md-top">'+
                                                                '<span>每日新单词不少于20个</span>'+
                                                                '<span class="float-right">飞机票:20元</span>'+
                                                            '</div>'+
                                                        '</div>'+
                                                    '</div>'+
                                                '</a>'+
                                            '</li>';
                                temporaryArray.push(result);
                            }
                            // 如果没有数据
                        }else{
                            // 锁定
                            me.lock();
                            // 无数据
                            me.noData();
                        }
                        // 为了测试，延迟1秒加载
                        setTimeout(function(){
                            // 插入数据到页面，放到最后面
                            $('.p').append(temporaryArray.join(""));
                            // 每次数据插入，必须重置
                            me.resetload();
                        },1000);
                    },
                    error: function(xhr, type){
                        alert('Ajax error!');
                        // 即使加载出错，也得重置
                        me.resetload();
                    }
                });
            },
            threshold : 50
        })
    })
</script>
</body>


<#include "/ftl/common/foot.ftl">