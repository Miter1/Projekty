<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset = UTF-8>
<link rel="stylesheet" type="text/css" href="styl.css">
<title>Kantor</title>
</head>
<body>

<form class = "cantor" method = "post">
<p>Podaj ilość pieniędzy, jaką chcesz przeliczyć:<p>
<input type="number" name="x" value = "param.x">
<p>Podaj walutę z jakiej chcesz przeliczyć, oraz walutę, na którą chcesz przeliczyć:<p>
<select name="waluta1">
<option value="PLN">PLN</option>
<option value="EUR">EUR</option>
<option value="USD">USD</option>
<option value="GBP">GBP</option>
<option value="CHF">CHF</option>
<option value="NOK">NOK</option>
<option value="SEK">SEK</option>
</select>
<select name="waluta2">
<option value="PLN">PLN</option>
<option value="EUR">EUR</option>
<option value="USD">USD</option>
<option value="GBP">GBP</option>
<option value="CHF">CHF</option>
<option value="NOK">NOK</option>
<option value="SEK">SEK</option>

</select>
<button>przelicz</button>
</form>

<c:if test="${not empty wynik}">
<p>a</p>
${param.x} ${param.waluta1} = ${wynik} 

</c:if>

</body>
</html>