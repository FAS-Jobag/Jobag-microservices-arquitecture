package upc.edu.pe.gestionempleadoresservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import upc.edu.pe.gestionempleadoresservice.entities.Compania;
import upc.edu.pe.gestionempleadoresservice.services.CompaniaService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/companias")
public class CompaniaController {
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

    /*
    @Operation(summary="End-point para obtener la información de todos las compania registradas", description="Mostrara a todas las companias que se" +
            "registraron", tags={"companias"})
    @GetMapping(path = "all")
    public ResponseEntity<List<Compania>> listAllCompania(@RequestParam(name = "sectorId" , required = false) Long sectorId ) {

        List<Compania> companias =  new ArrayList<>();
        if (null ==  sectorId) {
            companias = companiaService.findCompaniaAll();
            if (companias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        }else{
            Sector sector= new Sector();
            sector.setId(sectorId);
            companias = companiaService.findCompaniaBySector(sector);
            if ( null == companias ) {
                return  ResponseEntity.notFound().build();
            }
        }
        return  ResponseEntity.ok(companias);
    }

     */

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
