<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Zia Mafalda - Nuovo prelievo</title>
</head>
<body align="center">
<h1>Ciao ${operatore}!</h1>
<form action="#" method="post">
    <table border="0" align="center">
        <tr>
            <td align="left">
                Nome:
            </td>
            <td align="left">
                <input type="text" value="" name="nome" id="nome"/>
            </td>
        </tr>
        <tr>
            <td align="left">
                Cognome:
            </td>
            <td align="left">
                <input type="text" value="" name="cognome" id="cognome"/>
            </td>
        </tr>
        <tr>
            <td align="left">
                Telefono:
            </td>
            <td align="left">
                <input type="text" value="" name="telefono" id="telefono"/>
            </td>
        </tr>
        <tr>
            <td align="left">
                Orario prelievo:
            </td>
            <td align="left">
                <input type="text" value="" name="orarioPrelievo" id="orario"/>
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="Invia" name="invio"/>
            </td>
        </tr>
        <#if risultatoOperazionePrecedente?has_content>
        <tr>
            <td align="center" colspan="2" id="messaggio">
                ${risultatoOperazionePrecedente}
            </td>
        </tr>
        </#if>
    </table>
</form>
</body>
<script>

    //        function controlla()
    //        {
    //            var n=document.getElementById("nome").value;
    //            var c=document.getElementById("cognome").value;
    //            var tel=document.getElementById("telefono").value;
    //            var orario=document.getElementById("orario").value;
    //            if(n=="" || c=="" || tel=="" || orario=="")
    //            {
    //                document.getElementById("messaggio").innerHTML="compilare tutti i campi";
    //            }
    //        }

</script>
</html>