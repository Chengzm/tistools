MetronicApp.directive('testRepeats', ['$http',function($http) {
    return {
        require: 'ngModel',
        link: function (scope, elm, attrs, ctrl) {
            var sem = $(elm).attr("comtasssble");
            ctrl.$formatters.push(function(viewValue){
                var sem = viewValue;//�õ�����
                var sum = 0;//��ʶ���жϵڼ���ѭ��
                var html = ''//�ַ���ģ��
                var num = sem;//����
                getArray(sem);
                function  getArray(data){
                    sum++;//��ʶ++
                    var sumer = sum+1;
                    if(!isNull(num)){
                        num = [];
                        for(var i=0;i< data.length;i++){
                            if(!isNull(data[i].children)){
                                num = num.concat(data[i].children);//�����е��Ӻϲ���һ�������С��������е���ȡ��
                            }
                        }
                    }
                    if(sum == 1){//sum�Ǳ�ʶ�����ֵ�һ��ѭ��
                        for(var i = 0;i<data.length;i++){
                            if(data[i].isLeaf == 'Y'){//����ǣ���ô�������һ��ѭ��
                                html +=  '<a href=" '+ data[i].href + '"><i class="'+data[i].icon+'"></i><span class="title">'+data[i].label+'</span></a><ul class="sub-menu ids'+ sumer +'" id="'+ data[i].guid +'"></ul>'
                            }else{//������ǣ���������ѭ����ʽ
                                html +=  '<a href="javascript:;"><i class="'+data[i].icon+'"></i><span class="title">'+data[i].label+'</span> <span class="arrow "></span></a><ul class="sub-menu ids'+ sumer +'" id="'+ data[i].guid +'"></ul>'
                            }
                        }
                        $(".ids" + sum).append(html);//׷�ӵ�li��
                    }
                    for(var j =0;j<data.length;j++){//ѭ�����õ���һ��,�뱾���������жϣ��ҵ���Ӧ�Ĳ㼶��guid��parentguidƥ��
                            var array = [];
                            for(var i =0; i<num.length;i++){//ѭ�����е��Ӽ���Ȼ�����ƥ��
                                if(data[j].guid == num[i].parentGuid){
                                    array.push(num[i]);
                                }
                            }
                            var htmltwo = '';//ģ���ʶ
                            array.forEach(function(v,i){
                                if(array[i].isLeaf =='Y'){//�Ƿ������һ�㣬����ǣ���ô�������һ�����ʽƴ��
                                    htmltwo += '<li><a  href="#/'+array[i].href + '"><i class="'+array[i].icon+'"></i><span class="title">'+array[i].label+'</span></a></li>'
                                }else{//���򣬰��շ����һ����ʽƴ��
                                    htmltwo += '<li class="start nav-item"><a  style="height: 41px;line-height: 31px;"   href="javascript:;"><i class="'+array[i].icon+'"></i><span class="title">'+array[i].label+'</span><span class="arrow "></span></a><ul class="sub-menu ids'+ sumer +'"id="'+ array[i].guid+'"></ul></li>'
                                }
                            })

                            $('#'+data[j].guid).append(htmltwo);//׷�ӵ���Ӧ�ĸ��ڵ�ı�ǩ��
                    }
                 /*   if(isNull(data.children)){//��ʶ,�����children,��ô��һֱ�ݹ���ȥ*/
                    if(sum<40){//��ʶ,�����children,��ô��һֱ�ݹ���ȥ
                        getArray(num);//�ݹ����
                    }else{
                        return num;
                    }
                }
            })
        }
    };
}]);