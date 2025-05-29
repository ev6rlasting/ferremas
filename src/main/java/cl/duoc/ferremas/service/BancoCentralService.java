package cl.duoc.ferremas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BancoCentralService {

    private static final Logger logger = LoggerFactory.getLogger(BancoCentralService.class);
    private final RestTemplate restTemplate;

    public BancoCentralService() {
        this.restTemplate = new RestTemplate();
        this.restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("https://mindicador.cl/api"));
    }

    @SuppressWarnings("unchecked")
    private double obtenerValorIndicador(String indicador) {
        try {
            Map<String, Object> response = restTemplate.getForObject("/" + indicador, Map.class);
            if (response != null && response.containsKey("serie")) {
                List<Map<String, Object>> serie = (List<Map<String, Object>>) response.get("serie");
                Optional<Map<String, Object>> primerValor = serie.stream().findFirst();
                if (primerValor.isPresent()) {
                    return ((Number) primerValor.get().get("valor")).doubleValue();
                }
            }
        } catch (Exception e) {
            logger.error("Error al obtener el valor del indicador " + indicador, e);
        }
        return 0.0;
    }

    public double obtenerValorDolar() {
        return obtenerValorIndicador("dolar");
    }

    public double obtenerValorEuro() {
        return obtenerValorIndicador("euro");
    }

    public double obtenerValorUF() {
        return obtenerValorIndicador("uf");
    }

    // Conversiones bidireccionales

    // USD a CLP
    public double convertirUSDaCLP(double usd) {
        double valorDolar = obtenerValorDolar();
        return usd * valorDolar;
    }

    // CLP a USD
    public double convertirCLPaUSD(double clp) {
        double valorDolar = obtenerValorDolar();
        if (valorDolar == 0) return 0;
        return clp / valorDolar;
    }

    // UF a CLP
    public double convertirUFaCLP(double uf) {
        double valorUF = obtenerValorUF();
        return uf * valorUF;
    }

    // CLP a UF
    public double convertirCLPaUF(double clp) {
        double valorUF = obtenerValorUF();
        if (valorUF == 0) return 0;
        return clp / valorUF;
    }

    // EUR a CLP
    public double convertirEUROaCLP(double euro) {
        double valorEuro = obtenerValorEuro();
        return euro * valorEuro;
    }

    // CLP a EUR
    public double convertirCLPaEURO(double clp) {
        double valorEuro = obtenerValorEuro();
        if (valorEuro == 0) return 0;
        return clp / valorEuro;
    }
}
