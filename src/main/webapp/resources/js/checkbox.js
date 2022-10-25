/**
 * checkbox script
 */
 
	$(document).ready(function() {
		$(".cbx_chkAll").click(function() {
			if($(".cbx_chkAll").is(":checked")) $("input[name=chBox]").prop("checked", true);
			else $("input[name=chBox]").prop("checked", false);
		});
		
		$("input[name=chBox]").click(function() {
			var total = $("input[name=chBox]").length;
			var checked = $("input[name=chBox]:checked").length;
			
			if(total != checked) $(".cbx_chkAll").prop("checked", false);
			else $(".cbx_chkAll").prop("checked", true); 
		});
	});
