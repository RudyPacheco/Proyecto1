<%-- 
    Document   : agreagarPieza
    Created on : 2/09/2021, 21:45:52
    Author     : AndaryuS
--%>

<div class="modal fade" id="agregarPieza" >
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-heater bg-info text-white">
                <h5 class="modal-tittle">Agregar Pieza</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>

            </div>
            <form action="controladorFabrica1?menu=piezas" method="POST">
                <div class="form-group">
                    <label>Nombre Pieza</label>
                    <input type="text" value="${pieza.getNombre_pieza()}" name="nombrePieza" class="form-control">
                </div>
                <div class="form-group">
                    <label>Precio</label>
                    <input type="number" step="any" value="${pieza.getCosto()}" name="precio" class="form-control">
                </div>
                <input type="submit" name="accion" value="registrar" class="btn btn-info" >    

            </form>
        </div>
    </div>
</div>