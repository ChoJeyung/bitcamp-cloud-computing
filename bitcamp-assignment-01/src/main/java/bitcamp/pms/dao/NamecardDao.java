package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.pms.domain.Namecard;

public interface NamecardDao {
    List<Namecard> selectList(Map<String,Object> params);
    Namecard selectOne(String name);
    int update(Namecard namecard);
    int delete(String name);
    int insert(Namecard namecard);
    int countAll();
}



