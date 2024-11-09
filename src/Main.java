

public class Main {
    public static void main(String[] args) {
        Papel recurso = new Papel();
        final int LEITORESEESCRITORES = 3;
        for (int i = 0; i < LEITORESEESCRITORES; i++) {
            String name = "LEITOR " + i;
            Leitor leitor = new Leitor(recurso, i);
            new Thread(leitor).start();
            String name2 = "ESCRITOR " + i;
            Escritor escritor = new Escritor(recurso, i);
            new Thread(escritor).start();
        }
    }
}
