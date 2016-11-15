function valider ( )
{
    if ( document.inscription.UserEmail.value == "" )
    {
        alert ( "Veuillez entrer votre Email !" );
        valid = false;
return valid;
    }
    if ( document.inscription.UserName.value == "" )
    {
        alert ( "Veuillez entrer votre nom !" );
        valid = false;
return valid;
    }

    if ( document.inscription.UserlastName.value == "" )
    {
        alert ( "Veuillez entrer votre prénom !" );
        valid = false;
return valid;
    }

    if ( document.inscription.UserZipcode.value == "" )
    {
        alert ( "Veuillez entrer votre code postal !" );
        valid = false;
return valid;
    }
    if ( document.inscription.Adresse.value == "" )
    {
        alert ( "Veuillez entrer votre adresse !" );
        valid = false;
return valid;
    }
	
}