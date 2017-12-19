var uploader = Qiniu.uploader({
    runtimes: 'html5,flash,html4',      // 上传模式，依次退化
    browse_button: 'pickfiles',         // 上传选择的点选按钮，必需
    uptoken_url: '/token',         // Ajax请求uptoken的Url，强烈建议设置（服务端提供）
    get_new_uptoken: true,             // 设置上传文件的时候是否每次都重新获取新的uptoken
    domain: 'otf8o568i.bkt.clouddn.com',     // bucket域名，下载资源时用到，必需
    container: 'container',             // 上传区域DOM ID，默认是browser_button的父元素
    max_file_size: '100mb',             // 最大文件体积限制
    flash_swf_url: 'path/of/plupload/Moxie.swf',  //引入flash，相对路径
    max_retries: 3,                     // 上传失败最大重试次数
    dragdrop: true,                     // 开启可拖曳上传
    drop_element: 'container',          // 拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
    chunk_size: '4mb',                  // 分块上传时，每块的体积
    unique_names: true,                //自动生成文件名
    auto_start: true,                   // 选择文件后自动上传，若关闭需要自己绑定事件触发上传
    init: {
        'FileUploaded': function (up, file, info) {
            // 查看简单反馈
            var sourceLink = "http://"+up.getOption('domain') + "/" +  JSON.parse(info).key;
            app1.url=sourceLink;
        },
        'Error': function (up, err, errTip) {
            //上传出错时，处理相关的事情
        }
    }
});