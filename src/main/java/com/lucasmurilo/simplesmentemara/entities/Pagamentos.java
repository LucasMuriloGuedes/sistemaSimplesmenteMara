package com.lucasmurilo.simplesmentemara.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucasmurilo.simplesmentemara.entities.enums.TipoPagamento;

import javax.persistence.*;

@Entity
public class Pagamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer tipoPagamento;
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @JsonIgnore
    private Pedido pedido;


    public Pagamentos(){

    }

    public Pagamentos(Integer id, TipoPagamento tipoPagamento) {
        this.id = id;
        this.tipoPagamento = tipoPagamento.getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoPagamento getTipoPagamento() {
        return TipoPagamento.toEnum(tipoPagamento);
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento.getCod();
    }
}
