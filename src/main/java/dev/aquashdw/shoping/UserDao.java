package dev.aquashdw.shoping;

import dev.aquashdw.shoping.entity.UserEntity;
import dev.aquashdw.shoping.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class UserDao {
    private static Logger logger = LoggerFactory.getLogger(UserDao.class);

    private final UserRepository userRepository;

    public UserDao(
            @Autowired UserRepository userRepository
    ){
        this.userRepository = userRepository;
    }

    public void createUser(UserDto dto){
        UserEntity userEntity = new UserEntity();
        userEntity.setTitle(dto.getTitle());
        userEntity.setContent(dto.getContent());
        userEntity.setWriter(dto.getWriter());
        userEntity.getBoardEntity(null);
        this.userRepository.save(userEntity);
    }

    public UserEntity readUser(int id){
        Optional<UserEntity> userEntity = this.userRepository.findById((long) id);
        if(userEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        return userEntity.get();
    }
    public Iterator<UserEntity> readUserAll(){
        return this.userRepository.findAll().iterator();

    }
    public void updateUser(int id, UserDto dto){
        Optional<UserEntity> targetEntity = this.userRepository.findById(Long.valueOf(id));
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        UserEntity userEntity = targetEntity.get();
        userEntity.setTitle(dto.getTitle() == null ? userEntity.getTitle() : dto.getTitle());
        userEntity.setContent(dto.getContent() == null ? userEntity.getContent() : dto.getContent());
        userEntity.setWriter(dto.getWriter() == null ? userEntity.getWriter() : dto.getWriter());
        this.userRepository.save(userEntity);
    }

    public void deleteUser(int id){
        Optional<UserEntity> targetEntity = this.userRepository.findById((long) id);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.userRepository.delete(targetEntity.get());
    }



}
