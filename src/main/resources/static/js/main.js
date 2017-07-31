var generateRulesAndActivityTime = function(){
    $.ajax({
        type: "GET",
        contentType: 'application/json',
        url: "http://stage.activities.yolo168.xyz/fafa2pngActivity/getFormatDate",
        success: function (res) {
            if (res.errorCode == '99SYS0000') {
                if(res.data && res.data.length > 0){
                    var ruleBlock = "";
                    ruleBlock += '<p>&nbsp;</p>';
                    ruleBlock += '<p><span>1.活动开始于'+res.data[0]+'（北京时间），截止于'+res.data[1]+'（北京时间）。</span></p>';
                    ruleBlock += '<p><span>2.发发娱乐所有会员均可申请参加此活动。</span></p>';
                    ruleBlock += '<p><span>3.请先登陆后，再进行玩火小丑游戏。</span></p>';
                    ruleBlock += '<p><span>4.会员需要在PNG平台“玩火小丑”老虎机游戏中使用真钱游戏</span></p>';
                    ruleBlock += '<p><span>&nbsp;&nbsp; 任一单条赢利线上出现以下3个相同符号将获得相应的锦标赛分数：</span></p>';
                    ruleBlock += '<p><span>&nbsp;&nbsp; 葡萄 获得 200 分&nbsp; &nbsp;&nbsp; 幸运七获得 300 分&nbsp; &nbsp;&nbsp; 小丑获得 500 分</span></p>';
                    ruleBlock += '<p><span>&nbsp;&nbsp; 温馨提示：二个葡葡+一个小丑 = 三个葡萄 200分； 一个葡萄+二个小丑 =&nbsp; 三个葡萄 也是 200分。</span></p>';
                    ruleBlock += '<p><span>&nbsp;&nbsp; 同理 幸运七与小丑混搭 300分；</span></p>';
                    ruleBlock += '<p><span>5.官方排行榜将公布排名前50名的会员，排行榜约3分钟更新分数。</span></p>';
                    ruleBlock += '<p><span>6.不同名次可获得奖金如排行榜列表所示。</span></p>';
                    ruleBlock += '<p><span>7.奖金于优惠结束后的3个工作日内派发至您的账户，只需1倍流水即可提款。我们将通过站内信或电话通知获奖会员。</span></p>';
                    ruleBlock += '<p><span>8.每局至少需在“玩火小丑”中使用真钱投注&nbsp; 10 RMB ,否则当局不获得分数。</span></p>';
                    $('#rules').append(ruleBlock);
                    $('#activityTime').append('活动时间：'+res.data[0]+'-- '+res.data[1]+'');
                }
            } else {
                alert("取得资料错误");
            }
        }
    });
}

var getAchievementTable = function(returnObj,params,loginAccount,handleFunction){

    $.ajax({
        type: "POST",
        contentType: 'application/json',
        url: "http://stage.activities.yolo168.xyz/fafa2pngActivity/getAchievementTable",
        data: JSON.stringify(params),
        success: function (res) {
            var tbody = "";
            if (res.errorCode == '99SYS0000') {
                $.each(res.data, function (index, item) {
                    if(index < 50) {
                        tbody += '<div class="css_tr">';
                        tbody += '	<div class="css_td cell">' + (index + 1) + '</div>';
                        tbody += '	<div class="css_td cell">' + (item.userName) + '</div>';
                        tbody += '	<div class="css_td cell">' + (item.points) + '</div>';
                        if (index === 0)
                            tbody += '	<div class="css_td cell">RMB 2,888</div>';
                        else if (index === 1)
                            tbody += '	<div class="css_td cell">RMB 1,800</div>';
                        else if (index === 2)
                            tbody += '	<div class="css_td cell">RMB 1,000</div>';
                        else if (index > 2 && index < 6)
                            tbody += '	<div class="css_td cell">RMB 500</div>';
                        else if (index > 5 && index < 10)
                            tbody += '	<div class="css_td cell">RMB 300</div>';
                        else if (index > 9 && index < 20)
                            tbody += '	<div class="css_td cell">RMB 100</div>';
                        else
                            tbody += '	<div class="css_td cell">RMB 50</div>';
                        tbody += '</div>';
                    }
                    if(loginAccount === item.externalId){
                        returnObj.rank = index + 1;
                        returnObj.point = item.points;
                    }
                });
                if(res.data.length < 50){
                    for(var i=0;i< 50-res.data.length;i++) {
                        tbody += '<div class="css_tr">';
                        tbody += '	<div class="css_td cell">' + (i + 1 + res.data.length) + '</div>';
                        tbody += '	<div class="css_td cell"></div>';
                        tbody += '	<div class="css_td cell"></div>';
                        if ((i + res.data.length) === 0)
                            tbody += '	<div class="css_td cell">RMB 2,888</div>';
                        else if ((i + res.data.length) === 1)
                            tbody += '	<div class="css_td cell">RMB 1,800</div>';
                        else if ((i + res.data.length) === 2)
                            tbody += '	<div class="css_td cell">RMB 1,000</div>';
                        else if ((i + res.data.length) > 2 && (i + res.data.length) < 6)
                            tbody += '	<div class="css_td cell">RMB 500</div>';
                        else if ((i + res.data.length) > 5 && (i + res.data.length) < 10)
                            tbody += '	<div class="css_td cell">RMB 300</div>';
                        else if ((i + res.data.length) > 9 && (i + res.data.length) < 20)
                            tbody += '	<div class="css_td cell">RMB 100</div>';
                        else
                            tbody += '	<div class="css_td cell">RMB 50</div>';
                        tbody += '</div>';
                    }
                }
                $(".table").append(tbody);
                delete res.data;
            } else {
                alert("取得资料错误");
            }
            return handleFunction(returnObj)
        }
    });
}

var getUserName = function(loginAccount,rank,point){
    var params = {
        externalId : loginAccount
    };
    $.ajax({
        type: "POST",
        contentType: 'application/json',
        url: "http://stage.activities.yolo168.xyz/fafa2pngActivity/getUserName",
        data: JSON.stringify(params),
        success: function (res) {
            if (res.errorCode == '99SYS0000') {
                if(res.data)
                    $('#showRank').append(res.data+'，您目前的&nbsp;&nbsp;&nbsp;积分：<span style="color: #FFFF00">'+point+'</span>&nbsp;&nbsp;&nbsp;&nbsp;排行：第&nbsp;<span style="color: #FFFF00">'+rank+'</span>&nbsp;名');
            } else {
                alert("取得资料错误");
            }
        }
    });
}

var getQueryVariable = function(variable) {
    var query = window.location.search.substring(1);
    var base64Matcher = new RegExp("^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{4})$");
    var parseSyr;
    if (base64Matcher.test(query)) {
        parseSyr = CryptoJS.enc.Base64.parse(query).toString(CryptoJS.enc.Utf8);
    } else {
        parseSyr = query;
    }
    var vars = parseSyr.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
}