package br.com.opet.tds.androidaulajson;

import java.util.List;

public class Carro {
    private long ID;
    private String marca;
    private String modelo;
    private int fabricacao;
    private boolean automatico;
    private List<String> opcionais;

    public Carro() {
    }

    public Carro(long ID, String marca, String modelo, int fabricacao, boolean automatico, List<String> opcionais) {
        this.ID = ID;
        this.marca = marca;
        this.modelo = modelo;
        this.fabricacao = fabricacao;
        this.automatico = automatico;
        this.opcionais = opcionais;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(int fabricacao) {
        this.fabricacao = fabricacao;
    }

    public boolean isAutomatico() {
        return automatico;
    }

    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }

    public List<String> getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(List<String> opcionais) {
        this.opcionais = opcionais;
    }

    @Override
    public String toString() {
        String opc = "[";
        for(String item : opcionais){
            opc += item + " ";
        }
        opc = opc.trim();
        opc += "]";

        return "Carro{" +
                "ID=" + ID +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", fabricacao=" + fabricacao +
                ", automatico=" + automatico +
                ", opcionais=" + opc +
                '}';
    }
}
