layui.use(['layer','element','form'], function(){
    var layer = layui.layer
        ,form = layui.form;
    var element = layui.element;
    var $ = layui.$

    var isShow = true;  //定义一个标志位
    $('.kit-side-fold').click(function(){
        //选择出所有的span，并判断是不是hidden
        $('.layui-nav-item span').each(function(){
            if($(this).is(':hidden')){
                $(this).show();
            }else{
                $(this).hide();
            }
        });
        //判断isshow的状态
        if(isShow){
            $('.layui-side.layui-bg-black').animate({width:'60px'}); //设置宽度
            $('.layui-logo').animate({width:'60px'});
            $('.layui-logo span').hide();
            $('.layui-logo i').removeClass('layui-hide');
            //将footer和body的宽度修改
            $('.layui-body').css('left', 60+'px');
            $('.layui-footer').css('left', 60+'px');
            //将二级导航栏隐藏
            $('dd span').each(function(){
                $(this).hide();
            });
            //修改标志位
            isShow =false;
        }else{
            $('.layui-side.layui-bg-black').animate({width:'200px'});
            $('.layui-body').css('left', 200+'px');
            $('.layui-footer').css('left', 200+'px');
            $('.layui-logo').animate({width:'200px'});
            $('.layui-logo span').show();
            $('.layui-logo i').addClass("layui-hide");
            $('dd span').each(function(){
                $(this).show();
            });
            isShow =true;
        }
    });
});

