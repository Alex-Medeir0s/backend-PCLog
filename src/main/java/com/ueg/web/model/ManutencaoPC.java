package com.ueg.web.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "manutencao_pc")
public class ManutencaoPC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "equipamento")
    private String equipamento;

    @Column(name = "tipo_manutencao")
    private String tipoManutencao;

    @Column(name = "custo")
    private Double custo;

    @Column(name = "data_manutencao")
    private LocalDate dataManutencao;

    @Column(name = "foi_concluida")
    private Boolean foiConcluida;

    @Column(name = "cliente")
    private String cliente;

    public ManutencaoPC() {}

    public ManutencaoPC(Long id, String equipamento, String tipoManutencao, Double custo,
                        LocalDate dataManutencao, Boolean foiConcluida, String cliente) {
        this.id = id;
        this.equipamento = equipamento;
        this.tipoManutencao = tipoManutencao;
        this.custo = custo;
        this.dataManutencao = dataManutencao;
        this.foiConcluida = foiConcluida;
        this.cliente = cliente;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEquipamento() { return equipamento; }
    public void setEquipamento(String equipamento) { this.equipamento = equipamento; }

    public String getTipoManutencao() { return tipoManutencao; }
    public void setTipoManutencao(String tipoManutencao) { this.tipoManutencao = tipoManutencao; }

    public Double getCusto() { return custo; }
    public void setCusto(Double custo) { this.custo = custo; }

    public LocalDate getDataManutencao() { return dataManutencao; }
    public void setDataManutencao(LocalDate dataManutencao) { this.dataManutencao = dataManutencao; }

    public Boolean getFoiConcluida() { return foiConcluida; }
    public void setFoiConcluida(Boolean foiConcluida) { this.foiConcluida = foiConcluida; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
}
