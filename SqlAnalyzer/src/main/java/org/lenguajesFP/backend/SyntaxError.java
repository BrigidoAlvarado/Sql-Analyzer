package org.lenguajesFP.backend;

public class SyntaxError {
    private final Token errorToken;
    private final String description;

    public SyntaxError(Token errorToken, String description) {
        this.errorToken = errorToken;
        this.description = description;
    }

    public Token getErrorToken() {
        return errorToken;
    }

    public String getDescription() {
        return description;
    }
}
