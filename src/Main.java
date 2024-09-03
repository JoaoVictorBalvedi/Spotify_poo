import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        User user1 = new User("João", 12345678, "joao@gmail.com", "123456");
        User user2 = new User("Maria", 87654321, "maria@gmail.com", "QWERTY");
        User user3 = new User("Pedro", 12345678, "pedro@gmail.com", "123");

        Playlist playlist1 = new Playlist("Metal");
        Playlist playlist2 = new Playlist("Rock");
        Playlist playlist3 = new Playlist("Rap");

        Music music1 = new Music("Liar", "Korn", "See you on the other side", "Metal");
        Music music2 = new Music("Fade to black", "Metallica", "Ride the lightning", "Metal");
        Music music3 = new Music("Wait and bleed", "Slipknot", "Single", "Metal");
        Music music4 = new Music("Lithium", "Nirvana", "Nevermind", "Rock");
        Music music5 = new Music("Drug Ballad", "Eminem", "The Marshall Mathers LP", "Rap");
        Music music6 = new Music("Astroworld", "Travis Scott", "Astroworld", "Rap");

        playlist1.addMusic(music1);
        playlist1.addMusic(music2);
        playlist1.addMusic(music3);
        playlist2.addMusic(music4);
        playlist3.addMusic(music5);
        playlist3.addMusic(music6);

        user1.addPlaylist(playlist1);
        user1.addPlaylist(playlist2);
        user1.addPlaylist(playlist3);
        user2.addPlaylist(playlist1);
        user2.addPlaylist(playlist2);
        user2.addPlaylist(playlist3);
        user3.addPlaylist(playlist1);
        user3.addPlaylist(playlist2);

        // Menu para interação com o usuário
        boolean exit = false;
        User currentUser = null;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1 - Fazer login");
            System.out.println("2 - Ver suas playlists");
            System.out.println("3 - Tocar playlist");
            System.out.println("4 - Tocar música específica");
            System.out.println("5 - Adicionar música a uma playlist");
            System.out.println("6 - Remover música de uma playlist");
            System.out.println("7 - Lançar nova música");
            System.out.println("8 - Sair");

            System.out.print("Escolha uma opção: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consome a nova linha

            switch (choice) {
                case 1:
                    System.out.print("Digite seu email: ");
                    String email = sc.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senha = sc.nextLine();

                    if (user1.getEmail().equals(email) && user1.getSenha().equals(senha)) {
                        currentUser = user1;
                    } else if (user2.getEmail().equals(email) && user2.getSenha().equals(senha)) {
                        currentUser = user2;
                    } else if (user3.getEmail().equals(email) && user3.getSenha().equals(senha)) {
                        currentUser = user3;
                    } else {
                        System.out.println("Email ou senha incorretos!");
                        currentUser = null;
                    }

                    if (currentUser != null) {
                        System.out.println("Login efetuado com sucesso! Bem-vindo, " + currentUser.getNome());
                    }
                    break;

                case 2:
                    if (currentUser != null) {
                        System.out.println("Playlists de " + currentUser.getNome() + ":");
                        for (Playlist playlist : currentUser.getPlaylists()) {
                            System.out.println("- " + playlist.getNome());
                            for (Music musica : playlist.getMusicas()) {
                                System.out.println("  * " + musica.getNome() + " - " + musica.getAutor());
                            }
                        }
                    } else {
                        System.out.println("Por favor, faça login primeiro.");
                    }
                    break;

                case 3:
                    if (currentUser != null) {
                        System.out.print("Qual playlist você deseja tocar? ");
                        String nomePlaylist = sc.nextLine();
                        for (Playlist playlist : currentUser.getPlaylists()) {
                            if (playlist.getNome().equalsIgnoreCase(nomePlaylist)) {
                                playlist.Play();
                                break;
                            }
                        }
                    } else {
                        System.out.println("Por favor, faça login primeiro.");
                    }
                    break;

                case 4:
                    if (currentUser != null) {
                        System.out.println("Músicas disponíveis:");
                        for (Playlist playlist : currentUser.getPlaylists()) {
                            for (Music musica : playlist.getMusicas()) {
                                System.out.println("  * " + musica.getNome() + " - " + musica.getAutor());
                            }
                        }
                        System.out.print("Digite o nome da música que deseja tocar: ");
                        String nomeMusica = sc.nextLine();
                        for (Playlist playlist : currentUser.getPlaylists()) {
                            for (Music musica : playlist.getMusicas()) {
                                if (musica.getNome().equalsIgnoreCase(nomeMusica)) {
                                    musica.Play();
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Por favor, faça login primeiro.");
                    }
                    break;

                case 5:
                    if (currentUser != null) {
                        System.out.print("Qual playlist você deseja adicionar uma música? ");
                        String nomePlaylist = sc.nextLine();
                        for (Playlist playlist : currentUser.getPlaylists()) {
                            if (playlist.getNome().equalsIgnoreCase(nomePlaylist)) {
                                System.out.print("Digite o nome da música: ");
                                String nomeMusica = sc.nextLine();
                                System.out.print("Digite o autor: ");
                                String autor = sc.nextLine();
                                System.out.print("Digite o álbum: ");
                                String album = sc.nextLine();
                                System.out.print("Digite o gênero: ");
                                String genero = sc.nextLine();

                                Music novaMusica = new Music(nomeMusica, autor, album, genero);
                                playlist.addMusic(novaMusica);
                                System.out.println("Música adicionada à playlist " + nomePlaylist);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Por favor, faça login primeiro.");
                    }
                    break;

                case 6:
                    if (currentUser != null) {
                        System.out.print("Qual playlist você deseja remover uma música? ");
                        String nomePlaylist = sc.nextLine();
                        for (Playlist playlist : currentUser.getPlaylists()) {
                            if (playlist.getNome().equalsIgnoreCase(nomePlaylist)) {
                                System.out.print("Digite o nome da música a ser removida: ");
                                String nomeMusica = sc.nextLine();
                                for (Music musica : playlist.getMusicas()) {
                                    if (musica.getNome().equalsIgnoreCase(nomeMusica)) {
                                        playlist.removeMusic(musica);
                                        System.out.println("Música removida da playlist " + nomePlaylist);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    } else {
                        System.out.println("Por favor, faça login primeiro.");
                    }
                    break;

                case 7:
                    System.out.print("Digite o nome da nova música: ");
                    String nomeMusica = sc.nextLine();
                    System.out.print("Digite o autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Digite o álbum: ");
                    String album = sc.nextLine();
                    System.out.print("Digite o gênero: ");
                    String genero = sc.nextLine();

                    Music novaMusica = new Music(nomeMusica, autor, album, genero);

                    if (currentUser != null) {
                        System.out.print("Deseja adicionar essa música a uma playlist? (sim/não): ");
                        String addToPlaylist = sc.nextLine();
                        if (addToPlaylist.equalsIgnoreCase("sim")) {
                            System.out.print("Digite o nome da playlist: ");
                            String nomePlaylist = sc.nextLine();
                            for (Playlist playlist : currentUser.getPlaylists()) {
                                if (playlist.getNome().equalsIgnoreCase(nomePlaylist)) {
                                    playlist.addMusic(novaMusica);
                                    System.out.println("Música adicionada à playlist " + nomePlaylist);
                                    break;
                                }
                            }
                        }
                    }
                    System.out.println("Nova música lançada no sistema.");
                    break;

                case 8:
                    exit = true;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        sc.close();
    }
}
