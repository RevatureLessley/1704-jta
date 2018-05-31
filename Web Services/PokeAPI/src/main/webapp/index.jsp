<html>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    
    <form action="rest/boring-pokemon/form-params" method="post">
    	<input type="text" name="pokemonName" placeholder="Enter a Pokemon name" /><br>
    	<input type="text" name="pokemonType" placeholder="Enter the type" /><br>
    	<input type="submit" value="Submit" />
    </form>
    <br><br><br>
    <form action="rest/boring-pokemon/query-params" method="get">
    	<input type="text" name="type" placeholder="Enter the type" /><br>
    	<input type="submit" value="Submit" />
    </form>
</body>
</html>
