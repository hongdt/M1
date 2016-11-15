<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation chambre</title>
 <link rel="stylesheet" href="CSS/Stylesdf20.css?v=S7xcjgo8A8qlW9x5oP-Phb232PMAMTWMtj_DOCdFm1A1" />
</head>
<body class="aval fr-fr home">

<div id="smart-app-banner-ipad" style="display: none;">
    <div class="wrapper background-smartbanner-ipad">
        <div class="txt-button">
        
            <div id="btn-install-app-ipad"><a href="#"></a>
            </div>
            <div id="btn-launch-app-ipad"><a></a></div>
        </div>
        <div class="close-smartbanner"></div>
    </div>
</div>
        <div id="headerMarqueBlanche"></div>
        



<nav class="layout">
    <div class="purplegbackground">
        <div class="wrapper">
            <ul class="top-menu">
                <li class="logo">
                    <!--<a href="index.html">ECORA</a>-->
                </li>
            </ul>

        </div>
    </div>
    <div class="bottom-layout normal-header">
        <div class="wrapper"  style="position:relative; left:250px; top:-40px">
            <ul class="bottom-menu">
                
               <li class="sale">
                    <span class="menu-title" id="title_vendre" ><a href="accueil.jsp">ACCUEIL</a><span class="pic"><span></span></span></span>

                </li>
            
                
                <li class="sale">
                    <span class="menu-title" id="title_vendre" ><a href="demande.jsp">DEMANDE</a><span class="pic"><span></span></span></span>

                </li>
                <li class="finance">
                    <span class="menu-title" id="title_financer"><a href="offres.jsp">OFFRE</a><span class="pic"><span></span></span></span>

                </li>
                <li class="move">
                    <span class="menu-title" id="title_demenager"><a href="connexion.jsp">SE CONNECTER</a><span class="pic"><span></span></span></span>

                </li>
                     <li class="move">
                    <span class="menu-title" id="title_demenager"><a href="inscription.jsp">INSCRIPTION</a><span class="pic"><span></span></span></span>

                </li>
            </ul>

        </div>
    </div>
</nav>
<div class="container-auth">
    <div class="col-container">
        <div class="wrapper">
            <div class="bloc-top auth" style="height:580px">
            
<form action=""   id="authform" method="post">                   
 <span class="title">Demande de logement...</span><br><br>
 
 <input list="matri" type="text" id="matrimoine" placeholder="Vous êtes:* :">
<datalist id="matri">
  <option value="Mr">
  <option value="Mm">
  <option value="Mlle">
 
</datalist>
<input id="nom_user" maxlength="50" name="nom" placeholder="Nom* :" type="text" value=""/>
<input id="pre" maxlength="50" name="prenom" placeholder="Prénom* :" type="text" value=""/>
<input type="date" name="anniversaire">
<input list="situation" type="text" id="famille" placeholder="Situation familiale* :">
<datalist id="situation">
  <option value="Marié(e)">
  <option value="Célibataire">
  <option value="Divorcé(e)">
  <option value="veuf(ve)">
</datalist>
<input id="price" maxlength="50" name=prix" placeholder="Prix proposé :" type="text" value=""/>
<input type="email" name="user_email" placeholder="Votre adresse mail* :" >
<input type="tel" name="user_tel" placeholder="Votre numéro de téléphone* :" >
<input list="ville" type="text" id="vil" placeholder="Ville où vous voulez trouver un hebergement:*">
<datalist id="ville">
  <option value="Ville 1">
  <option value="Ville 2">
  <option value="Ville 3">
</datalist>
<input list="villes" type="text" id="choix_villes" placeholder="profession:*">
<datalist id="villes">
  <option value="Employeur">
  <option value="Chomeur">
  <option value="Etudiant">
</datalist>
<textarea rows="4" cols="41" placeholder="Décrivez le motif de votre demande:...">
</textarea>
                    <div class="authError"></div>
                       
                        <input id="bt-auth" type="submit" class="validBtn" value="Save" style="position:relative; left:-290px; top:30px"/>
                         <input id="bt-auth" type="reset" class="validBtn" value="Cancel" style="position:relative; left:55px; top:30px; width:100px"/>
                    </div>
                    
                    <div id="fb-root"></div>
                   





					
                        <div id="GoogleSigninButton">
                            <div class="google-signin">
                               
                            </div>
				        </div>
					</div>
</form>            </div>

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



    <div class="hiddenappversion">25/07/2016 05:23:22 - Prod - AVAL-FO_002 - v3.4.7.47 - rev 6844edf</div>
  
</body>

</html>