package movie.collection.service;

import movie.collection.entity.Role;
import movie.collection.exception.NoSuchDataException;
import movie.collection.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository repository;

    private final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public List<Role> getAll() {
        return repository.findAll();
    }

    @Override
    public Role get(int id) {
        return repository.findById(id).orElseThrow(()->new NoSuchDataException("There is no role with id="+id));
    }

    @Override
    public Role save(Role role) {
        logger.info("Saving role = {}", role);
        return repository.save(role);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
