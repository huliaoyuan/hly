 $(function(){
	 $("#checkAll").on("click",function() {
			if ($(this).prop("checked") === true) {
				$("input[name='checkList']").prop("checked",
						$(this).prop("checked"));
				$(this).hasClass('selected');
			} else {
				$("input[name='checkList']").prop("checked", false);
				$("table tbody tr").removeClass('selected');
			}
		});
 });
function search(){		    
	  setValue();	  
	  url=url+value;
	  $("#mainContent").load(url); 	  	
	}
function pageSkip(obj) {
	 setValue();		 	
	 var url=$("#listSubmitUrl").attr("action");
     var pageNo = $(obj).attr("value");
	 url = url+"?1=1&pageNo="+pageNo+value;
     $("#mainContent").load(url);
	}	
	
function add(url) {
  $("#mainContent").load(url);
}
function edit(id,url) {
  var url = url+"?id=" + id;
  $("#mainContent").load(url);
}
	/* 删除 */
function del(id,url,refurl){
	layer.confirm('确认要删除吗？',function(index){
	      $.ajax({
	       url:url,
	       type:"post",
	       data:{id:id},
	       dataType:"json",
	       success:function(data){
	       if(data.flag=="true"){
	        layer.msg('已删除!',{icon:1,time:1000});	          
	       }else{
	        layer.msg('删除失败!',{icon:2,time:1000});	          	        
	       }
	       $("#mainContent").load(refurl);	       
	       }
	     }); 
	});
}

function show(id,url){
	
      $("#showModal").modal({
                 remote:url+"?id="+id
     }); 
     $("#showModal").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    }); 		
}
	