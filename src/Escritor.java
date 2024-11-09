class Escritor implements Runnable {
    private final Papel recurso;
    private final int nome;

    public Escritor(Papel recurso, int nome) {
        this.recurso = recurso;
        this.nome = nome;
    }

    @Override
    public void run() {
        recurso.escrever(nome);
    }
}