/**
 * Created by wangbo on 2017/6/13.
 */
MetronicApp.factory('application_service',['$http', '$q', function ($http,$q) {
    var service={};
    //����Ӧ�÷���
    service.appAdd = function (subFrom) {
        var res = $http.post(manurl + "/AcAppController/appAdd",subFrom).then(function (response) {
            return response.data;
        });
        return res;
    };
    //ɾ��Ӧ�÷���
    service.appDel = function(item){
        var res = $http.post(manurl + "/AcAppController/appDel",item).then(function (response) {
            return response.data;
        });
        return res;
    }

    //��ѯӦ�÷���
    service.appQuery = function (subFrom) {
        var res = $http.post(manurl + "/AcAppController/appQuery",subFrom).then(function (response) {
            return response.data;
        });
        return res;
    }
    //�޸�Ӧ�÷���
    service.appEdit = function (subFrom) {
        var res = $http.post(manurl + "/AcAppController/appEdit",subFrom).then(function (response) {
            return response.data;
        });
        return res;
    }

    /*���������*/
    //���������顢�ӹ�����
    service.groupAdd = function (item) {
        var res = $http.post(manurl + "/AcAppController/groupAdd",item).then(function (response) {
            return response.data;
        });
        return res;
    };

    //ɾ�������顢�ӹ�����
    service.groupDel = function (item) {
        var res = $http.post(manurl + "/AcAppController/groupDel",item).then(function (response) {
            return response.data;
        });
        return res;
    };

    //��ѯ�����顢�ӹ�����
    service.groupQuery = function (item) {
        var res = $http.post(manurl + "/AcAppController/groupQuery",item).then(function (response) {
            return response.data;
        });
        return res;
    };


    //�޸Ĺ����顢�ӹ�����
    service.groupEdit = function (item) {
        var res = $http.post(manurl + "/AcAppController/groupEdit",item).then(function (response) {
            return response.data;
        });
        return res;
    };

    /* ���ܷ���*/
    //�������ܷ���
    service.acFuncAdd = function (item) {
        var res = $http.post(manurl + "/AcAppController/acFuncAdd",item).then(function (response) {
            return response.data;
        });
        return res;
    };

    //�޸Ĺ��ܷ���
    service.acFuncEdit = function (item) {
        var res = $http.post(manurl + "/AcAppController/acFuncEdit",item).then(function (response) {
            return response.data;
        });
        return res;
    };
    //ɾ�����ܷ���
    service.acFuncDel = function (item) {
        var res = $http.post(manurl + "/AcAppController/acFuncDel",item).then(function (response) {
            return response.data;
        });
        return res;
    };

    //���ܲ�ѯ����
    service.acFuncQuery = function (item) {
        var res = $http.post(manurl + "/AcAppController/acFuncQuery",item).then(function (response) {
            return response.data;
        });
        return res;
    };



  /*  //��Դ��ѯ����
    service.resoQuery = function (item) {
        var res = $http.post(manurl + "/AcAppController/resoQuery",item).then(function (response) {
            return response.data;
        });
        return res;
    };

    //�������ͷ���
    service.funtypeQuery = function (item) {
        var res = $http.post(manurl + "/AcAppController/funtypeQuery",item).then(function (response) {
            return response.data;
        });
        return res;
    };

    //������Ϊ
    service.funSearch = function (item) {
        var res = $http.post(manurl + "/AcAppController/funSearch",item).then(function (response) {
            return response.data;
        });
        return res;
    };*/
    return service;
}]);
