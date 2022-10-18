package com.usa.misiontic.retos.repositorio.crudRepositorio;

import java.util.Date;
import java.util.List;
import com.usa.misiontic.retos.entities.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservaCrudRepositorio extends CrudRepository<Reserva, Integer> {

    public List<Reserva> findAllByStatus(String status);

    public List<Reserva> findAllByStartDateAfterAndStartDateBefore(Date datoUno, Date datodos);

    //@Query("SELECT c.client, COUNT(c.client) from reservation AS c group by c.client order by COUNT(c.client) DESC")
//SELECT c.client_id, COUNT(c.client_id) from reservation AS c group by c.client_id order by COUNT(c.client_id) DESC
   // @Query("SELECT c.client, COUNT(c.client) from reservation AS c group by c.client order by COUNT(c.client) DESC")
  //  public List<Object[]> countTotalReservationByClient();


}
