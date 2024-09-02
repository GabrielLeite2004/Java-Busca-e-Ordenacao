package Util.Gerenciador_de_Arquivos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 public class Manipulador {
        private BufferedReader reader;
        private String ultimaLinhaLida;

        public Manipulador(String filePath) {
            try {
                reader = new BufferedReader(new FileReader(filePath));
                ultimaLinhaLida = null;
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        public String lerProximaLinha() {
            try {
                if (reader != null) {
                    ultimaLinhaLida = reader.readLine();
                    return ultimaLinhaLida;
                } else {
                    System.out.println("Error: BufferedReader is null.");
                    return null;
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                return null;
            }
        }

        public void fecharArquivo() {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

