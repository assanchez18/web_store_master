function goHome() {
	window.location.href = '/';
}

function goNewOrder() {
	window.location.href = '/Orders/New';
}

function addElement(){
	var fieldWrapper = $(document.getElementById('newItemForm').getElementsByTagName('tbody')[0]);
	var newItem = $("<tr>"
			+ "<th scope=\"col\">Elemento</th>"
			+ "<td scope=\"col\"><input class=\"form-control rounded-0 notEmpty\" placeholder=\"elemento...\" type='text' name='element[]' value=''> </td>"
			+ "<td class=\"delete\" text-right\"><button  type=\"button\" class=\"btn btn-sm btn-danger\"><i class=\"fa fa-trash\"></i></button></td>"
			+ "</tr>");
	fieldWrapper.append(newItem);
	$("#newItemForm").append(fieldWrapper);
}

$(document).on("click",'.delete',function(){
	   $(this).closest('tr').remove(); 
	});
