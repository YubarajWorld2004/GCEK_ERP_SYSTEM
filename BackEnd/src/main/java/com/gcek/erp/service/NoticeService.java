package com.gcek.erp.service;

import com.gcek.erp.entity.Notice;
import com.gcek.erp.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public Notice createNotice(Notice notice) {
        notice.setPublishDate(LocalDate.now());
        notice.setActive(true);
        return noticeRepository.save(notice);
    }

    public List<Notice> getAllActiveNotices() {
        return noticeRepository.findByActiveTrue();
    }

    public List<Notice> getNoticesByDepartment(String department) {
        return noticeRepository.findByDepartmentAndActiveTrue(department);
    }
}
