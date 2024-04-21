package marcos.api.demo.consultaCep;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consulta-cep")
public class consultaCepApi {

    @GetMapping("{cep}")
    public CepResult consultaCep (@PathVariable("cep") String cep) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CepResult> resp =
                restTemplate.
                        getForEntity(String.format("https://viacep.com.br/ws/%s/json/", cep), CepResult.class);
        return resp.getBody();
    }
    @PostMapping("processar-dados")
    public ResponseEntity<String> processarDados(@RequestBody DadosParaProcessar dados) {
        System.out.println("Dados recebidos para processamento:");
        System.out.println("Nome: " + dados.getNome());
        System.out.println("Idade: " + dados.getIdade());
        return ResponseEntity.status(HttpStatus.OK).body("Dados processados com sucesso");
    }
}

