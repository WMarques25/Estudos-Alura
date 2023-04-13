package br.well.screenmatch.exception;

public class AnoMaiorQueQuatroDigitosException extends RuntimeException{
    private String message;
    public AnoMaiorQueQuatroDigitosException(String message) {
        this.message = message;
        
    }

    @Override
    public String getMessage() {
        return message;
    }
}
