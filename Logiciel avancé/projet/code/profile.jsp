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
                 <span class="menu-title" id="title_demenager" style="position:relative; left:45px; top:-5px"><a href="alerter.jsp"><img src="CSS/icon.png"></a><span class="pic"><span></span></span></span>
                    

                </li>
                
                      <li class="move">
                 <span class="menu-title" id="title_demenager" style="font-size:20px; left:30px"><a href="#">d�connexion</a><span class="pic"><span></span></span></span>
                    

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
            <p>Trouvez plus vite en compl�tant votre profil � 100%. &nbsp;<a href="/Users/Users/Profil">Editer</a></p>
    </div>
    <nav>
	    <ul class="menu-left">
	        
		    <li><a href="#" class="ep ">param�tre du compte<span></span></a></li>
            
                <li><a href="#" class="ep selected">g�rer la demande<span></span></a></li>

		    <li><a href="#" class="red">liste des favories</a></li>
		    <li><a href="#" class="red">contacter</a></li>
		   
			   
		    </li>
	    </ul>
    </nav>
</div>
        <div class="col-content">
        <h2>Mon profil</h2>
            <section class="profil">
                <p>
                    Optimisez votre recherche en compl�tant votre profil. Mieux vous conna�tre nous permet de cibler plus pr�cisement votre besoin. Rassurez vous, vos donn�es ne sont pas divulgu�es � des tiers sans votre consentement.
                </p>
                
<form method="post">                    <div class="col clear">
                        <div id="User_TitleContainer">
        <input list="civility" type="text" id="civil" placeholder="Vous �tes :">
<datalist id="civility">
  <option value="Monsieur">
  <option value="Madame">
  
</datalist>
                        </div>
                        
<input class="name" id="User_LastName" maxlength="50" name="User.LastName"  type="text" value="dzoulou" />
<input class="first-name" id="User_FirstName" maxlength="50" name="User.FirstName"  type="text" value="vinci savi" />   
<input class="input-classic onlynum" id="User_MobilePhone" maxlength="16" name="User.MobilePhone" placeholder="T�l�phone" type="text" value="" />              <input class="input-classic name" id="User_TownName" maxlength="50" name="User.TownName" placeholder="Ville" type="text" value="" />                     
                        
                        <input class="input-classic mail" id="User_Email" maxlength="50" name="User.Email"  type="text" value="vincidzoulou@yahoo.fr" />
                    </div>
                    <div class="col right">
                        
                        
                    </div>
<div class="col-large">
                        <input class="input-classic name-path" id="User_Adress" maxlength="100" name="User.Adress" placeholder="Adresse" type="text" value="" /><br><br>
                    </div>
                    <div class="col clear">
                      <div id="User_ProfilsContainer">
                            <input list="proprietaire" type="text" id="choix" placeholder="Vous �tes :">
<datalist id="proprietaire">
<option value="Locataire">
<option value="Acqu&#233;reur">
<option value=" acc&#233;dant">
<option value="Investisseur">
</datalist>
                        </div>
                    </div>
                    <div class="col right"></div>
          <input id="bt-updateprofil" type="submit" class="validBtn" value="Valider" />
</form>            </section>
                <h2 class="unsubscribe">D�sinscription</h2>
                <section>
                    <p>
                        En vous d�sinscrivant, votre compte sera supprim� et vous ne recevrez plus d'alerte ni d'e-mail du site. Pour vous d�sinscrire du site , cliquez sur le bouton ci-dessous :                    </p>
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