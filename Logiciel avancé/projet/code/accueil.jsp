<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation chambre</title>
 <link rel="stylesheet" href="CSS/Stylesdf20.css?v=S7xcjgo8A8qlW9x5oP-Phb232PMAMTWMtj_DOCdFm1A1" />
</head>
<body class="aval fr-fr home">


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
                    <span class="menu-title" id="title_vendre" ><a href="#">DEMANDE</a><span class="pic"><span></span></span></span>

                </li>
                <li class="finance">
                    <span class="menu-title" id="title_financer"><a href="#">OFFRE</a><span class="pic"><span></span></span></span>

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



<header id="header" class="hp-header" style="width:1024px; height:500px">
    <div id="fd-header" class="fd-header" data-habillage="false"></div>
    <div class="home-searchengine">
        
<div class="title-count">
    <h1>DES LOCATIONS</h1></BR>
    <span style="color:#FFFFFF; position:relative; top:-20px; left:450px">Location d'une chambre d'hotel pour une moyenne ou longue durée</span>
</div>
<div class="search" style="position:relative; top:25px; height:100px">
    <button type="button" class="ui-multiselect select-search-engine" aria-haspopup="true" id="Criteria_TransactionType" >
        
        <span><a href="#">offre</a></span>
    </button>
    <div class="search-engine-list" style="display: none;">
        <ul class="type-select">
            <div class="col1">
                
            </div>
            <div class="col2">
                <div id="alert-link-home-searchengine" class="bloc-searchengine hp-bloc-alert" onClick="emailAlert('Sorter', 'Home', 0, 'HomeSearchEngine')">
                    <span></span>
                    <div>Créer une alerte</div>
                </div>
                <div class="bloc-searchengine entrust-search-hp"><a href="#" rel="nofollow">
                    <span></span>
                    <div>Confier ma recherche</div>
                </a></div>
            </div>
        </ul>
        
    </div>

    <div class="hp-formCtnr" id="SearchEngine">
        
        
<form action="" class="select-buy visible"  id="form0" method="post">    
<div class="upper-block">
        <div class="search-input">
            <div class="newlocCtnr"></div>
            
            <div style="position: absolute; z-index: 9999;"><select id="Criteria_LocalityIds" multiple="multiple" name="Criteria.LocalityIds" style="display: none;"></select></div>
        </div>
        <input id="bt-searchsale" type="submit" name="submit-achat" value="Chercher" class="hp-form-submit" />
    </div>
    <div class="down-block">
        <div class="typeGroupCtnr">
            
        </div>
        </div>
        
        <div class="advanced-search-ctnr">
            <span class="advanced-srch link" title="Plus de critères">

            </span>
        </div>
</form>
    </div>
</div>
    </div>
</header>

<div class="hp-container">
    
    <div id="links-container" class="links-container">
  
    </div>
        <div class="middle-content">
            <div class="middle-wrapper">
                <div id="near-properties">
                    


<ul>
    <li class="house">
        <div class="picto">
            <div class="title">
                <span class="big">Chambres<br /></span>
                <span class="small">pas chers</span>
            </div>
        </div>
        <ul id="home-house-links">
                <li>
                    <a title="Vente - Maison à Roanne (42)" href="vente/roanne-42/b-maison/loc-101-19621.html">
                        Vente - Maison à Roanne (42)
                    </a>
                </li>
                <li>
                    <a title="Vente - Maison à Roche la Moli&#232;re (42)" href="vente/roche-la-moliere-42/b-maison/loc-101-19452.html">
                        Vente - Maison à Roche la Molière (42)
                    </a>
                </li>
                            <li class="more">
                    <a title="Vente - Maison à Saint Paul en Jarez (42)" href="vente/saint-paul-en-jarez-42/b-maison/loc-101-19843.html">
                        Vente - Maison à Saint Paul en Jarez (42)
                    </a>
                </li>
                <li class="more">
                    <a title="Vente - Maison à Planfoy (42)" href="vente/planfoy-42/b-maison/loc-101-19827.html">
                        Vente - Maison à Planfoy (42)
                    </a>
                </li>
                <li class="more">
                    <a title="Vente - Maison à Changy (42)" href="vente/changy-42/b-maison/loc-101-19629.html">
                        Vente - Maison à Changy (42)
                    </a>
                </li>
            <li>
                <span class="more-properties" data-type="house">Voir + d'annonces</span><span class="icon"></span>
            </li>
        </ul>
    </li>
    <li class="appartment">
        <div class="picto">
            <div class="title">
                <span class="big">Chambres<br /></span>
                <span class="small">à proximité</span>
            </div>
        </div>
        <ul id="home-appartment-links">
                <li>
                    <a title="Vente - Appartement à La Fouillouse (42)" href="vente/la-fouillouse-42/b-appartement/loc-101-19722.html">
                        Vente - Appartement à La Fouillouse (42)
                    </a>
                </li>
                <li>
                    <a title="Vente - Appartement à Saint Chamond (42)" href="vente/saint-chamond-42/b-appartement/loc-101-19676.html">
                        Vente - Appartement à Saint Chamond (42)
                    </a>
                </li>
                            <li class="more">
                    <a title="Vente - Appartement à La Ricamarie (42)" href="vente/la-ricamarie-42/b-appartement/loc-101-19531.html">
                        Vente - Appartement à La Ricamarie (42)
                    </a>
                </li>
                <li class="more">
                    <a title="Vente - Appartement à Andr&#233;zieux Bouth&#233;on (42)" href="vente/andrezieux-boutheon-42/b-appartement/loc-101-19543.html">
                        Vente - Appartement à Andrézieux Bouthéon (42)
                    </a>
                </li>
                <li class="more">
                    <a title="Vente - Appartement à Rive de Gier (42)" href="vente/rive-de-gier-42/b-appartement/loc-101-19850.html">
                        Vente - Appartement à Rive de Gier (42)
                    </a>
                </li>
            <li>
                <span class="more-properties" data-type="house">Voir + d'annonces</span><span class="icon"></span>
            </li>
        </ul>
    </li>
    
    
    <li class="appartment" style="position:relative; left:660px; top:-250px">
    <div class="picto" style="width:300px">
            <div class="title">
                <span class="big">Chambres<br /></span>
                <span class="small">VIP</span>
            </div>
        </div>
                <ul id="home-appartment-links">
                <li>
                    <a title="Vente - Appartement à La Fouillouse (42)" href="vente/la-fouillouse-42/b-appartement/loc-101-19722.html">
                        Vente - Appartement à La Fouillouse (42)
                    </a>
                </li>
                <li>
                    <a title="Vente - Appartement à Saint Chamond (42)" href="vente/saint-chamond-42/b-appartement/loc-101-19676.html">
                        Vente - Appartement à Saint Chamond (42)
                    </a>
                </li>
                            <li class="more">
                    <a title="Vente - Appartement à La Ricamarie (42)" href="vente/la-ricamarie-42/b-appartement/loc-101-19531.html">
                        Vente - Appartement à La Ricamarie (42)
                    </a>
                </li>
                <li class="more">
                    <a title="Vente - Appartement à Andr&#233;zieux Bouth&#233;on (42)" href="vente/andrezieux-boutheon-42/b-appartement/loc-101-19543.html">
                        Vente - Appartement à Andrézieux Bouthéon (42)
                    </a>
                </li>
                <li class="more">
                    <a title="Vente - Appartement à Rive de Gier (42)" href="vente/rive-de-gier-42/b-appartement/loc-101-19850.html">
                        Vente - Appartement à Rive de Gier (42)
                    </a>
                </li>
            <li>
                <span class="more-properties" data-type="house">Voir + d'annonces</span><span class="icon"></span>
            </li>
        </ul>
    
    
    
</ul>
                </div>
                    <div class="home-pub">
                         


    <div id="avlineContainer-Home-Top">
        <div class="avLineContent">
        </div>
    </div>

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