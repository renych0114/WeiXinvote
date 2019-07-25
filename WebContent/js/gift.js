$(document).ready(function(){
	
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
	
	//页面的初始化
	$.ajax({
		url:'selectGiftsByAid/'+aid,
		type:'post',
		data:{},
		dataType:'json',
		success:function(data){
			console.log(data);
			for(var i=0;i<data.length;i++){
				$("#div1").append("<div data-id='"+data[i].gid+"' class='g_data'><img src='img/"+data[i].imgurl+ "'/><p>"+data[i].giftname+"</p><p>点数："+data[i].point+"点</p><p>价钱："+data[i].price+"</p></div>");
			}
		}
	});
	
	var gid=0;
	$(document).on("click",".g_data",function(){
		$("[data-id='"+gid+"']").css("border","solid 1px gray");
		gid = $(this).attr("data-id");
		$(this).css("border","solid 1px blue");
		$("#giftcount").val("");
	})
	
	
	$("#gift").click(function(){
		if(gid==0 || $("#giftcount").val()==""){
			alert("请选择要送的礼物以及填写数量！")
		}else{
			$.ajax({
				url:'saveGiftForCandidate/'+aid+"/"+cid+"/"+gid+"/"+$("#giftcount").val(),
				type:'post',
				data:{},
				dataType:'json',
				success:function(data){
					console.log(data);
					alert("送礼物成功");
				}
			});
		}
		
	})
	
	
	$("#gohome").click(function(){
		location.href="index.html?aid="+aid;
	})
	
	
	
	
	
	
	
	
})

