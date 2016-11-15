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
                 <span class="menu-title" id="title_demenager" style="position:relative; left:45px; top:-5px"><img src="CSS/icon.png"><span class="pic"><span></span></span></span>
                    

                </li>
                
                      <li class="move">
                 <span class="menu-title" id="title_demenager" style="font-size:20px; left:30px"><a href="inscription.jsp">déconnexion</a><span class="pic"><span></span></span></span>
                    

                </li>
                   

</ul>
</nav>
<div class="container-ep">
    <h1>Bienvenue sur votre espace Personnel</h1>
    <div class="colCtnr">
        <div class="col-menu" style="position:relative; top:28px">
    <div class="block-account" style="">
	    <div class="block-avatar">
		    <div class="avatarCtnr">
                <img src="CSS/avatar.jpg" width="62" height="64">
		    </div>
		    
	    </div>
        <div class="block-name">
            Bonjour<br/><span class="username"></span>
            
        </div>
            <p>Trouvez plus vite en complétant votre profil à 100%. &nbsp;<a href="#">Editer</a></p>
    </div>
    
</div>
        <div class="col-content">
        <h2>Mon profil</h2>
            <section class="profil">
                <p>
                    Optimisez votre recherche en complétant votre profil. Mieux vous connaître nous permet de cibler plus précisement votre besoin. Rassurez vous, vos données ne sont pas divulguées à des tiers sans votre consentement.
                </p>
                
<form method="post">                    <div class="col clear">
                        <div id="User_TitleContainer">
                            <select class="ep-profil-gender" id="TitleIds" multiple="multiple" name="TitleIds" title="Civilité *"><option selected="selected" value="1">Monsieur</option>
<option value="2">Madame</option>
</select>
                        </div>
                        
<input class="name" id="User_LastName" maxlength="50" name="User.LastName"  type="text" value="dzoulou" />                        
                        
                        <input class="input-classic mail" id="User_Email" maxlength="50" name="User.Email"  type="text" value="vincidzoulou@yahoo.fr" />
                    </div>
                    <div class="col right">
                        <input class="first-name" id="User_FirstName" maxlength="50" name="User.FirstName"  type="text" value="vinci savi" />
                        <input class="input-classic onlynum" id="User_MobilePhone" maxlength="16" name="User.MobilePhone" placeholder="Téléphone" type="text" value="" />
                    </div>
                    <div class="col-large">
                        <input class="input-classic name-path" id="User_Adress" maxlength="100" name="User.Adress" placeholder="Adresse" type="text" value="" />
                    </div>
                    <div class="col clear">
                      <div id="User_ProfilsContainer">
                            <select class="ep-profil-type" id="ProfilIds" multiple="multiple" name="ProfilIds" title="Profil"><option selected="selected" value="1">Propri&#233;taire</option>
<option value="2">Locataire</option>
<option value="3">Acqu&#233;reur</option>
<option value="4">Primo acc&#233;dant</option>
<option value="5">Investisseur</option>
</select>
                        </div>
                    </div>
                    <div class="col right">
                        <input class="input-classic name" id="User_TownName" maxlength="50" name="User.TownName" placeholder="Ville" type="text" value="" />
                        <select class="ep-profil-vehicle" id="HasVehiculeIds" multiple="multiple" name="HasVehiculeIds" title="Etes vous véhiculé ?"><option value="1">Oui, je poss&#232;de un v&#233;hicule</option>
<option value="2">Non, je ne poss&#232;de pas de v&#233;hicule</option>
</select>
                    </div>
                    <input id="bt-updateprofil" type="submit" class="validBtn" value="Valider" />
</form>            </section>
                <h2 class="unsubscribe">Désinscription</h2>
                <section>
                    <p>
                        En vous désinscrivant, votre compte sera supprimé et vous ne recevrez plus d'alerte ni d'e-mail du site. Pour vous désinscrire du site , cliquez sur le bouton ci-dessous :                    </p>
                  <input type="button" class="validBtn cpointer" value="Supprimer mon compte"/>
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