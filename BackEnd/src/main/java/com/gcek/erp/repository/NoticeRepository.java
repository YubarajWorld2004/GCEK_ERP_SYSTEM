package com.gcek.erp.repository;

import com.gcek.erp.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findByActiveTrue();
    List<Notice> findByDepartmentAndActiveTrue(String department);
    List<Notice> findByCategoryAndActiveTrue(String category);
    List<Notice> findByPublishDateAfter(LocalDate date);
}