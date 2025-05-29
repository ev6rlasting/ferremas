package cl.duoc.ferremas.controller;

import cl.duoc.ferremas.service.BancoCentralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bancocentral")
public class BancoCentralController {

    @Autowired
    private BancoCentralService bancoCentralService;

    @GetMapping("/dolar")
    public double obtenerValorDolar() {
        return bancoCentralService.obtenerValorDolar();
    }

    @GetMapping("/euro")
    public double obtenerValorEuro() {
        return bancoCentralService.obtenerValorEuro();
    }

    @GetMapping("/uf")
    public double obtenerValorUF() {
        return bancoCentralService.obtenerValorUF();
    }

    @GetMapping("/convertir/usdaclp")  // USD a CLP
    public double convertirUSDaCLP(@RequestParam double usd) {
        return bancoCentralService.convertirUSDaCLP(usd);
    }

    @GetMapping("/convertir/clpausd")  // CLP a USD
    public double convertirCLPaUSD(@RequestParam double clp) {
        return bancoCentralService.convertirCLPaUSD(clp);
    }

    @GetMapping("/convertir/ufaclp")  // UF a CLP
    public double convertirUFaCLP(@RequestParam double uf) {
        return bancoCentralService.convertirUFaCLP(uf);
    }

    @GetMapping("/convertir/clpauf")  // CLP a UF
    public double convertirCLPaUF(@RequestParam double clp) {
        return bancoCentralService.convertirCLPaUF(clp);
    }

    @GetMapping("/convertir/euroaclp")  // EUR a CLP
    public double convertirEUROaCLP(@RequestParam double euro) {
        return bancoCentralService.convertirEUROaCLP(euro);
    }

    @GetMapping("/convertir/clpaeuro")  // CLP a EUR
    public double convertirCLPaEURO(@RequestParam double clp) {
        return bancoCentralService.convertirCLPaEURO(clp);
    }
}
