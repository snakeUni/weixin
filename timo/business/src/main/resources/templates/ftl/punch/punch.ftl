<div class="punch-notification container">
    <div class="notification">
        <div class="title font-md-20">
            <span>打卡通知:</span>
            <div style="display: inline-block" class="open-circle">
                <div class="circle"></div>
            </div>
        </div>
        <div class="punch-open  font-md-20" style="margin-top: 20px;">
            <div>
                <span>时间:</span>
                <span class="main-color bg-white" style="padding: 0 40px;border-radius: 5px;" id="time1">20:30</span>
            </div>
        </div>
    </div>
</div>
<div class="alert-notification-box text-center bg-white">
    <div class="alert-box-title pd-xs-10">打卡提醒时间设置</div>
    <div class="alert-box-content pd-xs-10">
        <i class="offline"></i>
        <div id="time" class="main-color">20:30</div>
        <i class="addition"></i>
    </div>
    <div class="alert-box-footer pd-xs-10 main-color" id="hide">
        确定
    </div>
</div>
<script>
    $(".addition").on('click', function() {
        var _html = $("#time").html();
        var array = _html.split(":");
        var _hour = "", temporary = "", minute = "";
        if(array[1] == "30") {
            minute = "00";
            var hour = parseInt(array[0]) + 1;
            if(hour == 24) {
                _hour = "00"
            } else {
                if(hour < 10) {
                    _hour = "0" + hour;
                } else {
                    _hour = hour
                }
            }
        } else {
            minute = "30";
            _hour = array[0];
        }
        temporary = _hour.toString() + ":" + minute;
        $("#time").html(temporary);
    });

    $(".offline").click(function() {
        var _html = $("#time").html();
        var array = _html.split(":");
        var _hour = "", temporary = "", minute = "";
        if(array[1] == "00") {
            minute = "30";
            if(array[0] == "00") {
                _hour = 23;
            } else {
                _hour = parseInt(array[0]) - 1;
                if(_hour < 10) {
                    _hour = "0" + _hour;
                }
            }
        } else {
            minute = "00";
            _hour = array[0];
        }
        temporary = _hour.toString() + ":" + minute;
        $("#time").html(temporary);
    });

    $("#hide").click(function() {
        $(".alert-notification-box").fadeOut();
        $("#time1").html($("#time").html());
    });

    $(".open-circle").click(function() {
        var _this = $(this);
        if(_this.hasClass("selected")) {
            _this.removeClass("selected");
        } else {
            _this.addClass("selected");
        }
    })

    $("#time1").click(function() {
        $(".alert-notification-box").fadeIn();
    })
</script>