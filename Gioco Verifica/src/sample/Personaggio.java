package sample;

public class Personaggio {
    public String nome;
    public int fx; //forza
    public int xp; //esperienza

    //costruttore
    public Personaggio(String nome, int fx, int xp) {
        this.nome = nome;
        this.fx = fx;
        this.xp = xp;
    }


    //getter e setter

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getFx() {
        return fx;
    }


    public void setFx(int fx) {
        this.fx = fx;
    }


    public int getXp() {
        return xp;
    }


    public void setXp(int xp) {
        this.xp = xp;
    }

    //metodi aggiuntivi (sfida)

    public int sfida (Personaggio pg2) {//ritorna + se questo pg ha vinto, - se ha perso e 0 se è un pareggio
        int ret=0;

        if (this.fx>pg2.getFx()) {
            ret=this.fx-pg2.getFx();
        }

        else if (this.fx<pg2.getFx()) {
            ret = this.fx-pg2.getFx();
        }

        else if (this.xp<pg2.getXp()) {
            ret = this.xp-pg2.getXp();
        }

        else if (this.xp>pg2.getXp()) {
            ret = this.xp-pg2.getXp();
        }

        return ret;
    }


    //toString
    public String toString() {
        return "Personaggio [nome=" + nome + ", forza=" + fx + ", esperienza=" + xp + "]";
    }

}
