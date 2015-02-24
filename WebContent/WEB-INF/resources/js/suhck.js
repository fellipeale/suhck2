$(document).ready(function() {

// maskedinput

	$("#cpf").mask("999.999.999-99");
	$("#cnpj").mask("99.999.999/9999-99");
	$("#telefone").mask("(99)9999-9999");
	$("#crm").mask("99999");

// bootbox
	
	$(".confirm").on("click", function(event) {
		if (!confirm("Voce tem certeza?")) {
			return false;
		}
//		event.preventDefault();
//	    bootbox.confirm({
//	            title: "Confirmar Remocao", //TODO - Consertar problema com o charset
//	            message: "Voce tem certeza?",
//	            buttons: {
//	                confirm: {
//	                    label: "Sim",
//	                    className: "btn-primary pull-right"
//	                },
//	                cancel: {
//	                    label: "Nao",
//	                    className: "btn-default pull-right"
//	                }
//	            },
//	            callback: function(result) {
//	                if (!result) {
//	                	
//	                }
//	            }
//	        });
	  });
	
//filtros
	
	$('.filter').keyup(function () {

        var rex = new RegExp($(this).val(), 'i');
        $('.searchable tr').hide();
        $('.searchable tr').filter(function () {
            return rex.test($(this).text());
        }).show();

    })
	
});