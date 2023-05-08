import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GeradorArquivo {
    public void gerarArquivo(Endereco endereco) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(endereco.cep() + ".json");
        writer.write(gson.toJson(endereco));
        writer.close();
    }
}
