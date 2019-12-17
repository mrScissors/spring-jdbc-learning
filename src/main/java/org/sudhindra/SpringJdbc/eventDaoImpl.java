package org.sudhindra.SpringJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class eventDaoImpl implements eventDao {
    private JdbcTemplate jdbcTemplate;
    public eventDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(event event) {
        if (event.getId() > 0) {
            // update
            String sql = "UPDATE eventsList SET eventTitle=?, city=?, ticketPrice=?, eventType=?,  WHERE id=?";
            jdbcTemplate.update(sql, event.getEventTitle(), event.getCity(),
                    event.getTicketPrice(), event.getEventType(), event.getId());
        } else {
            // insert
            String sql = "INSERT INTO eventsList (eventTitle, city, ticketPrice, eventType)"
                    + " VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, event.getEventTitle(), event.getCity(),
                    event.getTicketPrice(), event.getEventType());
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM eventsList WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<event> list() {
        String sql = "SELECT * FROM eventsList";
        List<event> listEvent = jdbcTemplate.query(sql, new RowMapper<event>() {

            @Override
            public event mapRow(ResultSet rs, int rowNum) throws SQLException {
                event aEvent = new event();
                aEvent.setId(rs.getInt("id"));
                aEvent.setEventTitle(rs.getString("eventTitle"));
                aEvent.setCity(rs.getString("city"));
                aEvent.setTicketPrice(rs.getInt("ticketPrice"));
                aEvent.setEventType(rs.getString("eventType"));

                return aEvent;
            }

        });

        return listEvent;
    }

    @Override
    public event get(int id) {
        String sql = "SELECT * FROM eventsList WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<event>() {

            @Override
            public event extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    event aEvent = new event();
                    aEvent.setEventTitle(rs.getString("eventTitle"));
                    aEvent.setCity(rs.getString("city"));
                    aEvent.setTicketPrice(rs.getInt("ticketPrice"));
                    aEvent.setEventType(rs.getString("evenType"));
                    return aEvent;
                }

                return null;
            }

        });
    }
}
