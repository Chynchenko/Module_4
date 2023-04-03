<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <html>
 <head>
     <title>Created detail</title>
 </head>
 <body>
 <section>
     <h1>Created detail</h3>
     	 <p>ID: ${detail.id}</p>
     	 <p>Date of production: ${detail.dateCreation}</p>
     	 <p>Term of production: ${detail.productionTime}</p>
     	 <p>Count of broken microcircuits: ${detail.brokenMicrocircuits}</p>
     	 <p>Produced fuel: ${detail.producedFuel}</p>
     	 <p>Used fuel: ${detail.usedFuel}</p>
     	 </form>
          <form method="post">
             <button type="submit">CREATE NEW DETAIL AGAIN</button>
          </form>
     	 </form>
          <form method="GET" action="index.html">
          <button type="submit" class="button">BACK TO MAIN PAGE</button>
          </form>
 </section>
 </body>
 </html>