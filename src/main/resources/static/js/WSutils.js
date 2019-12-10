function goHome() {
	window.location.href = '/';
}

function goNewOrder() {
	window.location.href = '/Orders/New';
}

function addElement() {
	var fieldWrapper = $(document.getElementById('newItemForm')
			.getElementsByTagName('tbody')[0]);
	var newItem = $("<tr>"
			+ "<th scope=\"col\">Elemento</th>"
			+ "<td scope=\"col\"><input class=\"form-control rounded-0 notEmpty\" placeholder=\"elemento...\" type='text' name='element[]' value='' required> </td>"
			+ "<td><button id=\"deleteButton\" type=\"button\" class=\"btn btn-sm btn-danger delete\" ><i class=\"fa fa-trash\"></i></button></td>"
			+ "</tr>");
	fieldWrapper.append(newItem);
	$("#newItemForm").append(fieldWrapper);
	trashButtonController();
}

function trashButtonController() {
	if($('.delete').length == 1){
		$("#deleteButton").attr("disabled", "disabled");
	}
	else{
		$("#deleteButton").attr("disabled", false);
	}
}

$(document).on("click", '.delete', function() {
	$(this).closest('tr').remove();
	trashButtonController();
});

function sureToRemove(id) {
	if(confirm("Seguro que quieres borrar")) {
		window.location.href = '/delete/' + id;
	}
}
