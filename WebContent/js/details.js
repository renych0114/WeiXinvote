$(document).ready(function(){
	//截取路径中?后面的内容
	var str = location.href.substr(location.href.indexOf('?')+1);
	var arr = str.split('&');
	var aid;
	var cid;
	for(var i=0;i<arr.length;i++){
		if(arr[i].indexOf('aid')>-1){
			aid = arr[i].substr(arr[i].indexOf('=')+1);
		}
		if(arr[i].indexOf('cid')>-1){
			cid = arr[i].substr(arr[i].indexOf('=')+1);
		}
	}
	
	//初始化：更改选手的热度
	$.ajax({
		url:'updateCandidateHot/'+cid,
		type:'post',
		data:{},
		dataType:'json',
		success:function(data){
			console.log(data);
		}
	});
	
	
	//初始化：查询选手信息
		$.ajax({
			url:'selectCandidateById/'+cid,
			type:'post',
			data:{},
			dataType:'json',
			success:function(data){
				console.log(data);
				$("#imgurl").attr("src","img/"+data.imgurl);
				$("#cname").html(data.name);
				$("#cid").html(data.cid);
				$("#tickets").html(data.tickets);
				$("#hots").html(data.hots);
				$("#gifts").html(data.gifts);
				$("#cdeclaration").html(data.declaration);
				var images = data.images;
				if(images.length>0){
					for(var i=0;i<images.length;i++){
						$("#div2").append("<img src='img/"+images[i].imgurl+"' >")
					}
				}
		}
	});
	
	//回首页
	$("#gohome").click(function(){
		location.href="index.html?aid="+aid;
	})
	
	//投票功能
	$("#vote").click(function(){
		$.ajax({
			url:'voteCandidate/'+cid+"/"+aid,
			type:'post',
			data:{},
			dataType:'json',
			success:function(data){
				console.log(data);
				$("#tickets").html(parseInt($("#tickets").html())+1);
				alert("投票成功");
			}
		});
	})
	
	$("#gift").click(function(){
		location.href="gift.html?aid="+aid+"&cid="+cid;
	})
	
	
	
})








