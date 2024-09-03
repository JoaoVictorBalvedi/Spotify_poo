import java.util.ArrayList;

public class Playlist {
    public String nome;
    public ArrayList<Music> musicas;



    public Playlist(String nome){
        this.nome = nome;
        this.musicas = new ArrayList<Music>();
    }

    public void addMusic(Music musica){

        this.musicas.add(musica);
    }

    public void removeMusic(Music musica){

        this.musicas.remove(musica);
    }

    public void Play(){
        for(int i = 0; i < this.musicas.size(); i++){
            System.out.println("Tocando música: " + this.musicas.get(i).getNome());
            System.out.println("...");
            System.out.println("Música finalizada!");
        }
    }

    public String getNome() {

        return this.nome;
    }
    public void setNome(String novo_nome){

        this.nome = novo_nome;
    }
    public ArrayList<Music> getMusicas() {

        return this.musicas;
    }
    public void setMusicas(ArrayList<Music> novas_musicas){
        this.musicas = novas_musicas;
    }
    public float getDuracaoTotal(){
        float duracao_total = 0;
        for(int i = 0; i < this.musicas.size(); i++){
            duracao_total += this.musicas.get(i).getDuracao();
        }
        return duracao_total;
    }
}
