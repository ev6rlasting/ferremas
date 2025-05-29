package cl.duoc.ferremas.controller;

import cl.duoc.ferremas.service.WebpayService;
import cl.transbank.webpay.webpayplus.responses.WebpayPlusTransactionCreateResponse;
import cl.transbank.webpay.webpayplus.responses.WebpayPlusTransactionCommitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webpay")
public class WebpayController {

    @Autowired
    private WebpayService webpayService;

    @PostMapping("/crear")
    public ResponseEntity<WebpayPlusTransactionCreateResponse> crearTransaccion(@RequestParam Float monto) {
        try {
            WebpayPlusTransactionCreateResponse response = webpayService.crearTransaccion(monto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/confirmacion")
    public ResponseEntity<WebpayPlusTransactionCommitResponse> confirmar(@RequestParam String token_ws) {
        try {
            WebpayPlusTransactionCommitResponse response = webpayService.confirmarTransaccion(token_ws);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
