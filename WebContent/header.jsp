
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <div class="navbar-header">
     <a class="navbar-brand" href="home.do"><i class="fa fa-home" aria-hidden="true"></i> Home 
     </a>&ensp; 
     <a class="navbar-brand" href="etudiant.do"><i class="fa fa-users" aria-hidden="true"></i>
      Etudiants</a>&ensp; 
     <a class="navbar-brand" href="formation.do"><i class="fa fa-book" aria-hidden="true"></i>
      Formations</a>&ensp; 
     <a class="navbar-brand" href="session.do"><i class="fa fa-address-book-o" aria-hidden="true"></i>
      Sessions</a> &ensp;
       <a class="navbar-brand" href="reservation.do"><i class="fa fa-address-book-o" aria-hidden="true"></i>
      Reservations</a>&ensp;
   <%if(session.getAttribute("role").equals("admin")) {%>  <a class="navbar-brand" href="consulter.GestionAdmins"><i class="fa fa-lock" aria-hidden="true"></i>
    Admins</a>
<%} %>
    </div>
    
  <!-- <div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Gestion des formations
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
 <a class="dropdown-item" href="formation.do"><i class="fa fa-book" aria-hidden="true"></i>
      Gestion des formations</a> 
<a class="dropdown-item" href="session.do"><i class="fa fa-address-book-o" aria-hidden="true"></i>
      Gestion des sessions</a>    
  </div>
</div> -->
    
    
    
     <div>
    <a class="navbar-brand pull-right" href="logout.do"><i class="fa fa-sign-out" aria-hidden="true"></i>
     Se deconnecter</a>
    </div>
  </div>
</nav>



