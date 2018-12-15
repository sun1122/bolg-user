/**
 * Bolg main JS.
 * Created by waylau.com on 2017/3/9.
 */
"use strict";
//# sourceURL=main.js

// DOM 加载完再执行
//$(function(){ }是$(document).ready(function()的简写，相当于window.onload = function(){ } ,
//虽然这段jquery代码与javascript代码在功能上可以互换，但执行的时间不一样，
//前者页面框架加载完成就执行，后者页面中所有内容加载完成才执行
$(function() {

	// 菜单事件
	$(".menu .list-group-item").click(function() {
		var url = $(this).attr("url");//获取地址url
		// 先移除其他的点击样式，再添加当前的点击样式
		$(".blog-menu .list-group-item").removeClass("active");
		$(this).addClass("active");
		
		//加载其他模块的页面 到右侧区域
		$.ajax({
			url: url,
			success: function(data){
				$("#rightContainer").html(data);
			},
			error: function(){
				alert("error");
			}
		});
	});
	// 选中菜单第一项
    $(".blog-menu .list-group-item:first").trigger("click");

});