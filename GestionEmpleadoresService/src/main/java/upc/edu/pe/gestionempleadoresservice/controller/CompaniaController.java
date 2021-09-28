package upc.edu.pe.gestionempleadoresservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import upc.edu.pe.gestionempleadoresservice.entities.Compania;
import upc.edu.pe.gestionempleadoresservice.entities.Empleador;
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

    @Operation(summary="End-point para la creación de una compania con su respectivo empleador y sector", description="Completar los datos que se solicita", tags={"companias"})
    @PostMapping(path = "create-compania/Empleadores/empleadorId/{empleadorId}/Sector/{sectorId}")
    public ResponseEntity<Compania> createCompania(@Valid @RequestBody Compania compania, BindingResult result) throws Exception {
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Compania companiaCreate =  companiaService.save(compania);
        return ResponseEntity.status(HttpStatus.CREATED).body(companiaCreate);
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
