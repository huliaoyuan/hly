
$(function(){
	  $(".treeview-menu li ").on("click",function(){  
	      $(".treeview-menu li").removeClass("active");
	      $(".treeview").removeClass("active");
	         $(this).addClass("active");
	         $(this).parent().parent().addClass("active");
	    });  
		
});
function transfer(obj){
         $("#mainContent").load(obj.getAttribute("hre")); 
      };
      function save(){          
         
          var url=$("#submitForm").attr("action");
          var ret=$("#submitForm").attr("ret");
          
          $.ajax({
              url:url,
              data:$("#submitForm").serializeArray(),
              success:function(data)
              {
                  //$('#showModal').modal('hide');
                  layer.msg('提交成功', {icon: 1,time:800});
                  $("#mainContent").load(ret);
                   
              }
                             
            
          
          });
         
      }       
  
      
      

