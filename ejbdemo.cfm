<html> 
<head> 
    <title>cfobject Test</title> 
</head> 
 
<body> 
<H1>cfobject Test</H1> 
<!--- Create the Context object to get at the static fields. ---> 
<CFOBJECT  
    action=create  
    name=ctx  
    type="JAVA"  
    class="javax.naming.Context"> 
	
<!--- Create the Properties object and call an explicit constructor---> 
<CFOBJECT  
    action=create  
    name=prop  
    type="JAVA"  
    class="java.util.Properties"> 

<!--- Call the init method (provided by cfobject) 
        to invoke the Properties object constructor. ---> 
<cfset prop.init()> 
 
<!--- Specify the properties These are required for a remote server only ---> 
<cfset prop.put(ctx.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory")> 
<cfset prop.put(ctx.PROVIDER_URL, "localhost")> 

<!--- Create the InitialContext ---> 
<CFOBJECT  
    action=create  
    name=initContext  
    type="JAVA"  
    class="javax.naming.InitialContext"> 

<!--- Call the init method (provided through cfobject) 
        to pass the properties to the InitialContext constructor. ---> 
<cfset initContext.init(prop)> 
 
<!--- Get reference to home object. ---> 
<cfset home = initContext.lookup("LibrarySession/remote")> 

<CFOBJECT  
    action=create  
    name=books  
    type="JAVA"  
    class="java.util.List"> 


<cfset home.addBook("CF EJB INTG")>
<cfset books = home.getBooks()>

<cfset iterator = books.iterator() />
	
<cfoutput> 
	<cfloop condition="iterator.hasNext()">
		<cfset currObj = iterator.next() />
		#currObj# </br>
	</cfloop>
</cfoutput> 	
	
<cfset initContext.close()>  
 
</body> 
</html>
