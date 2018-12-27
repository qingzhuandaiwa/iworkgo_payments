


jQuery(document).ready(function($) {

       //选项卡
    $(".TAB_CLICK li").click(function() {
        var tab = $(this).parent(".TAB_CLICK");
        var con = tab.attr("id");
        var on = tab.find("li").index(this);
        $(this).addClass('on').siblings(tab.find("li")).removeClass('on');
        $(con).eq(on).show().siblings(con).hide();
    });
    
    // 弹出框
    $('.myfancy').click(function(){
        var _id = $(this).attr('href');
        $(_id).fadeIn("normal");
    });
    $('.pop-bg,.close,.mob-pop1 .btn').click(function(){
        $(this).parents('.m-pop').fadeOut("normal");
    });

    $('#btn-pop1').click(function(){
        var _id = $(this).attr('href');
        $(_id).fadeIn("normal");
    });
    // 返回顶部
    $('.r-top').click(function() {
        $('body,html').animate({
            'scrollTop': 0
        }, 500);
    });
    $(window).scroll(function() {
        var _top = $(window).scrollTop();
        if (_top < 100) {
            $('.r-top').stop().fadeOut(500);
        } else {
            $('.r-top').stop().fadeIn(500);
        }
    });
    //顶部导航
    $(".a-person").click(function(){
            $(this).siblings(".ul-nav").stop().slideToggle();
        })

});