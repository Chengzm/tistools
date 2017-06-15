/**
 * Created by wangbo on 2017/6/13.
 */

MetronicApp.factory('application_service',['$http', '$q', function ($http,$q) {
    var service={};

    //��������
    service.createAcApp = function (subFrom) {
        var res = $http.post(manurl + "/AcAppController/appAdd",subFrom).then(function (response) {
            return response.data;
        });
        return res;
    };

    //��ѯ����
    service.query = function (subFrom) {

        var res = $http.post(manurl + "/AcAppController/appQuery",subFrom).then(function (response) {
            return response.data;
        });
        return res;
    }
    //ɾ������
    service.delete = function(item){
        var res = $http.post(manurl + "/AcAppController/appDel",item).then(function (response) {
            return response.data;
        });
        return res;
    }



    return service;
}]);
