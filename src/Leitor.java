class Leitor implements Runnable {
    private final Papel recurso;
    private final int nome;

    public Leitor(Papel recurso, int nome) {
        this.recurso = recurso;
        this.nome = nome;
    }

    @Override
    public void run() {
        recurso.lerOPapel(nome);
    }
}

