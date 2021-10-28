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
import upc.edu.pe.gestionempleadoresservice.entities.Empleador;
import upc.edu.pe.gestionempleadoresservice.models.User;
import upc.edu.pe.gestionempleadoresservice.services.EmpleadorService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empleadores")
public class EmpleadorController{
    @Autowired
    private EmpleadorService empleadoresService;

    @Operation(summary="End-point para la creación del empleador", description="Completar los datos que se solicita", tags={"empleadores"})
    @PostMapping(path = "create")
    public ResponseEntity<Empleador> createEmpleador(@Valid @RequestBody Empleador empleadores, BindingResult result) throws Exception {
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Empleador empleadorescreate =  empleadoresService.save(empleadores);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadorescreate);
    }

    @Operation(summary="End-point para obtener la información de un empleador segun su 'id' ", description="Ingresar un numero de 'id'" +
            "para obtener la información del empleador.", tags={"empleadores"})
    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleador> fetchById (@PathVariable("id") Long id){
        try{
            //Para la gestion de los errores
            Optional<Empleador> optionalCliente = empleadoresService.findById(id);

            if (optionalCliente.isPresent()){
                return new ResponseEntity<Empleador>(optionalCliente.get(), HttpStatus.OK);
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
    public ResponseEntity<Empleador> fetchByDNI (@PathVariable("dni") Long DNI){
        try{
            //Para la gestion de los errores
            Optional<Empleador> optionalCliente = empleadoresService.findByDNI(DNI);

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
    public ResponseEntity<List<Empleador>> listAllEmpleadores() throws Exception {
        List<Empleador> empleadores = empleadoresService.findAll();
        if (empleadores.isEmpty()) {
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(empleadores);
    }

    @Operation(summary="End-point para eliminar al empleador segun su 'id' ", description="Se eliminara a un empleador en especifico" +
            "segun su 'id'", tags={"empleadores"})
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Empleador> deleteEmpleadores(@PathVariable("id") Long id) throws Exception {
        Empleador empleadores = empleadoresService.getEmpleador(id);
        if (empleadores == null) {
            return  ResponseEntity.notFound().build();
        }
        empleadoresService.deleteById(empleadores);
        return ResponseEntity.ok(empleadores);
    }

    @Operation(summary="End-point para modificar los datos del empleador segun su 'id' ", description="Se modificara a un empleador en especifico" +
            "segun su 'id' ", tags={"empleadores"})
    @PutMapping(value = "update/{id}")
    public ResponseEntity<?> updateEmpleador(@PathVariable("id") Long id, @RequestBody Empleador empleadores) throws Exception {
        Empleador currentEmpleador = empleadoresService.getEmpleador(id);

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

    @Operation(summary = "Authenticate employer by email and password", description = "Get employer by email and password", tags={"empleadores"})
    @PostMapping(path = "/empleadores/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleador> authenticatePostulant(@RequestBody User user) {
        try{
            Empleador empleador = empleadoresService.findByEmailAndPassword(user.correo,user.contraseña);

            if(empleador != null) {
                return ResponseEntity.ok(empleador);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
