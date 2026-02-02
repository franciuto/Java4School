public class Desktop extends PcFissi {
    private String tipoSchedaVideo;
    private String tipoSchedaAudio;

    public Desktop(String tipoProcessore, int memoriaDiMassa, int ram, String marca, String modello, String sistemaOperativo, String tipoDiCase, String tipoSchedaVideo, String tipoSchedaAudio) {
        super(tipoProcessore, memoriaDiMassa, ram, marca, modello, sistemaOperativo, tipoDiCase);
        this.tipoSchedaVideo = tipoSchedaVideo;
        this.tipoSchedaAudio = tipoSchedaAudio;
    }

    public String getTipoSchedaVideo() {
        return tipoSchedaVideo;
    }

    public void setTipoSchedaVideo(String tipoSchedaVideo) {
        this.tipoSchedaVideo = tipoSchedaVideo;
    }

    public String getTipoSchedaAudio() {
        return tipoSchedaAudio;
    }

    public void setTipoSchedaAudio(String tipoSchedaAudio) {
        this.tipoSchedaAudio = tipoSchedaAudio;
    }

    @Override
    public String toString() {
        return String.format("Desktop [Video: %s, Audio: %s] - %s", 
                tipoSchedaVideo, tipoSchedaAudio, super.toString());
    }
}
