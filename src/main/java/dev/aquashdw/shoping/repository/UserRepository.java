package dev.aquashdw.shoping.repository;

import dev.aquashdw.shoping.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
//    List<PostEntity> findAllByWriter(String writer);
//    List<PostEntity> findAllByWriterAAndBoardEntity(String writer, BoardEntity boardEntity);
//    List<PostEntity> findAllByContaining(String writer);
}
