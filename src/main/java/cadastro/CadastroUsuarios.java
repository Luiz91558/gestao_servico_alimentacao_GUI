package cadastro;
import exceptions.IDExistenteException;
import exceptions.IdNaoEncontradoException;
import exceptions.LoginOuDicaSenhaIncorretoException;
import exceptions.LoginOuSenhaIncorretoException;
import repository.RepositorioUsuario;
import modelo.Usuario;

public class CadastroUsuarios {
    private RepositorioUsuario repositorio;

    // Adicionar Singleton
    public CadastroUsuarios() {
        this.repositorio = RepositorioUsuario.getInstance();
    }
    public Usuario buscarUsuario(String ID) throws IdNaoEncontradoException {
        Usuario usuario = repositorio.buscarUsuario(ID);
        if(usuario == null) {
            throw new IdNaoEncontradoException(ID, "usuário");
        }
        return usuario;
    }
    public void adicionarUsuario(Usuario usuario) throws IDExistenteException {

        if(repositorio.buscarUsuario(usuario.getId()) == null) {
            repositorio.adicionarUsuario(usuario);
        }
        else {
            throw new IDExistenteException(usuario.getId(), "usuário");
        }
    }
    public void removerUsuario(Usuario usuario) throws IdNaoEncontradoException {
        if(repositorio.buscarUsuario(usuario.getId()) == null) {
            throw new IdNaoEncontradoException(usuario.getId(), "usuário");
        }
        repositorio.removerUsuario(usuario);
    }
    public Usuario validarEntrada(String login, String senha) throws LoginOuSenhaIncorretoException {
        Usuario[] usuarios = repositorio.getUsuarios();
        for(int i = 0; i < repositorio.getPosicaoLivre(); i++){
            if(usuarios[i].getLogin().equals(login) && usuarios[i].getSenha().equals(senha)){
                return usuarios[i];
            }
        }
        throw new LoginOuSenhaIncorretoException("Login ou senha incorreto");
    }
    public Usuario recuperarSenha(String login, String dicaSenha) throws LoginOuDicaSenhaIncorretoException {
        Usuario[] usuarios = repositorio.getUsuarios();
        for(int i = 0; i < repositorio.getPosicaoLivre(); i++){
            if(usuarios[i].getDicaSenha().equals(dicaSenha) && usuarios[i].getLogin().equals(login)){
                return usuarios[i];
            }
        }
        throw new LoginOuDicaSenhaIncorretoException("O login ou a dica senha está incorreto");
    }
}
