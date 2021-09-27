package upc.edu.pe.gestionempleadoresservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import upc.edu.pe.gestionempleadoresservice.entities.Empleadores;
import upc.edu.pe.gestionempleadoresservice.services.EmpleadorService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empleadores")
public class EmpleadorController {
    @Autowired
    private EmpleadorService empleadoresService;

    @Operation(summary="End-point para la creación del empleador", description="Completar los datos que se solicita", tags={"empleadores"})
    @PostMapping(path = "create")
    public ResponseEntity<Empleadores> createEmpleador(@Valid @RequestBody Empleadores empleadores, BindingResult result) throws Exception {
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Empleadores empleadorescreate =  empleadoresService.save(empleadores);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadorescreate);
    }

    @Operation(summary="End-point para obtener la información de un empleador segun su 'id' ", description="Ingresar un numero de 'id'" +
            "para obtener la información del empleador.", tags={"empleadores"})
    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleadores> fetchById (@PathVariable("id") Long id){
        try{
            //Para la gestion de los errores
            Optional<Empleadores> optionalCliente = empleadoresService.findById(id);

            if (optionalCliente.isPresent()){
                return new ResponseEntity<Empleadores>(optionalCliente.get(), HttpStatus.OK);
            }else  {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Para el numero de documento
    @Operation(summary="End-point para obtener la información de un empleador segun su 'dni' ", description="Ingresar un numero de 'dni'" +
            "para obtener la información del empleador.", tags={"empleadores"})
    @GetMapping(path = "/dni/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleadores> fetchByDNI (@PathVariable("dni") Long DNI){
        try{
            //Para la gestion de los errores
            Optional<Empleadores> optionalCliente = empleadoresService.findByDNI(DNI);

            if (optionalCliente.isPresent()){
                return ResponseEntity.ok(optionalCliente.get());
            }else  {
                return ResponseEntity.notFound().build();
            }

        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary="End-point para obtener la información de todos los empleadores registrados", description="Mostrara a todos los empleadores que se" +
            "registraron", tags={"empleadores"})
    @GetMapping(path = "all")
    public ResponseEntity<List<Empleadores>> listAllEmpleadores() throws Exception {
        List<Empleadores> empleadores = empleadoresService.findAll();
        if (empleadores.isEmpty()) {
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(empleadores);
    }

    @Operation(summary="End-point para eliminar al empleador segun su 'id' ", description="Se eliminara a un empleador en especifico" +
            "segun su 'id'", tags={"empleadores"})
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Empleadores> deleteEmpleadores(@PathVariable("id") Long id) throws Exception {
        Empleadores empleadores = empleadoresService.getEmpleadores(id);
        if (empleadores == null) {
            return  ResponseEntity.notFound().build();
        }
        empleadores = empleadoresService.deleteById(empleadores);
        return ResponseEntity.ok(empleadores);
    }

    @Operation(summary="End-point para modificar los datos del empleador segun su 'id' ", description="Se modificara a un empleador en especifico" +
            "segun su 'id' ", tags={"empleadores"})
    @PutMapping(value = "update/{id}")
    public ResponseEntity<?> updateEmpleador(@PathVariable("id") Long id, @RequestBody Empleadores empleadores) throws Exception {
        Empleadores currentEmpleador = empleadoresService.getEmpleadores(id);

        if ( null == currentEmpleador ) {
            return  ResponseEntity.notFound().build();
        }

        empleadores.setId(id);
        currentEmpleador    =   empleadoresService.update(empleadores);
        return  ResponseEntity.ok(currentEmpleador);
    }

    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
