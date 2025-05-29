package cl.duoc.ferremas.service;

import cl.transbank.webpay.common.WebpayOptions;
import cl.transbank.webpay.webpayplus.WebpayPlus;
import cl.transbank.webpay.webpayplus.responses.WebpayPlusTransactionCreateResponse;
import cl.transbank.webpay.webpayplus.responses.WebpayPlusTransactionCommitResponse;

import org.springframework.stereotype.Service;

import java.util.UUID;

import static cl.transbank.common.IntegrationApiKeys.WEBPAY;
import static cl.transbank.common.IntegrationCommerceCodes.WEBPAY_PLUS;
import static cl.transbank.common.IntegrationType.TEST;

@Service
public class WebpayService {

    private static final WebpayOptions options = new WebpayOptions(
            WEBPAY_PLUS,
            WEBPAY,
            TEST
    );


    private static final String RETURN_URL = "http://localhost:8080/webpay/confirmacion";

    public WebpayPlusTransactionCreateResponse crearTransaccion(Float monto) throws Exception {
        String buyOrder = UUID.randomUUID().toString().substring(0, 26);
        String sessionId = UUID.randomUUID().toString().substring(0, 26);

        System.out.println("Creando transacción:");
        System.out.println("buyOrder: " + buyOrder);
        System.out.println("sessionId: " + sessionId);
        System.out.println("monto: " + monto);
        System.out.println("returnUrl: " + RETURN_URL);

        WebpayPlus.Transaction tx = new WebpayPlus.Transaction(options);
        WebpayPlusTransactionCreateResponse response = tx.create(buyOrder, sessionId, monto, RETURN_URL);

        System.out.println("Token para pago: " + response.getToken());
        System.out.println("URL para pago: " + response.getUrl());

        return response;
    }

    public WebpayPlusTransactionCommitResponse confirmarTransaccion(String token) throws Exception {
        System.out.println("Confirmando token: " + token);

        WebpayPlus.Transaction tx = new WebpayPlus.Transaction(options);
        WebpayPlusTransactionCommitResponse response = tx.commit(token);

        System.out.println("Respuesta confirmación: " + response);

        return response;
    }
}
