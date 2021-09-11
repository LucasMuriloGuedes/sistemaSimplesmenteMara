package com.lucasmurilo.simplesmentemara.entities.enums;

public enum TipoPagamento {
    PAGAMENTO_CARTAO(1),
    PAGAMETO_DINHEIRO(2),
    PAGAMENTO_PIX(3);

    private Integer cod;

    TipoPagamento(Integer cod) {
        this.cod = cod;
    }

    public Integer getCod() {
        return cod;
    }

    public static TipoPagamento toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(TipoPagamento x : TipoPagamento.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
