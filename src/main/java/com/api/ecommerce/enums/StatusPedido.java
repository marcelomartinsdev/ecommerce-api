package com.api.ecommerce.enums;

public enum StatusPedido {
    EM_ATENDIMENTO(1, "Em atendimento"),
    AGUARDANDO_CONFIMACO_PAGAMENTO(2, "Aguardando confimação pagamento"),
    CANCELADO(3, "Cancelado"),
    EXPEDIDO(4, "Expedido"),
    ENTREGUE(5, "Entregue"),
    AGUARDANDO_EXPEDICAO(6, "Aguardando expedição");

    private Integer codigo;
    private String descricao;

    StatusPedido(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
