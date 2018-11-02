<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Superhero Sightings</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">SUPERHERO SIGHTINGS</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/superheroes">Superheroes</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/superpowers">Superpowers</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/organizations">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/locations">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/sightings">Sightings</a></li>
                </ul>    
            </div>
            <div class="container">
                <ul class="list-group" id="errorMessages"></ul>
                <div class="row">
                    <div class="col-md-4">
                        <h2>Latest Sightings</h2>
                        <table class="table table-hover">                            
                            <th width="50%">Location</th>
                            <th width="50%">Date</th>
                            <c:forEach var="currentSighting" items="${sightingList}">
                                <tr>
                                    <td>
                                        <a href="sightingDetails?sightingId=${currentSighting.sightingId}">
                                            <c:out value="${currentSighting.location.name}"/>
                                        </a>
                                    </td>
                                    <td>                                        
                                        <c:out value="${currentSighting.date}"/>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div class="col-md-8">
                        <h3>
                            Welcome to Superhero Sightings!
                        </h3>
                        <p>
                            Help us track superheroes and villains by reporting where you saw them. 
                            Browse our database of powers, superheroes, organizations, locations, and sightings.
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

