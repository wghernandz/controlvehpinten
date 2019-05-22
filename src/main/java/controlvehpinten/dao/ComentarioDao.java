package controlvehpinten.dao;

import java.util.List;

import controlvehpinten.entity.Comentario;

public interface ComentarioDao {
	public Comentario addComentario(Comentario comentario);
	public Comentario updateComentario(Comentario comentario);
	public void deleteComentario(int comentarioId);
	public Comentario getComentario(int comentarioId);
	public List<Comentario> getComentarios();
}
