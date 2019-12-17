package org.sudhindra.SpringJdbc;
import java.util.List;

public interface eventDao {
    public void saveOrUpdate(event event);
    public void delete(int eventId);
    public event get(int eventId);
    public List<event> list();
}
