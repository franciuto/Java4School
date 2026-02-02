public class BuonoRegalo implements MetodoPagamento {
    @Override
    public boolean paga(float importo) {
        if (importo < 0) {
            throw new IllegalArgumentException("Importo non può essere negativo");
        }
        System.out.println("Buono Regalo: " + importo);
        return true;
    }
}
