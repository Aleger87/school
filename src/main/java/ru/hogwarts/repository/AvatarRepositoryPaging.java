package ru.hogwarts.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.model.Avatar;

@Repository
public interface AvatarRepositoryPaging extends PagingAndSortingRepository<Avatar, Integer> {
}
