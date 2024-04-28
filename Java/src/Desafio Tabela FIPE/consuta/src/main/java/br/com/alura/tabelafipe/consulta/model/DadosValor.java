package br.com.alura.tabelafipe.consulta.model;

public record DadosValor(
    Integer TipoVeiculo,
    String Valor,
    String Marca,
    String Modelo,
    String AnoModelo,
    String Combustivel,
    String CodigoFipe,
    String MesReferencia,
    char SiglaCombustivel
) {
    // // Constructor
    // public DadosValor(Integer TipoVeiculo, String Valor, String Marca, String Modelo, String AnoModelo, String Combustivel, String CodigoFipe, String MesReferencia, char SiglaCombustivel) {
    //     this(TipoVeiculo, Valor, Marca, Modelo, AnoModelo, Combustivel, CodigoFipe, MesReferencia, SiglaCombustivel);
    // }
    // @Override
    // public String toString() {
    //     return .format(tipo(TipoVeiculo), Marca, Modelo, AnoModelo,
    //                 Valor, Combustivel, SiglaCombustivel,
    //                 CodigoFipe, MesReferencia) ;
    // }
    @Override
    public String toString() {
    return String.format("""
             Tipo: %s - Marca: %s
             Modelo: %s - Ano: %s
             Valor: %s
             Combustível: %s - %s
             Código FIPE: %s
             Referência: %s
             """,
            tipo(TipoVeiculo), Marca, Modelo, AnoModelo,
            Valor, Combustivel, SiglaCombustivel,
            CodigoFipe, MesReferencia);
}

    private static String tipo(Integer i){
        switch (i) {
            case 1:
                return "MOTO";
            case 2:
                return "CARRO";
            case 3:
                return "CAMINHÃO";
            default:
                return null;
        }
    }
}
