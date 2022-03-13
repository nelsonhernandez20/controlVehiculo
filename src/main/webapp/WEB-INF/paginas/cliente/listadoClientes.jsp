<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de vehiculos <i class="fas fa-car-side"></i> ${totalVehiculos}       <a href="index.jsp" class="btn btn-primary btn-block">
                    <i class="fas fa-angle-double-left"></i> Regresar
                </a></h4>
                    </div>
                    <table class="table table-striped  table-hover table-warning">
                        <thead class="thead-Warning">
                            <tr>
                                <th>#</th>
                                <th>Marca</th>
                                <th>Placa</th>
                                <th>Nombre</th>
                                <th></th>
                            </tr>
                        </thead>
                        <thbody>
                            <!--iteramos los elementos de la lista por medio de foreach-->
                            <c:forEach var="vehiculo" items="${vehiculos}" varStatus="status">
                                <tr>
                                    <td>
                                        ${status.count}
                                    </td>
                                    <td>
                                        ${vehiculo.marca}
                                    </td>
                                    <td>
                                        ${vehiculo.placa}
                                    </td>
                                    <td>
                                        ${vehiculo.nombre}
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idVehiculo=${vehiculo.idVehiculo}" 
                                           class="btn btn-primary"> 
                                            <i class="fas fa-angle-double-right" ></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </thbody>
                    </table>
                </div>
            </div>
            <!-- agregar buscador -->
        </div>
    </div>
</section>
                    
<!-- agregar cliente --> 
<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"></jsp:include>