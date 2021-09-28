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
import upc.edu.pe.gestionempleadoresservice.entities.Sector;
import upc.edu.pe.gestionempleadoresservice.services.SectorService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sectores")
public class SectorController {
    @Autowired
    private SectorService sectorService;

    @Operation(summary="End-point para la creación de un sector", description="Completar los datos que se solicita", tags={"sectores"})
    @PostMapping(path = "create")
    public ResponseEntity<Sector> createSector(@Valid @RequestBody Sector sector, BindingResult result) throws Exception {
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Sector sectorcreate =  sectorService.save(sector);
        return ResponseEntity.status(HttpStatus.CREATED).body(sectorcreate);
    }

    @Operation(summary="End-point para obtener la información de un sector segun su 'id' ", description="Ingresar un numero de 'id'" +
            "para obtener la información del sector.", tags={"sectores"})
    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sector> fetchById (@PathVariable("id") Long id){
        try{
            //Para la gestion de los errores
            Optional<Sector> optionalCliente = sectorService.findById(id);

            if (optionalCliente.isPresent()){
                return new ResponseEntity<Sector>(optionalCliente.get(), HttpStatus.OK);
            }else  {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary="End-point para obtener la información de todos los sectores registrados", description="Mostrara a todos los sectores que se" +
            "registraron", tags={"sectores"})
    @GetMapping(path = "all")
    public ResponseEntity<List<Sector>> listAllSectores() throws Exception {
        List<Sector> sectors = sectorService.findAll();
        if (sectors.isEmpty()) {
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(sectors);
    }

    @Operation(summary="End-point para eliminar al sector segun su 'id' ", description="Se eliminara a un sector en especifico" +
            "según su 'id'", tags={"sectores"})
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Sector> deleteSectores(@PathVariable("id") Long id) throws Exception {
        Sector sector = sectorService.getSector(id);
        if (sector == null) {
            return  ResponseEntity.notFound().build();
        }
        sectorService.deleteById(sector);
        return ResponseEntity.ok(sector);
    }

    @Operation(summary="End-point para modificar los datos del sector según su 'id' ", description="Se modificara un sector en especifico" +
            "segun su 'id' ", tags={"sectores"})
    @PutMapping(value = "update/{id}")
    public ResponseEntity<?> updateSector(@PathVariable("id") Long id, @RequestBody Sector sector) throws Exception {
        Sector currentSector = sectorService.getSector(id);

        if ( null == currentSector ) {
            return  ResponseEntity.notFound().build();
        }

        sector.setId(id);
        currentSector    =   sectorService.updateById(sector);
        return  ResponseEntity.ok(currentSector);
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
