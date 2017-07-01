
/**
 * Select2 Remote Patient
 * @param selectId
 * @param modalId
 * @param url
 * @returns
 */
function selectRemotePatient(selectId, modalId, url) {
	$.fn.select2.defaults.set('language', 'fr');
	$(selectId).select2({
		dropdownParent: $(modalId), 
		placeholder: 'Chercher Patient par NoDossier, Nom, Telephone, Courriel',
		allowClear : true,
		ajax : {
			url : url,
			dataType : 'json',
			delay : 250,
			data : function(params) {
				return {
					motCle : params.term
				};
			},
			processResults : function(data) {
				return {
	                results: data.liste
	            };
			},
			cache : true
		},
		escapeMarkup : function(markup) {
			return markup;
		}, 
		minimumInputLength : 3,
		templateResult : function (option) {
			var markup =   
			"<div class='row'>" +
			    "<div class='col-xs-3'>"+
			    	"<img class='img-circle img-sm'  src='/safemedtheme/dist/img/profil10.jpg' alt='Patient Profil'/>"+
			    "</div>"+
			    "<div class='col-xs-9'>"+
			      "<span style='font-weight : bold;'>" + option.nomComplet + "</span>"+
			      "<br/>"+
			      "<span class='text-muted'><small>No Dossier : " + option.noDossier + "</small></span>"+
			      "<br/>"+
			      "<span class='text-muted'><small>N&eacute; en " + moment(option.dateNaissance).format("MMMM YYYY") + "</small></span>"+
			   "</div>"+
			  "</div>";
			  
			  return markup;
		},
		templateSelection : function (option) {
            return option.nomComplet;
        }
	});
}

/**
 * Select2 Remote Utilisateur
 * @param selectId
 * @param modalId
 * @param url
 * @returns
 */
function selectRemoteUtilisateurs(selectId, modalId, url) {
	$.fn.select2.defaults.set('language', 'fr');
	$(selectId).select2({
		dropdownParent: $(modalId), 
		placeholder: 'Chercher Personnel par mot-cle',
		allowClear : true,
		ajax : {
			url : url,
			dataType : 'json',
			delay : 250,
			data : function(params) {
				return {
					motCle : params.term
				};
			},
			processResults : function(data) {
				return {
	                results: data.liste
	            };
			},
			cache : true
		},
		escapeMarkup : function(markup) {
			return markup;
		}, 
		minimumInputLength : 3,
		templateResult : function (option) {
			var markup =   
				"<div class='row'>" +
				    "<div class='col-xs-2'>"+
				    	"<img class='img-circle img-sm'  src='/safemedtheme/dist/img/profil10.jpg' alt='Patient Profil'/>"+
				    "</div>"+
				    "<div class='col-xs-10'>"+
				      "<span style='font-weight : bold;'>" + option.nomComplet + "</span>"+
				      "<br/>"+
				      "<span class='text-muted'><small>" + option.fonction +" / " + option.nomService +"</small></span>"+
				   "</div>"+
				  "</div>";
				  
				  return markup;
			},
		templateSelection : function (option) {
            return option.nomComplet;
        }
	});
}

/**
 * Permet d'editer une DME task 
 * @param param
 * @returns
 */
function editTask(param) {
	getWithParamAndDisplayModal('/personnel/task/get', '#modalTask',
			'#content', 'Edition de Tache', param);
}

function newTask() {
	getAndDisplayModal('/personnel/task/form', '#modalTask', '#content',
			'Nouvelle Tache');
}

function newRv(start, end) {
	getWithParamAndDisplayModal('/agenda/schedule/rv/form', '#modalrv', '#content', 'Nouveau RV',{debut : start, fin : end});
}
function editRv(param, titre) {
	getWithParamAndDisplayModal('/agenda/schedule/rv/get', '#modalrv', '#content', titre, param);
}

function getAndDisplayModal(url, modalId, modalContentId, titre, param) {
	baseGET(url, function(form) {
		$(modalId).on('show.bs.modal', function(event) {
			var modal = $(this)
			$(modalContentId).html(form);
			modal.find('.modal-title').text(titre)
		});
		$(modalId).modal("show");
	});
}

function getWithParamAndDisplayModal(url, modalId, modalContentId, titre, param) {
	baseGET(url, param, function(form) {
		$(modalId).on('show.bs.modal', function(event) {
			var modal = $(this)
			$(modalContentId).html(form);
			modal.find('.modal-title').text(titre)
		});
		$(modalId).modal("show");
	});
}

function submitModal(formId) {
	$.post(url, formId, callback);
}

function baseGET(url, data, callback) {
	$.get(url, data, callback);
}

function basePOST(url, data, callback) {
	$.post(url, data, callback);
}

function ajaxGETAndOpenDialog(titre, url) {
	$.get(url, function(form) {
		showFormDialog(titre, form);
	});
}

function showFormDialog(titre, form) {
	BootstrapDialog.show({
		type : BootstrapDialog.TYPE_DEFAULT,
		title : titre,
		message : form,
		draggable : false,
		buttons : [ {
			label : 'Fermer',
			cssClass : 'btn-default',
			action : function(dialogItself) {
				dialogItself.close();
			}
		}, {
			label : 'Enregistrer',
			cssClass : 'btn-info',
			action : function(dialog) {
				$('form').submit();
			}
		} ]
	})
}

/**
 * Fonction permettant de se transposer vers un URL quelconque sans soumettre
 * les données de la page.
 * 
 * @param url
 *            l'URL vers lequel on déplace l'utilisateur.
 */
function goToUrl(url) {
	self.location.href = url;
}

/**
 * Fonction permettant de spécifier l'action du formulaire à utiliser et ensuite
 * de faire un POST du formulaire.
 * 
 * @param url
 *            l'URL vers lequel on soumet les données du formulaire.
 * @param formId
 *            l'identifiant (sélecteur JQuery) permettant de récupérer le
 *            formulaire
 */
function postFormToUrl(url, formId) {
	$(formId).attr("action", url);
	$(formId).submit();
}

/**
 * Fonction permettant de de faire un appel au serveur de type "POST" et de
 * rafraichir une partie d'écran avec la valeur de retour.
 * 
 * @param url
 *            l'URL à appeler en AJAX.
 * @param divId
 *            l'identifiant du DIV qui sera rafraîchi. Cette valeur est un
 *            sélecteur JQuery valide.
 */
function ajaxPOSTAndRefresh(url, divId) {
	baseAjaxPOST(url, formulaireSelector, divId);
}

/**
 * Fonction permettant de de faire un appel au serveur de type "GET" et de
 * rafraichir une partie d'écran avec la valeur de retour.
 * 
 * @param url
 *            l'URL à appeler en AJAX.
 * @param divId
 *            l'identifiant du DIV qui sera rafraîchi. Cette valeur est un
 *            sélecteur JQuery valide.
 */
function ajaxGETAndRefresh(url, divId) {
	baseAjaxGET(url, function(data) {
		$(divId).html(data);
	});
}

function ajaxGetRefreshAndModal(url, divId, modalId) {
	baseAjaxGET(url, function(data) {
		$(divId).html(data);
		$(modalId).modal();
	});
}

/**
 * Fonction permettant de de faire un appel AJAX au serveur et de rafraichir une
 * partie d'écran avec la valeur de retour.
 * 
 * @param url
 *            l'URL à appeler en AJAX.
 * @param divId
 *            l'identifiant du DIV qui sera rafraîchi. Cette valeur est un
 *            sélecteur JQuery valide.
 * @param type
 *            le type 'GET' ou 'POST' utilisé.
 * @param callback
 *            la fonction appelée si l'appel ajax est un succès
 */
function baseAjaxGET(url, callback) {
	$
			.ajax({
				url : url,
				dataType : "html",
				cache : false,
				data : null,
				type : 'GET',
				/*
				 * beforeSend:function(jqXHR, settings){ initSessionTimeouts(); },
				 */
				success : callback,
				error : function(xmlHttp, textStatus) {
					alert('Une erreur est survenue lors de l\'appel.  Veuillez reéssayer.');
				}
			});
}

function baseAjaxPOST(url, formId, divId) {
	$
			.ajax({
				url : url,
				dataType : "html",
				cache : false,
				data : $(formId).serialize(),
				type : 'POST',
				/*
				 * beforeSend:function(jqXHR, settings){ initSessionTimeouts(); },
				 */
				success : function(data) {
					$(divId).html(data);
				},
				error : function(xmlHttp, textStatus) {
					alert('Une erreur est survenue lors de l\'appel.  Veuillez reéssayer.');
				}
			});
}

/**
 * Fonction qui permet d'activer la fonctionnalité qui fait qu'on affiche un
 * message de confirmation à l'utilisateur avant de quitter une page si cette
 * dernière a eu des modifications.
 * <p>
 * Pour que cette fonctionnalité fonctionne, vous devez mettre l'attribut
 * "check_input_changes_on_quit" à 'true' dans le fichier tiles.xml
 */
function activerCheckInputOnChange(formId) {
	if ($(formId).data("flagOnChange")) {
		// Permet de flagger tout changement sur un input de formulaire.
		// http://stackoverflow.com/a/3025505. --%>
		$(formId + " :input").change(function() {
			$(formId).data('changed', true);
		});
	}
}