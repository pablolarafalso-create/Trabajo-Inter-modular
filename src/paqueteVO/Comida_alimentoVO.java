package paqueteVO;

public class Comida_alimentoVO {
    private int id_comida;
    private int id_alimento;

    public Comida_alimentoVO(int id_alimento, int id_comida) {
        this.id_alimento = id_alimento;
        this.id_comida = id_comida;
    }

    public int getId_comida() {
        return id_comida;
    }

    public int getId_alimento() {
        return id_alimento;
    }

    public void setId_comida(int id_comida) {
        this.id_comida = id_comida;
    }

    public void setId_alimento(int id_alimento) {
        this.id_alimento = id_alimento;
    }

    @Override
    public String toString() {
        return "Comida_alimentoVO [id_comida=" + id_comida + ", id_alimento=" + id_alimento + "]";
    }
}
