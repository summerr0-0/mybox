package com.numble.mybox.folder.infra.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import static com.numble.mybox.folder.entity.QFolder.folder;

@Repository
public class FolderRepositoryImpl implements FolderRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public FolderRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public boolean existsByIdAndName(Long userId, String name, Long parentId) {
        Integer fetchOne = queryFactory
            .selectOne()
            .from(folder)
            .where(
                folder.userId.eq(userId),
                folder.name.eq(name),
                folder.parentId.eq(parentId))
            .fetchFirst();
        return fetchOne != null;
    }
}