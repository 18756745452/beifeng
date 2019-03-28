$(function() {
	// //开始
	$(".go").click(
			function() {
				$.ajax({
					type : "post",
					url : "go",
					success : function(data) {
						var arr = data.list;
						var str = "";
						var info = $(".info");
						for (var i = 0; i < arr.length; i++) {
							// pid,pname,detail,price
							str += arr[i].pid + arr[i].pname + arr[i].pdetail
									+ arr[i].price + "<br/>";
						}
						info.html(str);
					}
				});
			});// click
	// /结束
});