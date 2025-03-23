import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ListaCuritiba {

    public static void main(String[] args) {

        Map<Character, List<String>> bairrosPorLetra = new HashMap<>();

        // Lista de bairros organizada
        List<String> nomes = List.of(
            "Abranches", "Água Verde", "Ahu", "Alto Boqueirão", "Alto da Glória", "Alto da XV",
            "Atuba", "Augusta", "Bacacheri", "Bairro Alto", "Barreirinha", "Batel", "Boa Vista", "Bom Retiro", 
            "Boqueirão", "Butiatuvinha", "Cabral", "Cachoeira", "Cajuru", "Campina do Siqueira", "Campo Comprido", 
            "Campo de Santana", "Capão da Imbuia", "Capão Raso", "Cascatinha", "Centro", "Centro Civico", "Centro Histórico", 
            "Caximba", "Champagnat", "Cidade Industrial", "Cristo Rei", "Fanny, Fazendinha", "Ganchinho", "Guabirotuba", 
            "Guaira", "Hauer", "Hugo Lange", "Jardim Botânico", "Jardim Social", "Jardim das Americas", "Juvevê", 
            "Lamenha Pequena", "Lindoia", "Mercês", "Mossunguê", "Novo Mundo", "Orleans", "Parolin", "Pilarzinho", 
            "Pinheirinho", "Portão", "Prado Velho", "Rebouças", "Riviera", "Santa Cândida", "Santa Felicidade", 
            "Santa Quiteria", "Santo Inácio", "São Braz", "São Francisco", "São João", "São Lourenço", "São Miguel", 
            "Seminário", "Sitio Cercado", "Taboão", "Tarumã", "Tatuquara", "Tingui", "Uberaba", "Umbará", "Vila Isabel", 
            "Vista Alegre", "Xaxim"
        );

        for (String nome : nomes) {
            char primeiraLetra = Character.toUpperCase(nome.charAt(0));

            if (Character.isAlphabetic(primeiraLetra)) {
                bairrosPorLetra
                        .computeIfAbsent(primeiraLetra, k -> new ArrayList<>())
                        .add(nome);
            }
        }

        // Limita o tamanho das listas para 16
        for (List<String> bairros : bairrosPorLetra.values()) {
            if (bairros.size() > 16) {
                bairros.subList(16, bairros.size()).clear();
            }
            Collections.sort(bairros);
        }

        // Solicita a letra
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma letra (A-Z): ");
        char letra = Character.toUpperCase(scanner.next().charAt(0));

        // Exibe a lista
        List<String> bairrosDaLetra = bairrosPorLetra.get(letra);
        if (bairrosDaLetra != null) {
            System.out.println("Nomes que começam com a letra " + letra + ":");
            bairrosDaLetra.forEach(System.out::println);
        } else {
            System.out.println("Não há nomes para a letra " + letra + ".");
        }
    }
}
