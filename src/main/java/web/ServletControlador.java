package web;

import datos.VehiculoDAO;
import dominio.Vehiculo;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                {
                    try {
                        this.editarVehiculo(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case "eliminar":
                {
                    try {
                        this.eliminarVehiculo(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                default:
                    this.accionDefault(request, response);
            }
        }else{
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehiculo> vehiculos = null;
        try {
            vehiculos = new VehiculoDAO().listar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("vehiculos = " + vehiculos);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("totalVehiculos", vehiculos.size());
        sesion.setAttribute("vehiculos", vehiculos);
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                {
                    try {
                        this.insertarVehiculo(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
                case "modificar":
                {
                    try {
                        this.modificarVehiculo(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
                case "buscar":
                {
                    try {
                        this.buscarVehiculo(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                    
                default:
                    this.accionDefault(request, response);

            }
        }else{
            this.accionDefault(request, response);
        }

    }

    private void insertarVehiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String marca = request.getParameter("marca");
        String placa = request.getParameter("placa");
        String nombre = request.getParameter("nombre");
        
        Vehiculo vehiculo = new Vehiculo(marca, placa, nombre);
        int registros = new VehiculoDAO().insertar(vehiculo);
        
        this.accionDefault(request, response);

    }
    
     private void buscarVehiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String txtBuscar = request.getParameter("txtBuscar");
        
        
        
        List<Vehiculo> vehiculos = new VehiculoDAO().buscar(txtBuscar);
        
        System.out.println("vehiculos = " + vehiculos);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("totalVehiculos", vehiculos.size());
        sesion.setAttribute("txtBuscar", txtBuscar);
        sesion.setAttribute("vehiculos", vehiculos);
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");

    }
    
    private void eliminarVehiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        int idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));
      
        Vehiculo vehiculo = new Vehiculo(idVehiculo);
        int registros = new VehiculoDAO().eliminar(vehiculo);
        
        this.accionDefault(request, response);

    }
    
    private void modificarVehiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        int idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));
        String marca = request.getParameter("marca");
        String placa = request.getParameter("placa");
        String nombre = request.getParameter("nombre");
        
        Vehiculo vehiculo = new Vehiculo(idVehiculo ,marca, placa, nombre);
        int registros = new VehiculoDAO().actualizar(vehiculo);
        
        this.accionDefault(request, response);

    }
    
    private void editarVehiculo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException{
        int idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));
        Vehiculo vehiculos = new VehiculoDAO().encontrar(new Vehiculo(idVehiculo));
        String nombre = vehiculos.getNombre();
        int id = vehiculos.getIdVehiculo();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("vehiculos", vehiculos);
        sesion.setAttribute("idVehiculo", idVehiculo);
        sesion.setAttribute("id", id);
        sesion.setAttribute("nombre", nombre);
        response.sendRedirect("editarCliente.jsp");
//        
//        request.setAttribute("vehiculos", vehiculos);
//        String jspEditar = "editarCliente.jsp";
//        request.getRequestDispatcher(jspEditar).forward(request, response);
        
    }
}
