<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation chambre</title>
 <link rel="stylesheet" href="CSS/Stylesdf20.css?v=S7xcjgo8A8qlW9x5oP-Phb232PMAMTWMtj_DOCdFm1A1" />
</head>
<body class="aval fr-fr">

<nav class="layout"> 
    <div class="purplegbackground">
        <div class="wrapper">
            <ul class="top-menu">
                <li class="logo">
                    
                </li>
            </ul>
<a href="accueil.jsp" style="position:relative; left:-100px"><img src="CSS/civin.png"></a>
        </div>
    </div>
    <div class="bottom-layout normal-header">
        <div class="wrapper"  style="position:relative; left:100px; top:-40px">
            <ul class="bottom-menu">
                
             <li class="sale">
                    <span class="menu-title" id="title_vendre" style="font-size:20px"><a href="accueil.jsp">ACCUEIL</a><span class="pic"><span></span></span></span>

  </li>
            
                
  <li class="sale">
                    <span class="menu-title" id="title_vendre" style="font-size:20px" ><a href="demande.jsp">DEMANDE</a><span class="pic"><span></span></span></span>

  </li>
                <li class="finance">
                    <span class="menu-title" id="title_financer" style="font-size:20px"><a href="offres.jsp">OFFRE</a><span class="pic"><span></span></span></span>

                </li>
                <li class="move">
                 <span class="menu-title" id="title_demenager" style="font-size:20px"><a href="inscription.jsp">INSCRIPTION</a><span class="pic"><span></span></span></span>
                    

                </li>
                 
                <li class="move">
                 <span class="menu-title" id="title_demenager" style="position:relative; left:45px; top:-5px"><a href="alerter.jsp"><img src="CSS/icon.png"><span class="pic"><span></span></span></span>
                    

                </li>
                
                      <li class="move">
                 <span class="menu-title" id="title_demenager" style="font-size:20px"><a href="#">d�connexion</a><span class="pic"><span></span></span></span>
                    

                </li>
                   

</ul>
</nav>
<div class="container-ep">
	<h1>Bienvenue sur votre espace Personnel</h1>
	<div class="colCtnr">
		<div class="col-menu" style="position:relative; top:30px">
    <div class="block-account" style="">
	    <div class="block-avatar">
		    <div class="avatarCtnr">
                <img src="CSS/avatar.jpg" width="62" height="64">
		    </div>
		    
	    </div>
        <div class="block-name">
            Bonjour<br/><span class="username"></span>
            
        </div>
            <p>Trouvez plus vite en compl�tant votre profil � 100%. &nbsp;<a href="#">Editer</a></p>
    </div>
    
</div>
		<div class="col-content">
			<h2>Mes alertes</h2>
			<section>
				<p class="pre-checklist">
					La recherche 24H/24H. Recevez chaque jour vos alertes par email. Depuis cet espace vous pouvez cr�er, modifier et supprimer vos alertes immobili�res.
			    </p>
				
				<div id="alertList">
					    <p>Vous n'avez pas encore cr�e d'alerte.</p>

<script>
    $(function() {
        $('.checktrue,.checkfalse').click(function () {
            var isChecked = true;
            var isPriceAlert = false;
            if ($(this).hasClass('checktrue')) {
                $(this).attr('class', 'checkfalse');
                isChecked = false;
            } else {
                $(this).attr('class', 'checktrue');
            }
            var alertTab = $(this).attr('id').split('-');
            if (alertTab[0] === "alP") {
                isPriceAlert = true;
            }
            var alertId = alertTab[1];
            
            $.ajax({
                type: 'POST',
                data: { alertEmailToken: getAlertEmailToken(), id: alertId, isActive: isChecked, isAlertPrice: isPriceAlert },
                url: '/Users/AlertEmail/UpdateStatusAlert',
                dataType: 'json',
                complete: function(data) {
                    if (!data) {
                        popError('Une erreur est survenue', 'Veuillez re�ssayer ult�rieurement', 2000);
                    } else {
                        popAlert('Informations', isChecked ? 'Votre alerte a �t� r�activ�e' : 'Votre alerte a �t� d�sactiv�e', 2000);
                    }
                },
            });
        });
    });
</script>

				</div>            
				              
				
				<div id="alert-link-manage" onClick="emailAlert('UserAlerts', 'UserAlerts', 0, 'ManageUserAlerts')" class="validBtn alert-mail cpointer">CREER UNE NOUVELLE ALERTE EMAIL</div>
			</section>
		</div>
	</div>
</div>

<span class="back-to-top" title="Remonter"></span>
<div class="pre-footer">
	<div class="wrapper">
		
			<div class="breadcrumb" id="footer-breadcrumb"></div>	
				<div class="bottom-mentions"></div>
	</div>
</div>
<footer>
 <div class="footer-brands-wrapper">
        <div class="brands">
            <a href="#" target="_blank" rel="nofollow">
                <div class="so-local"></div>
            </a>
            <a href="#" target="_blank" rel="nofollow">
                <div class="pages-jaunes"></div>
            </a>
            <a href="#" target="_blank" rel="nofollow">
                <div class="mappy"></div>
            </a>
            <a href="#" target="_blank" rel="nofollow">
                <div class="comprendre-choisir"></div>
            </a>
        </div>
    </div>
</footer>




    <div id="avlineContainer-Home-Habillage">
        <div class="avLineContent">
        </div>
    </div>

        <div class="hiddenappversion">20/07/2016 06:07:36 - Prod - AVAL-FO_001 - v3.4.7.47 - rev 6844edf</div>
        
        

        
        
        

</body>

</html>