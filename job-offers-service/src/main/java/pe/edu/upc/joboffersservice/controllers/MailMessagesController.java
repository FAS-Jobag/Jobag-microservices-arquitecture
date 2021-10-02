package pe.edu.upc.joboffersservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.joboffersservice.entities.MailMessage;
import pe.edu.upc.joboffersservice.services.MailMessageService;

import java.util.Optional;

@RestController
@RequestMapping("api/mail-messages")
public class MailMessagesController {
    @Autowired
    private MailMessageService mailMessageService;

    @Operation(summary = "find mail message by id", tags = {"mail-messages"})
    @ApiResponse(responseCode = "200", description = "this return a mail message by id")
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MailMessage> getById(@PathVariable Long id) {
        try {
            Optional<MailMessage> result = mailMessageService.findById(id);
            return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "save a mail message", tags = {"mail-messages"})
    @ApiResponse(responseCode = "200", description = "this return the mail message saved")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MailMessage> save(@RequestBody MailMessage mailMessage) {
        try {
            return ResponseEntity.ok(mailMessageService.save(mailMessage));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "update a mail message for id", tags = {"mail-messages"})
    @ApiResponse(responseCode = "200", description = "this return the mail message updated")
    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MailMessage> update(@PathVariable Long id, @RequestBody MailMessage mailMessage) {
        try {
            return ResponseEntity.ok(mailMessageService.update(id, mailMessage));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "delete a mail message for id", tags = {"mail-messages"})
    @ApiResponse(responseCode = "200", description = "It returns ok or internal server error")
    @DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MailMessage> deleteById(@PathVariable Long id) {
        try {
            mailMessageService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
