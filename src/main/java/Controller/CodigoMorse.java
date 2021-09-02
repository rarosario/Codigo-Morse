package Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorse {

    @GetMapping("/converter")
    public String codigoMorse(@RequestParam String frase) {

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--..", " "};

        String textoMorse = frase.trim();
        String textoAlfabeto = "";

        String[] posic = textoMorse.split(" ");
        String trecho;

        if (frase.length() == 0) {
            System.out.println("Valor invalido");
        } else {
            for (int i = 0; i < posic.length; i++) {
                int idx = textoMorse.indexOf(" ") == -1 ? textoMorse.length() : textoMorse.indexOf(" ");
                trecho = textoMorse.substring(0, idx);
                textoMorse = textoMorse.substring(trecho.length()).trim();
                if (trecho.equals("/")) {
                    textoAlfabeto += " ";
                } else {
                    for (int j = 0; j < morse.length; j++) {
                        if (morse[j].equals(trecho)) {
                            textoAlfabeto += getLetra(j);
                            break;
                        }
                    }
                }
            }
        }
        return textoAlfabeto;
    }

    public static String getLetra(Integer indice) {
        String[] portugues = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                ",", ".", "?", " "};

        return portugues[indice];
    }
}
