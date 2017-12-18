<#include "/ftl/common/head.ftl">

<body>
    <div class="account-bind">
        <div class="account-content">
            <div class="title text-center">账户绑定</div>
            <div class="account-info">
                <div>
                    <span>账号:</span>
                    <input type="text" id="account" class="input">
                </div>
                <div style="margin-top: 20px;">
                    <span>密码:</span>
                    <input type="password" id="password" class="input">
                </div>
            </div>
            <div style="margin-top: 20px;line-height: 40px;" class="text-center"><span id="submit">绑定</span></div>
        </div>
    </div>
</body>

<#include "/ftl/common/foot.ftl">
<script>
    $("#submit").click(function() {
        if(dialog11){
            dialog11.show();
        }
        var dialog11 = jqueryAlert({
            'icon'    : '/image/right.png',
            'content' : '绑定成功',
            'closeTime' : 2000,
            'width': 200
        })
    })
</script>