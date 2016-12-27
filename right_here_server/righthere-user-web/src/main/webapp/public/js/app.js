var app = angular.module('myApp', ['ngRoute']);



app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        controller: 'welcomeController',
        templateUrl: 'gbanker/welcome.html'
    }).when('/todo', {
        controller: 'todoController',
        templateUrl: 'gbanker/blank.html'
    }).when('/register', {
        controller: 'registerController',
        templateUrl: 'gbanker/regist.html'
    }).when('/autotest', {
        controller: 'autotestController',
        templateUrl: 'gbanker/autotest.html'
    }).when('/autotestrpt', {
        controller: 'autotestrptController',
        templateUrl: 'gbanker/autotestrpt.html'
    }).when('/autotestresult', {
        controller: 'autotestresultController',
        templateUrl: 'gbanker/autotestresult.html'
    }).when('/registercode', {
        controller: 'registercodeController',
        templateUrl: 'gbanker/registercode.html'
    }).when('/caserun', {
        controller: 'caserunController',
        templateUrl: 'gbanker/caserun.html'
    }).when('/cachehandle', {
        controller: 'cachehandleController',
        templateUrl: 'gbanker/cachehandle.html'
    }).when('/merchant', {
        controller: 'merchantController',
        templateUrl: 'gbanker/merchant.html'
    }).when('/goldprice', {
        controller: 'goldpriceController',
        templateUrl: 'gbanker/goldprice.html'
    }).when('/calculator', {
        controller: 'calculatorController',
        templateUrl: 'gbanker/calculator.html'
    }).when('/accountedit', {
        controller: 'AccountUtilController',
        templateUrl: 'gbanker/accountedit.html'
    }).when('/aliyunoss', {
        controller: 'aliyunossController',
        templateUrl: 'gbanker/aliyunoss.html'

    }).otherwise({redirectTo: '/'});
}]);

app.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.interceptors.push('httpInterceptor');

    $httpProvider.interceptors.push(function ($q, $window) {
        return {
            request: function (request) {

                return request;
            },
            // This is the responseError interceptor
            responseError: function (rejection) {
                if (rejection.status === 401) {
                    // Return a new promise
                    $window.location.href = '/#/no_permission';

                }

                /* If not a 401, do nothing with this error.
                 * This is necessary to make a `responseError`
                 * interceptor a no-op. */
                return $q.reject(rejection);
            }
        };
    });

}]);


app.factory('httpInterceptor', [function () {

    var myInterceptor = {
        request: function (config) {

            if ($('#portalCsrfTopId') != undefined && $('#topFrame') != undefined) {
                var key = null;
                var token = null;
                try {
                    key = $('#portalCsrfTopId', top['topFrame'].document).attr('name');
                    token = $('#portalCsrfTopId', top['topFrame'].document).attr('value');
                } catch (e) {
                    // console.log('eror:' + e);
                }

                // var key = 1;
                // var token = 2;
                var csrfParam = (key && token) ? key + "=" + token : null;
                var type = config['method'] + '';

                if (!csrfParam) {
                    return config;
                }

                if (type.toLowerCase() == 'put'
                    || type.toLowerCase() == 'post'
                    || type.toLowerCase() == 'delete') {


                    if (config['url'].indexOf('?') > -1) {
                        config['url'] += "&" + csrfParam
                    } else {
                        config['url'] += "?" + csrfParam


                    }
                }
                // alert(JSON.stringify(config['url']));

            }

            return config;

        },
        // 返回拦截
        response: function (response) {
            //console.log(JSON.stringify(response));
            return response;
        }
    };

    return myInterceptor;
}]);


app.factory('invokeService', ['$http', function ($http) {

    var xblAPI = {};

    xblAPI.getParams = function (obj) {
        var str = "";
        for (var key in obj) {
            if (str != "" && str.substr(str.length - 1, 1) != '&') {
                str += "&";
            }
            if (!obj[key] || obj[key] == '' || obj[key] == -1 || obj[key] == '-1') {
                continue;
            }
            str += key + "=" + encodeURIComponent(obj[key]);
        }
        return str;
    };


    // 用户注册
    xblAPI.userRegist= function (tel, inviter) {

        var url = '/testserver/testUtil/userRegAccoutCashMoney?telephone='+tel+'&type=2&inviter='+inviter;
        return $http({
            method: 'get',
            url: url
        });
    };

    // 用户批量注册
    xblAPI.userRegists= function (start, end) {

        var url = '/testserver/testUtil/userRegAccoutCashMoneyData?start='+start+'&end='+end;
        return $http({
            method: 'get',
            url: url
        });
    };

    // 账户加钱by手机
    xblAPI.addCashByTel= function (tel,money) {

        var url = '/testserver/accountUtil/cashAddByTel?telephone='+tel+'&money='+money;
        return $http({
            method: 'get',
            url: url
        });
    };


    // 账户加钱by账户Id
    xblAPI.addCashByAccount= function (accountId,money) {

        var url = '/testserver/accountUtil/cashAddByAccount?accountId='+accountId+'&money='+money;
        return $http({
            method: 'get',
            url: url
        });
    };

    // 账户加金by手机
    xblAPI.addGoldByTel= function (tel,goldWeight) {

        var url = '/testserver/accountUtil/goldAddByTel?telephone='+tel+'&goldWeight='+goldWeight;
        return $http({
            method: 'get',
            url: url
        });
    };


    // 账户加金by账户Id
    xblAPI.addGoldByAccount= function (accountId,goldWeight) {

        var url = '/testserver/accountUtil/goldAddByAccount?accountId='+accountId+'&goldWeight='+goldWeight;
        return $http({
            method: 'get',
            url: url
        });
    };


    // 获取验证码
    xblAPI.getregistercodes= function () {

        var url = '/testserver/registercode/getcodes?size=10';
        return $http({
            method: 'get',
            url: url
        });
    };
    // 请求商户添加接口
    xblAPI.addmerchant= function (merchant_code,merchant_name,account_id) {

        var url = '/testserver/merchantInfo/saveMerchantInfo?merchantCode='+merchant_code+'&merchantName='+merchant_name+'&accountId='+account_id;
        return $http({
            method: 'get',
            url: url
        });
    };
    // 请求商户查询接口
    xblAPI.addqurrymerchant= function (account_id1) {

        var url = '/testserver/merchantInfo/queryMerchantInfo?accountId='+account_id1;
        return $http({
            method: 'get',
            url: url
        });
    };
    // 请求商户资产查询接口
    xblAPI.addqurrymerchantAccount= function (account_id2) {

        var url = '/testserver/merchantInfo/queryMerchantAccount?accountId='+account_id2;
        return $http({
            method: 'get',
            url: url
        });
    };
    // 获取用例执行结果
    xblAPI.getcaseresults= function () {

        var url = '/autotest/getcaseresults';
        return $http({
            method: 'get',
            url: url
        });
    };

    // 获取用例信息
    xblAPI.getcases= function () {
        var url = '/autotest/getcases';
        return $http({
            method: 'get',
            url: url
        });
    };

    // 添加用例
    xblAPI.insertcase= function (data) {
        var url = '/autotest/insertcase';
        return $http({
            method: 'post',
            data: data,
            url: url
        });
    };

    // 删除用例
    xblAPI.deletecase= function (caseId) {
        var url = '/autotest/deletecase?caseId='+caseId;
        return $http({
            method: 'get',
            url: url
        });
    };

    // 更新用例
    xblAPI.updatecase= function (data) {
        var url = '/autotest/updatecase';
        return $http({
            method: 'post',
            data: data,
            url: url
        });
    };

    // jsonp获取用例
    xblAPI.jsonpcase= function (type,module,inteface,method,username) {
        return $http.jsonp("http://182.92.10.201:8911/test?callback=JSON_CALLBACK&type="+type+"&module="+module+"&inteface="+inteface+"&method="+method+"&code=1"+"&user="+username).success(function(data){
            return data
        })
    };

    // memcache cache获取
    xblAPI.cacheget= function (data) {
        var url = '/cache/get?key='+data;
        return $http({
            method: 'get',
            url: url
        });
    };

    // memcache cache删除
    xblAPI.cachedelete= function (data) {
        var url = '/cache/delete?key='+data;
        return $http({
            method: 'get',
            url: url
        });
    };

    // redis cache获取
    xblAPI.rediscacheget= function (data) {
        var url = '/cache/redisget?key='+data;
        return $http({
            method: 'get',
            url: url
        });
    };

    // redis cache删除
    xblAPI.rediscachedelete= function (data) {
        var url = '/cache/redisdelete?key='+data;
        return $http({
            method: 'get',
            url: url
        });
    };

    // redis list
    xblAPI.cachelist= function (data) {
        var url = '/cache/getcachelist?cachetype='+data;
        return $http({
            method: 'get',
            url: url
        });
    };

    // 更新金价
    xblAPI.updateprice= function (data) {
        var url = '/goldprice/update?price='+data;
        return $http({
            method: 'get',
            url: url
        });
    };

    // 判断是否为系统金价
    xblAPI.getpricestatus= function (data) {
        var url = '/goldprice/getstatus';
        return $http({
            method: 'get',
            url: url
        });
    };

    // 切换为系统金价
    xblAPI.switch2sysprice= function (data) {
        var url = '/goldprice/updatestatus';
        return $http({
            method: 'get',
            url: url
        });
    };


    // 切换为系统金价
    xblAPI.latestrpt= function (size) {
        var url = '/autotest/getcasereport?size='+size;
        return $http({
            method: 'get',
            url: url
        });
    };

    // 获取clearRecord的oss文件
    xblAPI.getLatestClearRecord= function (size) {
        var url = '/aliyunoss/getfile?size='+size;
        return $http({
            method: 'get',
            url: url
        });
    };
    return xblAPI;


}]);

app.filter("trim", function ($sce) {
    return function (input) {
        return !input ? '' : input.replace(/(^\s*)|(\s*$)/g, "");
    };
});

app.filter("registercodestatus", function ($sce) {
    return function (input) {
        if (input == '1') {
            return "未使用";
        }else if(input =='0'){
            return "已使用"
        }
        return input;
    };
});

app.filter("caseresultalert", function ($sce) {
    return function (input) {
        var result = '';
        if (input == 'Fail') {
            result = '<span class="text-red">失败</span>';
        }else if (input == 'Pass') {
            result = '<span class="text-green">成功</span>';
        }else if (input == 'init') {
            result = '<span class="text-yellow">初始化</span>';
        }
        return $sce.trustAsHtml(result);
    };
});

app.controller('registerController', ['$scope', 'invokeService', function ($scope, invokeService) {

    $scope.regInfo ={
        telephone : '',
        inviter : ''
    };
    $scope.regInfos ={
        starttel : '',
        endtel : ''
    };

    $scope.regist = function (p) {
        if(! /^1\d{10}$/g.test($scope.regInfo.telephone)) {
            alert("手机号格式错误");
            return;
        }

    invokeService.userRegist($scope.regInfo.telephone, $scope.regInfo.inviter).success(function (resdata, status, headers) {
            if(true == resdata.info.ok)
                alert("注册成功!")
            else
                alert("注册失败!")
        });
    };

    $scope.reset = function () {
        $scope.regInfo = {
            telephone: null,
            inviter: null
        };
    };

    $scope.regists = function (p) {
        if(! /^1\d{10}$/g.test($scope.regInfos.starttel) || ! /^1\d{10}$/g.test($scope.regInfos.endtel)) {
            alert("手机号格式错误");
            return;
        }

        invokeService.userRegists($scope.regInfos.starttel, $scope.regInfos.endtel).success(function (resdata, status, headers) {
            if(true == resdata.info.ok)
                alert("注册成功!")
            else
                alert("注册失败!")
        });
    };
    $scope.resets = function () {
        $scope.regInfos = {
            starttel: null,
            endtel: null
        };
    };


}]);


app.controller('autotestController', ['$scope', 'invokeService', function ($scope, invokeService) {
    // 获取用例信息
    $scope.global = {};
    $scope.global.allcases=[];
    invokeService.getcases().success(function (resdata, status, headers) {
        if(true == resdata.info.ok)
            $scope.global.allcases=resdata.data.data
    });

    $scope.refreshcases = function () {
        invokeService.getcases().success(function (resdata, status, headers) {
            if(true == resdata.info.ok)
                $scope.global.allcases=resdata.data.data
        });
    };

    $scope.selectModel = function (id) {
        $("#modelDetailDialog").modal();
    };
    //添加用例
    $scope.data={
        "caseId":"",
        "requestUrl":"",
        "requestParams":"",
        "requestHeader":"",
        "caseDesc":""
    };
    $scope.submitCase = function (id) {
        if($scope.data.requestUrl==""){
            return false
        }
        invokeService.insertcase($scope.data).success(function (resdata, status, headers) {
            $scope.refreshcases();
        });
    };
    //复制用例
    $scope.copyCase = function (id) {
        data={}
        $scope.global.allcases.forEach(function(e){
            if(e.caseId == id){
                data={
                    "requestUrl": e.requestUrl,
                    "requestParams": e.requestParams,
                    "requestHeader": e.requestHeader,
                    "caseDesc": e.caseDesc
                };
            }
        })
        invokeService.insertcase(data).success(function (resdata, status, headers) {
            $scope.refreshcases();
        });
    };
    //删除用例
    $scope.deleteCase = function (id) {
        if(confirm("确定要删除该用例吗？")){
            invokeService.deletecase(id).success(function (resdata, status, headers) {
                $scope.refreshcases();
            });
        }
    };
    //更新用例
    $scope.editingNode = {};
    $scope.editNode = function (m) {
        $scope.editingNode = m;
    };
    $scope.cancelEditNode = function () {
        $scope.editingNode = {};
    };
    $scope.saveNode = function () {
        invokeService.updatecase($scope.editingNode).success(function (resdata, status, headers) {
            if (resdata.info.ok) {
                alert("保存成功");
                $scope.refreshcases();
                $scope.cancelEditNode();
            } else {
                alert(resdata.info.message);
            }
        });
    };
}]);
app.controller('autotestrptController', ['$scope', 'invokeService', function ($scope, invokeService) {
    // 当前菜单

    $scope.drawChart = function (domId, option) {
        // 模型使用统计
        var myChart = echarts.init(document.getElementById(domId));
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    };

    $scope.chart1Loading = true;
    $scope.chart2Loading = true;

    // 模型使用统计报表
    $scope.rptByModelId = function (query) {
        $scope.chart1Loading = true;
        // 指定图表的配置项和数据
        invokeService.latestrpt(50).success(function (resdata, status, headers) {
            var option = {
                title: {
                    text: '',
                    subtext: ''
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: ['模型列表']
                },
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                xAxis: [
                    {
                        name: '执行时间',
                        type: 'category',
                        data: []
                    }
                ],
                yAxis: [
                    {
                        name: '通过率',
                        type: 'value',
                        axisLabel: {
                            formatter: '{value} %'
                        }
                    }
                ],
                series: [
                    {
                        name: '百分之',
                        type: 'bar',
                        data: [],
                        itemStyle: {
                            normal: {
                                color: new echarts.graphic.LinearGradient(
                                    0, 0, 0, 1,
                                    [
                                        {offset: 0, color: '#83bff6'},
                                        {offset: 0.5, color: '#188df0'},
                                        {offset: 1, color: '#188df0'}
                                    ]
                                )
                            },
                            emphasis: {
                                color: new echarts.graphic.LinearGradient(
                                    0, 0, 0, 1,
                                    [
                                        {offset: 0, color: '#2378f7'},
                                        {offset: 0.7, color: '#2378f7'},
                                        {offset: 1, color: '#83bff6'}
                                    ]
                                )
                            }
                        },
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        },
                        markLine: {
                            data: [
                                //{type: 'average', name: '平均值'}
                            ]
                        }
                    }
                ]
            };


        var seriesData = [];
        var xAxisData = [];
        for (var i = resdata.data.data.length -1; i >=0 ; i--) {
            seriesData.push(resdata.data.data[i].passPercent * 100);
            xAxisData.push(new Date(resdata.data.data[i].runTime).toLocaleString());
        }
        option.xAxis[0].data = xAxisData;
        option.series[0].data = seriesData;

        $scope.drawChart('rpt-passrate', option);
        $scope.chart1Loading = false;
      });
    };


    $scope.rptByModelId();

}]);

app.controller('autotestresultController', ['$scope', 'invokeService', function ($scope, invokeService) {
    // 获取用例执行结果
    $scope.global = {};
    $scope.global.allcaseresults=[];
    $scope.global.failcount=0;
    $scope.global.totalcount=0;
    $scope.global.prompt = ""
    invokeService.getcaseresults().success(function (resdata, status, headers) {
        if(true == resdata.info.ok)
            $scope.global.allcaseresults=resdata.data.data
            resdata.data.data.forEach(function(e){
                if(e.result == 'Fail')
                    $scope.global.failcount++;
            })
        if($scope.global.failcount > 0){
            $scope.global.prompt="一共有  "+resdata.data.data.length+"  个用例，其中失败的用例  "+$scope.global.failcount+"  个，请及时修复!"
        }else{
            $scope.global.prompt="没有失败的用例，请继续保持!"
        }
        $scope.global.totalcount=resdata.data.data.length;
    });

    $scope.refreshcodes = function () {
        invokeService.getcaseresults().success(function (resdata, status, headers) {
            if(true == resdata.info.ok)
                $scope.global.failcount=0;
                $scope.global.allcaseresults=resdata.data.data
                resdata.data.data.forEach(function(e){
                if(e.result == 'Fail')
                    $scope.global.failcount++;
            })
            if($scope.global.failcount > 0){
                $scope.global.prompt="一共有  "+resdata.data.data.length+"  个用例，其中失败的用例  "+$scope.global.failcount+"  个，请及时修复!"
            }else{
                $scope.global.prompt="没有失败的用例，请继续保持!"
            }
            $scope.global.totalcount=resdata.data.data.length;

        });
    };
    // 统计用例数据
    $scope.statisticClass = function (argument) {
        return $scope.global.failcount == 0 ? 'callout callout-info' : 'callout callout-warning';
    };

}]);
app.controller('registercodeController', ['$scope', 'invokeService', function ($scope, invokeService) {
    // 获取验证码
    $scope.global = {};
    $scope.global.newregistercodes_firstline=[];
    $scope.global.newregistercodes_others=[];
    invokeService.getregistercodes().success(function (resdata, status, headers) {
        if(true == resdata.info.ok)
            $scope.global.newregistercodes_firstline=resdata.data.data.shift()
            $scope.global.newregistercodes_others=resdata.data.data;

    });

    $scope.refreshcodes = function () {
        invokeService.getregistercodes().success(function (resdata, status, headers) {
            if(true == resdata.info.ok)
                $scope.global.newregistercodes_firstline=resdata.data.data.shift();
                $scope.global.newregistercodes_others=resdata.data.data;
        });
    };



}]);


app.controller('rootController', ['$scope', 'invokeService', function ($scope, invokeService) {
}]);


app.controller('welcomeController', ['$scope', 'invokeService', function ($scope, invokeService) {
}]);
app.controller('todoController', ['$scope', 'invokeService', function ($scope, invokeService) {
}]);
app.controller('cachehandleController', ['$scope', 'invokeService', function ($scope, invokeService) {
    $scope.global={}
    $scope.global.key=""
    $scope.global.value=""
    $scope.show = false
    $scope.get = function(){
        if($scope.global.key != ""){
            $scope.show = true
            invokeService.cacheget($scope.global.key).success(function (resdata, status, headers) {
                if (resdata.info.ok) {
                    if(null == resdata['data']['data']){
                        $scope.global.value="sorry, i can't get! please confirm cache exists or not!"
                    }else{
                        $scope.global.value=resdata['data']['data']
                    }
                }else{
                    alert(resdata.info.message)
                }

            });
        }
    }
    $scope.delete = function(){
        if(confirm("确认要清除 "+$scope.global.key+" 的缓存?")){
            invokeService.cachedelete($scope.global.key).success(function (resdata, status, headers) {
                if (resdata.info.ok) {
                    $scope.global.key=""
                    $scope.global.value=""
                    $scope.show = false
                    alert("清除成功!")
                }else{
                    alert(resdata.info.message)
                }
            });
        }
    }

    $scope.global.rediskey=""
    $scope.global.redisvalue=""
    $scope.redisshow = false
    $scope.getredis = function(){
        if($scope.global.rediskey != ""){
            $scope.redisshow = true
            invokeService.rediscacheget($scope.global.rediskey).success(function (resdata, status, headers) {
                if (resdata.info.ok) {
                    if(null == resdata['data']['data']){
                        $scope.global.redisvalue="sorry, i can't get! please confirm cache exists or not!"
                    }else{
                        $scope.global.redisvalue=resdata['data']['data']
                    }
                }else{
                    alert(resdata.info.message)
                }

            });
        }
    }
    $scope.deleteredis = function(){
        if(confirm("确认要清除 "+$scope.global.rediskey+" 的缓存?")){
            invokeService.rediscachedelete($scope.global.rediskey).success(function (resdata, status, headers) {
                if (resdata.info.ok) {
                    $scope.global.rediskey=""
                    $scope.global.redisvalue=""
                    $scope.redisshow = false
                    alert("清除成功!")
                }else{
                    alert(resdata.info.message)
                }
            });
        }
    }

    $scope.memcache = {}
    $scope.memcache.latestkey=[]
    invokeService.cachelist("memcache").success(function (resdata, status, headers){
        $scope.memcache.latestkey = resdata.data.data
    })
    $scope.searchmemcache = function(arg){
        $scope.global.key = arg;
        $scope.get(arg);
    }
    $scope.redis = {}
    $scope.redis.latestkey= []
    invokeService.cachelist("redis").success(function (resdata, status, headers){
        $scope.redis.latestkey = resdata.data.data
    })
    $scope.searchredis = function(arg){
        $scope.global.rediskey = arg;
        $scope.getredis(arg);
    }
    $scope.clearmemcache = function(){
        $scope.global.key=""
        $scope.global.value=""
        $scope.show = false
    }
    $scope.clearredis = function(){
        $scope.global.rediskey=""
        $scope.global.redisvalue=""
        $scope.redisshow = false
    }
}]);

app.controller('caserunController', ['$scope', 'invokeService', function ($scope, invokeService) {
    //解决跨域问题
    $scope.global={}
    $scope.loading = false
    $scope.runloading = false
    $scope.global.username=""
    $scope.global.users=[]
    $scope.global.modulename=""
    $scope.global.intefacename=""
    $scope.global.methodname=""
    $scope.global.runcaselist={}
    $scope.global.moduleoptions=[]
    $scope.global.intefaceoptions=[]
    $scope.global.methodoptions=[]
    $scope.global.output = "init..."
    invokeService.jsonpcase(1,"","","","zxl").success(function (resdata, status, headers) {
        $scope.global.users=resdata['dirname']
        $scope.global.username="zxl"
        $scope.global.runcaselist=resdata['tree']
        for(m in resdata['tree'])
            $scope.global.moduleoptions.push(m)
    });
    $scope.$watch('global.intefacename', function (post) {
        if($scope.global.intefacename.length == 1) {
            if ($scope.global.intefacename != "") {
                $scope.global.methodoptions = $scope.global.runcaselist[$scope.global.modulename][$scope.global.intefacename]
                $scope.global.methodname = ""
            }
        }
    });
    $scope.$watch('global.modulename', function (post) {
        if($scope.global.modulename.length == 1) {
            $scope.global.intefaceoptions = []
            for (i in $scope.global.runcaselist[$scope.global.modulename])
                $scope.global.intefaceoptions.push(i)
            $scope.global.intefacename = ""
            $scope.global.methodoptions = []
            $scope.global.methodname = ""
        }
    });
    $scope.$watch('global.username', function (post) {
        if("" != $scope.global.username) {
            invokeService.jsonpcase(1, "", "", "", $scope.global.username).success(function (resdata, status, headers) {
                $scope.global.runcaselist = resdata['tree']
                $scope.global.modulename = ""
                $scope.global.intefacename = ""
                $scope.global.methodname = ""
                $scope.global.moduleoptions = []
                $scope.global.intefaceoptions = []
                $scope.global.methodoptions = []

                for (m in resdata['tree'])
                    $scope.global.moduleoptions.push(m)
            });
        }
    });
    $scope.execute = function(){
        if(1 == $scope.global.modulename.length && 1 == $scope.global.intefacename.length && 1 == $scope.global.methodname.length){
            $scope.loading = !$scope.loading;
            $scope.runloading = true
            invokeService.jsonpcase(2,$scope.global.modulename,$scope.global.intefacename,$scope.global.methodname,$scope.global.username).success(function (resdata, status, headers) {
                tmp = "python main.py -p "+$scope.global.modulename+" -i "+$scope.global.intefacename+" -t "+$scope.global.methodname+"\n"
                $scope.global.output=tmp + resdata["result"]
                $scope.loading = !$scope.loading;
            });
        }else {
            alert("请重新选择！")
        }
    }
}]);

app.controller('goldpriceController', ['$scope', 'invokeService', function ($scope, invokeService) {
    $scope.show=true
    $scope.sysshow=false
    $scope.inputprice=""
    $scope.realprice=""
    $scope.syspriceinfo=""
    $scope.switch = function(){
        $scope.show = !$scope.show
    }
    $scope.getcacheprice = function() {
        invokeService.cacheget("realTimePrice").success(function (resdata, status, headers) {
            if (resdata.info.ok) {
                if(resdata['data']['data'] != 0 && resdata['data']['data'] != null) {
                    $scope.realprice = resdata['data']['data'] / 100
                }
            } else {
                alert(resdata.info.message)
            }
        });
    }
    $scope.getcacheprice()
    var timer = setInterval( $scope.getcacheprice , 3000);


    invokeService.getpricestatus().success(function (resdata, status, headers) {
        if (resdata.info.ok) {
            if(resdata['data']['data'] == 1){
                $scope.sysshow = true
            }
        }else{
            alert(resdata.info.message)
        }
    });

    $scope.myKeyup = function(event){
        if(event.key == "Enter"){
            invokeService.updateprice($scope.inputprice).success(function (resdata, status, headers) {
                if (resdata.info.ok) {
                    $scope.realprice=$scope.inputprice / 100
                    $scope.switch();
                    $scope.sysshow = true
                }else{
                    alert(resdata.info.message)
                }
            });
        }
    }

    $scope.switch2sysprice = function(){

        invokeService.switch2sysprice($scope.inputprice).success(function (resdata, status, headers) {
            if (resdata.info.ok) {
                $scope.sysshow = false
            }else{
                alert(resdata.info.message)
            }
        });
}

}]);

app.controller('calculatorController', ['$scope', 'invokeService', function ($scope, invokeService) {
    $scope.calculator={}
    $scope.calculator.goldweightnow=0
    $scope.calculator.avgpricenow=0
    $scope.calculator.price=0
    $scope.calculator.moneyprepared=0
    $scope.calculator.avgpricelator=0

    $scope.calculatorprice = function(){
        gold = $scope.calculator.moneyprepared / $scope.calculator.price
        money = $scope.calculator.goldweightnow * $scope.calculator.avgpricenow
        $scope.calculator.avgpricelator = (parseFloat(money) +parseFloat($scope.calculator.moneyprepared))/(parseFloat(gold)+parseFloat($scope.calculator.goldweightnow))
    }
    $scope.calculatormoney = function(){
        gold = $scope.calculator.moneyprepared / $scope.calculator.price
        money = $scope.calculator.goldweightnow * $scope.calculator.avgpricenow
        $scope.calculator.moneyprepared = (parseFloat(money) - parseFloat($scope.calculator.avgpricelator) * parseFloat($scope.calculator.goldweightnow ))
        * parseFloat($scope.calculator.price)/(parseFloat($scope.calculator.avgpricelator) - parseFloat($scope.calculator.price))
    }
}]);

app.controller('aliyunossController', ['$scope', 'invokeService', function ($scope, invokeService) {
    $scope.global={}
    $scope.global.clearRecords=[]
    $scope.global.selectfilename=""
    $scope.global.password=""
    $scope.showpasswordtip=false
    $scope.selectModel = function (m) {
        $scope.global.selectfilename=m
        $("#modelPasswordDialog").modal();
    };
    $scope.queryossfile = function(){
        invokeService.getLatestClearRecord(15).success(function (resdata, status, headers) {
            if (resdata.info.ok) {
                $scope.global.clearRecords=resdata['data']['data']
            }
        });
    }

    $scope.submitCase = function() {
        if ("111111" == $scope.global.password) {
            $("#modelPasswordDialog").modal("hide");
            $scope.global.password=""
            $scope.showpasswordtip = false
            $scope.queryossfile()
        } else {
            $scope.showpasswordtip = true
        }
    }
    $scope.queryossfile()
}]);


app.controller('toolController', ['$scope', 'invokeService', function ($scope, invokeService) {


    // 获取对象属性
    $scope.getProperty = function () {
        var className = $('#queryPropertyClassName').val();
        if (!className) {
            return;
        }

        invokeService.getProperty(className)
            .success(function (resdata, status, headers) {
                $('#queryPropertyResult').val(JSON.stringify(resdata.data.result));
            });

    };
}]);


app.controller('Ctrl', ['$scope', 'invokeService', function ($scope, invokeService) {
    $scope.className = 'com.taobao.ad.mdmp.service.CrowdService';
    $scope.methodName = 'createCrowdBatch';
    $scope.paramsList = '';
    $scope.invoke = function () {
        var paramArray = new Array();
        paramArray.push(1);

        var m = "{\"1\":[{\"tagId\":100003,\"optionGroupId\":1,\"values\":\"1,2,3\"},{\"tagId\":100004,\"optionGroupId\":2,\"values\":\"4,5,6\"}],\"2\":[{\"tagId\":100010,\"optionGroupId\":3,\"values\":\"7,8,9\"},{\"tagId\":100004,\"optionGroupId\":4,\"values\":\"11,12,13\"}]}";

        paramArray.push(m);
        paramArray.push(true);
        paramArray.push(true);

        var postData = {
            className: $scope.currentClassName,
            methodName: $scope.currentMethodName,
            paramsList: paramArray
        };

        invokeService.invoke(postData)
            .success(function (data, status, headers) {
                alert(data.info.message);
            })
    };
}]);
app.controller('merchantController', ['$scope', 'invokeService', function ($scope, invokeService) {
    $scope.merchant = {}
    $scope.merchant.merchant_code = ""
    $scope.merchant.merchant_name = ""
    $scope.merchant.account_id = ""
    $scope.merchant.account_id1 = ""
    $scope.merchant.account_id2 = ""
    $scope.show={}
    $scope.show.res = ""
    $scope.show.merchant_code={}
    $scope.show.merchant_name={}
    $scope.show.account_id={}
    $scope.show.signKey={}
    $scope.show.rate={}
    $scope.show.buyFee={}
    $scope.show.saleFee={}
    $scope.show.taxFeeRate={}
    $scope.show.processFeeRate={}
    $scope.show.insuranceFeeRate={}
    $scope.show.expressFeeRate={}
    $scope.show.insuranceFeeWave={}
    $scope.show.res2 = ""
    $scope.show.userId={}
    $scope.show.totalMoney={}
    $scope.show.totalGoldWeight={}
    $scope.show.totalFinanceMoney={}
    $scope.show.status={}
    $scope.regist = function () {
        if (null != $scope.merchant.merchant_code&&null != $scope.merchant.merchant_name&&null != $scope.merchant.account_id) {
            invokeService.addmerchant($scope.merchant.merchant_code, $scope.merchant.merchant_name, $scope.merchant.account_id).success(function (resdata, status, headers) {
                if (true == resdata.info.ok) {
                    alert(resdata['info']['message'])
                } else {
                    alert(resdata['info']['message'])
                }
            });
        }
    };
    $scope.qurry = function () {
        if (null != $scope.merchant.account_id1) {
            invokeService.addqurrymerchant($scope.merchant.account_id1).success(function (resdata, status, headers) {
                if (true == resdata.info.ok) {
                    $scope.show.merchant_code = resdata['data']['data']['merchantCode']
                    $scope.show.merchant_name = resdata['data']['data']['merchantName']
                    $scope.show.account_id = resdata['data']['data']['accountId']
                    $scope.show.signKey = resdata['data']['data']['signKey']
                    $scope.show.rate = resdata['data']['data']['rate']
                    $scope.show.buyFee = resdata['data']['data']['buyFee']
                    $scope.show.saleFee = resdata['data']['data']['saleFee']
                    $scope.show.taxFeeRate = resdata['data']['data']['taxFeeRate']
                    $scope.show.processFeeRate = resdata['data']['data']['processFeeRate']
                    $scope.show.insuranceFeeRate = resdata['data']['data']['insuranceFeeRate']
                    $scope.show.expressFeeRate = resdata['data']['data']['expressFeeRate']
                    $scope.show.insuranceFeeWave = resdata['data']['data']['insuranceFeeWave']
                    $scope.show.res = "商户编码 :" + $scope.show.merchant_code + "\n商户名称:" + $scope.show.merchant_name + "\n账户id:" + $scope.show.account_id
                    + "\n密钥:" + $scope.show.signKey + "\n利率:" + $scope.show.rate + "\n买金手续费:" + $scope.show.buyFee + "\n卖金手续费:" + $scope.show.saleFee
                    + "\n税费:" + $scope.show.taxFeeRate + "\n加工费:" + $scope.show.processFeeRate + "\n保险费:" + $scope.show.insuranceFeeRate + "\n快递费:" + $scope.show.expressFeeRate
                    "\n保价费误差百分比:" + $scope.show.insuranceFeeWave
                } else {
                    alert(resdata['info']['message'])
                }
            });
        }

    };
    $scope.qurry2 = function () {
        if (null != $scope.merchant.account_id2){
            invokeService.addqurrymerchantAccount($scope.merchant.account_id2).success(function (resdata, status, headers) {
                if (true == resdata.info.ok) {
                    $scope.show.userId=resdata['data']['data']['userId']
                    $scope.show.totalMoney=resdata['data']['data']['totalMoney']
                    $scope.show.totalGoldWeight=resdata['data']['data']['totalGoldWeight']
                    $scope.show.totalFinanceMoney=resdata['data']['data']['totalFinanceMoney']
                    $scope.show.status=resdata['data']['data']['status']
                    $scope.show.res2 = "商户编码 :"+$scope.show.userId +"\n商户总金额:"+$scope.show.totalMoney+"\n账户总金重:"+$scope.show.totalGoldWeight
                    +"\n账户理财总金额:"+$scope.show.totalFinanceMoney+"\n账户状态（1是正常）:"+$scope.show.status
                } else {
                    alert(resdata['info']['message'])
                }
            });
        }
    };
    $scope.resetm = function () {
        $scope.merchant = {
            merchant_name: null,
            merchant_code: null,
            account_id: null
        };
    };
    $scope.resetms = function () {
        $scope.merchant = {
            account_id1: null
        };
        $scope.show = {
            res: null
        };
    };
    $scope.resetms2 = function () {
        $scope.merchant = {
            account_id2: null
        };
        $scope.show = {
            res2: null
        };
    };

}]);

app.controller('AccountUtilController', ['$scope', 'invokeService', function ($scope, invokeService) {

    $scope.cashaddtel ={
        telephone : '',
        money : ''
    };

    $scope.goldaddtel ={
        telephone : '',
        goldWeight : ''
    };
    $scope.cashaddacc ={
        money : '',
        accountId: ''
    };

    $scope.goldaddacc ={
        goldWeight : '',
        accountId: ''
    };
    $scope.addCashTel = function (p) {
        // if(! /^1\d{10}$/g.test($scope.cashaddtel.telephone)) {
        //     alert("手机号格式错误");
        //     return;
        // }

        invokeService.addCashByTel($scope.cashaddtel.telephone, $scope.cashaddtel.money).success(function (resdata, status, headers) {
            if(true == resdata.info.ok)
                alert("加钱成功!")
            else
                alert("加钱失败!")
        });
    };

    $scope.addCashAccount = function (p) {
        // if(! /^1\d{10}$/g.test($scope.cashadd.telephone)) {
        //     alert("手机号格式错误");
        //     return;
        // }

        invokeService.addCashByAccount($scope.cashaddacc.accountId, $scope.cashaddacc.money).success(function (resdata, status, headers) {
            if(true == resdata.info.ok)
                alert("加钱成功!")
            else
                alert("加钱失败!")
        });
    };

    $scope.addGoldTel = function (p) {

        invokeService.addGoldByTel($scope.goldaddtel.telephone, $scope.goldaddtel.goldWeight).success(function (resdata, status, headers) {
            if(true == resdata.info.ok)
                alert("加金成功!")
            else
                alert("加金失败!")
        });
    };

    $scope.addGoldAccount = function (p) {
        // if(! /^1\d{10}$/g.test($scope.cashadd.telephone)) {
        //     alert("手机号格式错误");
        //     return;
        // }

        invokeService.addGoldByAccount($scope.goldaddacc.accountId, $scope.goldaddacc.goldWeight).success(function (resdata, status, headers) {
            if(true == resdata.info.ok)
                alert("加金成功!")
            else
                alert("加金失败!")
        });
    };


}]);


