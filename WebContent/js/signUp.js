$(document).ready(function(){
	
	//解析活动id
	var aid = location.href.substr(location.href.indexOf('=')+1);
	$("#aid").val(aid);
	
	var files =[];
	$("#add").change(function(){
		var file = this.files[0];
		files.push(file);
		//文件预览
		//1. 创建一个filereader对象
		var fileReader = new FileReader();
		//2. 定义filereader的onload方法（ base64字符串）
		//append(<img src="base64字符串">)
		fileReader.onload = function(e)
		{
			var base64 = e.target.result;
			$("#photoes").append('<img class="addedphoto" src="'+base64+'"/>');
		}
		//3. 读
		fileReader.readAsDataURL(file);
	})
	
	
	//报名
	$("#btn_signUpNew").click(function(){
		
		var formData = new FormData(document.getElementById("myform"));
		for(var i=0;i<files.length;i++){
			formData.append("upload",files[i]);
		}
	
		$.ajax({
			url:'saveCandidate',
			type:'post',
			data:formData,
			dataType:'json',
			contentType:false,
			processData:false,
			success:function(data){
				alert("报名成功");
			}
		});
	})
	
	$("#gohome").click(function(){
		location.href="index.html?aid="+aid;
	})
	
	
})


