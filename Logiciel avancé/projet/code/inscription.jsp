<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation chambre</title>
 <link rel="stylesheet" href="CSS/Stylesdf20.css?v=S7xcjgo8A8qlW9x5oP-Phb232PMAMTWMtj_DOCdFm1A1" />
     <script type="text/javascript" src="CSS/validation.js"></script>
</head>
<body class="aval fr-fr home">

<div id="smart-app-banner-ipad" style="display: none;">
    <div class="wrapper background-smartbanner-ipad">
        <div class="txt-button">
         
            <div id="btn-install-app-ipad"><a href="#">Télécharger</a>
            </div>
            <div id="btn-launch-app-ipad"><a>Ouvrir</a></div>
        </div>
        <div class="close-smartbanner">X</div>
    </div>
</div>
        <div id="headerMarqueBlanche"></div>
        



<nav class="layout"> 
    <div class="purplegbackground">
        <div class="wrapper">
            <ul class="top-menu">
                <li class="logo">
                    
                </li>
            </ul>
<a href="accueil.jsp"style="position:relative; left:-100px; "><img src="CSS/civin.png" /></a>
        </div>
    </div>
    <div class="bottom-layout normal-header">
        <div class="wrapper"  style="position:relative; left:120px; top:-40px">
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
                   <span class="menu-title" id="title_demenager" style="position:relative; left:100px; font-size:20px"><a href="connexion.jsp">SE CONNECTER</a><span class="pic"><span></span></span></span>

                </li>

          </ul>
</nav>
<div class="container-entrust">
    <div class="colCtnr">
        <div class="col-infos">
            <div class="main-title">
                Créez votre compte gratuitement<br/>et personnalisez votre recherche
            </div>
            <div class="infos account">
                <div class="block mail">
                    <div></div>
                    <p><strong>Créez votre alerte email</strong><br/>
                        L’alerte email vous permet de recevoir toutes <br/>les nouvelles annonces correspondant <br/>à votre recherche dès leur parution.
                    </p>
                </div>
                <div class="block star">
                    <div></div>
                    <p><strong>Sauvegardez vos recherches et annonces</strong><br/>
                        Sauvegardez vos recherches et annonces afin<br/> de les comparer, de les retrouver facilement et <br/>de les partager avec votre famille et vos amis.</p>
                </div>
                <div class="block paper">
                    <div></div>
                    <p><strong>Suivez l’actualité de l’immobilier</strong><br/>
                        Retrouvez toutes les informations et bons plans<br/>d’AVendreALouer. Prix de l’immobilier,<br/>conseils pratiques, informations juridiques,<br/> et tendances habitat.</p>
                </div>
                <div class="block mobile">
                    <div></div>
                    <p><strong>Rechercher aussi sur smartphone &amp; tablettes</strong><br/>
                        Téléchargez l’application mobile AVendreALouer.fr ou utilisez la version optimisée pour mobile. Recevez des notifications et trouvez sans rechercher.</p>
                </div>
            </div>
        </div>
        <div class="col-form">
            <div class="bloc-form">

					<div class="main-title">Inscription rapide</div>
					                    <div id="fb-root"></div>

					<div class="socials-signin">
                     
					</div>

					<div class="main-title">remplissez le formulaire</div>				


<form action=""  id="registrationForm" method="post" name="inscription" onsubmit="return valider ();">                    <p>
                        <input class="input-classic large mail"  id="User_Email" maxlength="50" name="UserEmail" placeholder="Email *" type="email" value="" />
                        <div id="subform">
                            <input class="input-classic large"  id="User_Name" maxlength="50" name="UserName" placeholder="Nom *" type="text" value="" />
                            <input class="input-classic large"  id="User_lastName" maxlength="50" name="UserlastName" placeholder="PrÃ©nom *" type="text" value="" />

                            <div id="User_PasswordContainer" class="container-pwd clear">
                                <input autocomplete="off" class="input-classic large mdp" id="User_Password" SIZE="8" MAXLENGTH="8" name="UserPassword" placeholder="Mot de passe (8 caractères minimum) *" type="password" />
                            
                            </div>
                            <div id="User_ConfirmPasswordContainer">
                            </div>

                            <input class="input-classic large" id="User_Zipcode" maxlength="10" name="UserZipcode" placeholder="Code Postal *" type="text" value="" />
                            <div id="User_ProfilsContainer">
                               
                            </div>
                            <div class="recaptchaCtnr">
                                <script type="text/javascript">
var RecaptchaOptions = {
theme : 'white',
lang : 'fr',
tabindex : 0
};
</script>

<script type="text/javascript"src="https://www.google.com/recaptcha/api/challenge?k=6Lfipe0SAAAAAA5c2ohQKKGBpZ9uzlF1nzjwvKMh"></script>

                            </div>
                        </div>
                        <input id="bt-validateregister" type="submit" value="Valider" class="validBtn center" />
                    </p>
</form>             <div id="subform-Userspace" style="display:none">
                   
                    <div class="red-btns">
                       
                        
                       
                    </div>
                </div>

                <div id="subform-Mandatory" class="mandatory" style="margin-top:10px">( * ) Champs obligatoires</div>

            </div>
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
            <a href="http://www.solocalgroup.com/" target="_blank" rel="nofollow">
                <div class="so-local"></div>
            </a>
            <a href="http://www.pagesjaunes.fr/" target="_blank" rel="nofollow">
                <div class="pages-jaunes"></div>
            </a>
            <a href="http://fr.mappy.com/" target="_blank" rel="nofollow">
                <div class="mappy"></div>
            </a>
            <a href="https://www.ooreka.fr/" target="_blank" rel="nofollow">
                <div class="comprendre-choisir"></div>
            </a>
        </div>
    </div>
</footer>



    <div class="hiddenappversion">25/07/2016 05:33:01 - Prod - AVAL-FO_001 - v3.4.7.47 - rev 6844edf</div>
    
</body>

</html>