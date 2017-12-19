/**
 * Created by daitian on 2017/7/23.
 */
new Vue({
    el: '#fh5co-main',
    data: {
        lists1:[],
        lists2:[],
        lists3:[],
        lists4:[]
    },
    created: function () {
        this.fetchData()
    },
    methods: {
        fetchData: function () {
            var self = this;
            axios.get(base.url+'redis/all').then(function (response) {
                var len =response.data.length
                var list = response.data;
                var list1=[],list2=[],list3=[],list4=[];
                for (var i=0 ;i<len;i++){
                    if(i%4==0){
                        list1.push(list[i]);
                    }else if(i%4==1){
                        list2.push(list[i]);
                    }else if(i%4==2){
                        list3.push(list[i]);
                    }else{
                        list4.push(list[i]);
                    }
                }
                self.lists1 = list1;
                self.lists2 = list2;
                self.lists3 = list3;
                self.lists4 = list4;
            });
        },
        add: function (v) {
            window.open(v);
        }
    }
});
//获取元素绝对位置
function getAbsPosition(element)
{
    var abs={x:0,y:0}

    //如果浏览器兼容此方法
    if (document.documentElement.getBoundingClientRect)
    {
        //注意，getBoundingClientRect()是jQuery对象的方法
        //如果不用jQuery对象，可以使用else分支。
        abs.x = element.getBoundingClientRect().left;
        abs.y = element.getBoundingClientRect().top;

        abs.x += window.screenLeft +
            document.documentElement.scrollLeft -
            document.documentElement.clientLeft;
        abs.y += window.screenTop +
            document.documentElement.scrollTop -
            document.documentElement.clientTop;

    }

    //如果浏览器不兼容此方法
    else
    {
        while(element!=document.body)
        {
            abs.x+=element.offsetLeft;
            abs.y+=element.offsetTop;
            element=element.offsetParent;
        }

        //计算想对位置
        abs.x += window.screenLeft +
            document.body.clientLeft - document.body.scrollLeft;
        abs.y += window.screenTop +
            document.body.clientTop - document.body.scrollTop;

    }

    return abs;
}
var app1 =new Vue({
    el: '#fh5co-offcanvass',
    data:{
        title:"请输入内容",
        url:"images/add.png"
    },
    methods:{
        sub:function () {
            var self =this;
            axios.post(base.url+'/redis/add',{title:self.title,url:self.url}).then(function () {
                self.url="images/add.png";
                self.title="请输入内容";
            })
        }
    }
});