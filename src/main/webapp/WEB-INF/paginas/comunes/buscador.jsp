<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <label>Buscar</label>
                <div class="navbar">
                    <form class="form-inline" action="${pageContext.request.contextPath}/ServletControlador?accion=buscar" method="POST">
                        <input type="text" name="txtBuscar" value="${txtBuscar}">
                       
                        <button type="submit" class="btn btn-primary btn-block"><i class="fas fa-search"></i></button>
                        
                    </form>
                  
                </div>
            </div>
        </div>
    </div>
</section>