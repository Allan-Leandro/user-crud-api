package com.allan.user_crud_api.Service;

import com.allan.user_crud_api.exception.UsuarioNaoEncontradoException;
import com.allan.user_crud_api.model.Tarefa;
import com.allan.user_crud_api.model.Usuario;
import com.allan.user_crud_api.repository.TarefaRepository;
import com.allan.user_crud_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;

    public TarefaService(TarefaRepository tarefaRepository, UsuarioRepository usuarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Tarefa> listarPorUsuario(Long usuarioId){
        return tarefaRepository.findByUsuarioId(usuarioId);
    }

    public Tarefa criar(Long usuarioId, Tarefa tarefa){
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));

        tarefa.setUsuario(usuario);
        return tarefaRepository.save(tarefa);
    }

   public Tarefa buscarPorId(Long id){
        return tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
   }

    public Tarefa atualizar(Long id, Tarefa dadosAtualiazados){
        Tarefa tarefaExistente = buscarPorId(id);
        tarefaExistente.setTitulo(dadosAtualiazados.getTitulo());
        tarefaExistente.setDescricao(dadosAtualiazados.getDescricao());
        tarefaExistente.setConcluida(dadosAtualiazados.isConcluida());
        return tarefaRepository.save(tarefaExistente);
    }

    public void deletar(Long id){
        Tarefa tarefa = buscarPorId(id);
        tarefaRepository.deleteById(tarefa.getId());
    }
}
