import java.util.ArrayList;

public class User {
    public String nome;
    public int cep;
    public String email;
    public String senha;
    public ArrayList<Playlist> playlists;

    public User(String nome, int cep, String email, String senha){
        this.nome = nome;
        this.cep = cep;
        this.email = email;
        this.senha = senha;
        this.playlists = new ArrayList<Playlist>();
    }

    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }
    public void removerPlaylist(Playlist playlist) {
        this.playlists.remove(playlist);
    }
    public String getNome() {
        return this.nome;
    }
    public void setNome(String novo_nome) {
        this.nome = novo_nome;
    }
    public int getCep() {
        return this.cep;
    }
    public void setCep(int novo_cep) {
        this.cep = novo_cep;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String novo_email) {
        this.email = novo_email;
    }
    public String getSenha() {
        return this.senha;
    }
    public void setSenha(String nova_senha) {
        this.senha = nova_senha;
    }
    public ArrayList<Playlist> getPlaylists() {
        return this.playlists;
    }
}
