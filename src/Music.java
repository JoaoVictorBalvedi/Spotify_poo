public class Music {
    public String nome;
    public String autor;
    public String album;
    public String genero;
    public float duracao;

    public Music(String nome, String autor, String album, String genero) {
        this.nome = nome;
        this.autor = autor;
        this.album = album;
        this.genero = genero;
        this.duracao = duracao;
    }

    public void Play(){
        System.out.println("Tocando música: " + this.nome);
        System.out.println("...");
        System.out.println("Música finalizada: " + this.nome);
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String novo_nome){
        this.nome = novo_nome;
    }
    public String getAutor() {
        return this.autor;
    }
    public void setAutor(String novo_autor){
        this.autor = novo_autor;
    }
    public String getAlbum() {
        return this.album;
    }
    public void setAlbum(String novo_album){
        this.album = novo_album;
    }
    public String getGenero() {
        return this.genero;
    }
    public void setGenero(String novo_genero){
        this.genero = novo_genero;
    }
    public float getDuracao() {
        return this.duracao;
    }
    public void setDuracao(int nova_duracao){
        this.duracao = nova_duracao;
    }
}
