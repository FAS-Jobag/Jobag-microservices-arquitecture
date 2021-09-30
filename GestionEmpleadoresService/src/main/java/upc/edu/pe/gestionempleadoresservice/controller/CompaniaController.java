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
import upc.edu.pe.gestionempleadoresservice.entities.Compania;
import upc.edu.pe.gestionempleadoresservice.entities.Empleador;
import upc.edu.pe.gestionempleadoresservice.entities.Sector;
import upc.edu.pe.gestionempleadoresservice.services.CompaniaService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/companias")
public class CompaniaController{
    @Autowired
    private CompaniaService companiaService;

    @Operation(summary="End-point para la creación de la compania", description="Completar los datos que se solicita", tags={"companias"})
    @PostMapping("empleador/{empleadorId}/sector/{sectorId}")
    public ResponseEntity<Compania> createCompania(@Valid @RequestBody Compania compania,
                                                   BindingResult result) {
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }

        Compania companiaDB = companiaService.createCompania(compania);

        return  ResponseEntity.status( HttpStatus.CREATED).body(companiaDB);
    }

    @Operation(summary="End-point para obtener la información de todos las compania registradas", description="Mostrara a todas las companias que se" +
            "registraron", tags={"companias"})
    @GetMapping(path = "all")
    public ResponseEntity<List<Compania>> listAllCompania() {
        List<Compania> companias = companiaService.findCompaniaAll();
        if (companias.isEmpty()) {
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(companias);
    }

    @Operation(summary="End-point para eliminar a una compania segun su 'id' ", description="Se eliminara a una compania en especifico" +
            "segun su 'id'", tags={"companias"})
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Compania> deleteCompania(@PathVariable("id") Long id){
        Compania compania = companiaService.getCompania(id);
        if (compania == null) {
            return  ResponseEntity.notFound().build();
        }
        companiaService.deleteCompania(compania);
        return ResponseEntity.ok(compania);
    }

    @Operation(summary="End-point para modificar los datos de la compania segun su 'id' ", description="Se modificara a una compania en especifico" +
            "segun su 'id' ", tags={"companias"})
    @PutMapping(value = "update/{id}")
    public ResponseEntity<?> updateCompania(@PathVariable("id") Long id, @RequestBody Compania companias) {
        Compania currentCompania = companiaService.getCompania(id);

        if ( null == currentCompania ) {
            return  ResponseEntity.notFound().build();
        }

        companias.setId(id);
        currentCompania    =   companiaService.updateCompania(companias);
        return  ResponseEntity.ok(currentCompania);
    }

    @Operation(summary="End-point para obtener la información de una compania segun su 'id' ", description="Ingresar un numero de 'id'" +
            "para obtener la información de la compania.", tags={"companias"})
    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Compania> fetchById (@PathVariable("id") Long id){
        try{
            //Para la gestion de los errores
            Optional<Compania> optionalCompania = companiaService.findById(id);

            if (optionalCompania.isPresent()){
                return new ResponseEntity<Compania>(optionalCompania.get(), HttpStatus.OK);
            }else  {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
