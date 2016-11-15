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
            <div class="bloc-top auth" style="height:480px">
            
<form action=""   id="authform" method="post">                   
 <span class="title">Déposez votre offre ici...</span><br><br>
<input id="nom_user" maxlength="50" name="nom" placeholder="Nom* :" type="text" value=""/>
<input list="capacites" type="text" id="cap" placeholder="Capacité d'accueil* :">
<datalist id="capacites">
  <option value="1">
  <option value="2">
  <option value="3">
</datalist>
<input list="price" type="text" id="prix" placeholder="prix tarifaire* :">
<datalist id="price">
  <option value="200$/ mois">
  <option value="150$/ nuit">
  <option value="250 /semaine">
</datalist>
<input list="villes" type="text" id="choix_villes" placeholder="Faites le choix de la ville* :">
<datalist id="villes">
  <option value="Ville 1">
  <option value="Ville 2">
  <option value="Ville 3">
</datalist>
<input list="quartier" type="text" id="choix_quartier" placeholder="Faites le choix du quartier* :">
<datalist id="quartier">
  <option value="quartier 1">
  <option value="quartier 2">
  <option value="quartier 3">
</datalist>
<input list="street" type="text" id="choix_street" placeholder="Faites le choix de la ruelle* :">
<datalist id="street">
  <option value="rue 1">
  <option value="rue 2">
  <option value="rue 3">
</datalist>
<input type="file" name="fichier" size="40" maxlength="50" style="position:relative; left:-30px">
<textarea rows="4" cols="41" placeholder="Décrivez votre offre ici...">
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