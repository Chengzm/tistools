/**
 * Created by hasee on 2017/7/11.
 */
MetronicApp.factory('behavior_service',['$http', '$q', function ($http,$q) {
    var service={};
    //������Ϊ����
    service.functypeAdd = function (subFrom) {
        var res = $http.post(manurl + "/AcAppController/functypeAdd",subFrom).then(function (response) {
            return response.data;
        });
        return res;
    };

    //��ѯ������Ϊ����
    service.functypequery = function (subFrom) {
        var res = $http.post(manurl + "/AcAppController/functypequery",subFrom).then(function (response) {
            return response.data;
        });
        return res;
    };


    //�޸Ĺ�����Ϊ����
    service.functypeEdit = function (subFrom) {
        var res = $http.post(manurl + "/AcAppController/functypeEdit",subFrom).then(function (response) {
            return response.data;
        });
        return res;
    };


    //ɾ��������Ϊ����
    service.functypeDel = function (subFrom) {
        var res = $http.post(manurl + "/AcAppController/functypeDel",subFrom).then(function (response) {
            return response.data;
        });
        return res;
    };

    //����������Ϊ
    service.funactAdd = function (subFrom) {
        var res = $http.post(manurl + "/AcAppController/funactAdd",subFrom).then(function (response) {
            return response.data;
        });
        return res;
    }

    //�޸Ĺ�����Ϊ
    service.funactEdit = function (subFrom) {
        var res = $http.post(manurl + "/AcAppController/funactEdit",subFrom).then(function (response) {
            return response.data;
        });
        return res;
    }

    //ɾ��������Ϊ
    service.funactDel = function (subFrom) {
        var res = $http.post(manurl + "/AcAppController/funactDel",subFrom).then(function (response) {
            return response.data;
        });
        return res;
    }


    //�������͵�GUID��ѯ��Ϊ
    service.queryBhvDefByBhvType = function (subFrom) {
        var res = $http.post(manurl + "/AcAppController/queryBhvDefByBhvType",subFrom).then(function (response) {
            return response.data;
        });
        return res;
    };

    return service;
}]);
