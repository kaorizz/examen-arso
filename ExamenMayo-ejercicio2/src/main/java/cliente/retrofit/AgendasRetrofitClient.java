package cliente.retrofit;

import cliente.dto.AgendaDTO;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AgendasRetrofitClient {

	@POST("agendas")
	Call<Void> crearAgenda();

	@GET("agendas/{id}")
	Call<AgendaDTO> recuperarAgenda(@Path("id") String id);

	@POST("agendas/{id}/citas")
	Call<Void> añadirCita(@Path("id") String id, @Query("descripion") String descripcion,
			@Query("inicio") String inicio, @Query("duracion") String duracion);

	@DELETE("agendas/{id}")
	Call<Void> eliminarAgenda(@Path("id") String id);
}
