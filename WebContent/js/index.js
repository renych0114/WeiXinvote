$(document).ready(function(){
	//解析活动id
	var aid = location.href.substr(location.href.indexOf('=')+1);
	//发送ajax请求，更新活动的访问量
	$.ajax({
		url:'updateActivityAccess/'+aid,
		type:'post',
		data:{},
		dataType:'json',
		success:function(data){
			console.log(data);
		}
	});
	var end;
	var taskid;
	//ajax  查询活动基本信息
	$.ajax({
		url:'selectActivityById/'+aid,
		type:'post',
		data:{},
		dataType:'json',
		success:function(data){
			console.log(data);
			$("#imgurl").attr("src","img/"+data.imgurl);
			$("#totalpeople").html(data.totalpeople);
			$("#totaltickets").html(data.totalticket);
			$("#totalaccess").html(data.totalaccess);
			
			var begin = data.begintime;
			end = data.endtime;
			var now = new Date();
			
			if(now<begin){
				$("#status").html("活动未开始");
				$("#countdown").html("活动开始时间为"+begin);
			}else if(now>end){
				$("#status").html("活动已结束");
				$("#countdown").html("0天0小时0分0秒");
			}else{
				$("#status").html("活动正在进行");
				taskid = setInterval(countdown,1000);
			}
			
		}
	});
	
	
	function countdown(){
		var now = new Date();
		if(now>=end){
			$("#status").html("活动已结束");
			clearInterval(taskid);
		}else{
			//计算两个时间间隔的毫秒数
			var c = end-now;
			var seconds = parseInt(c/1000%60);
			var minutes = parseInt(c/1000/60%60);
			var hours = parseInt(c/1000/60/60%24);
			var days = parseInt(c/1000/60/60/24);
			$("#countdown").html(days+"天"+hours+"小时"+minutes+"分钟"+seconds+"秒");
		}
	}
	
	//查询指定活动的选手信息，第一页  4个选手
	var pagesize=4;
	var pagenum=1;
	loadCandidates();
	
	
	function loadCandidates(){
		$.ajax({
			url:'selectCandidate/'+aid+"/"+pagenum+"/"+pagesize,
			type:'post',
			data:{},
			dataType:'json',
			success:function(data){
				pagenum++;
				console.log(data);
				if(data.length==0){
					alert("没有更多选手数据");
				}else{
					for(var i=0;i<data.length;i++){
						var cdata = "<div class='c_data' data-id='"+data[i].cid+"'   ><img src='img/"+data[i].imgurl+"' /><div>"+data[i].name+","+data[i].cid+"号,"+data[i].tickets+"票</div></div>";
						$("#div2_3").append(cdata);
					}
				}
			}
		});
	}
	
	
	//点击加载更多查询下一页数据
	$("#div2_4").click(function(){
		loadCandidates();
	})
	
	//搜索功能
	$("#btn_search").click(function(){
		var inputName = $("#search_txt").val();
		if(inputName==""){
			alert("请输入您要查询的条件");
		}else{
			$.ajax({
				url:'selectCandidateByName/'+inputName,
				type:'post',
				data:{},
				dataType:'json',
				success:function(data){
					console.log(data);
					$("#div2_3").empty();
					for(var i=0;i<data.length;i++){
						var cdata = "<div class='c_data' data-id='"+data[i].cid+"'   ><img src='img/"+data[i].imgurl+"' /><div>"+data[i].name+","+data[i].cid+"号,"+data[i].tickets+"票</div></div>";
						$("#div2_3").append(cdata);
					}
					//隐藏点击加载更多
					$("#div2_4").hide();
				}
			});
		}
	})
	
	
	//点击我要报名和下放导航的报名  都进入报名页面
	$("#btn_signup").click(function(){
		window.location.href="signUp.html?aid="+aid;
	})
	
	$("#signUp_bottom").click(function(){
		window.location.href="signUp.html?aid="+aid;
	})
	
	$(document).on("click",".c_data",function(){
		var cid = $(this).attr("data-id");
		location.href="details.html?aid="+aid+"&cid="+cid;
	})
	
	
	
	
})






