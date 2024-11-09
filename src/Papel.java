class Papel {
    private int leitores = 0;
    private boolean escritorAtivo = false;
    public void lerOPapel(int nome) {
        synchronized (this) {
            while (escritorAtivo) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            leitores++;
        }
        System.out.println("Leitor " + nome + " está lendo.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        synchronized (this) {
            leitores--;
            if (leitores == 0) {
                notifyAll();
            }
        }
        System.out.println("Leitor " + nome + " terminou de ler.");
    }
    public synchronized void escrever(int nome) {
        while (leitores > 0 || escritorAtivo) {
            try {
                System.out.println("Escritor " + nome + " está esperando para escrever.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        escritorAtivo = true;
        System.out.println("Escritor " + nome + " está escrevendo.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        escritorAtivo = false;
        notifyAll();
        System.out.println("Escritor " + nome + " terminou de escrever.");
    }
}