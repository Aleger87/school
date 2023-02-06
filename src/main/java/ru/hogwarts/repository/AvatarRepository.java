package ru.hogwarts.repository;

import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.model.Avatar;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Optional<Avatar> findByStudentIdStudent(Long studentId);

}
