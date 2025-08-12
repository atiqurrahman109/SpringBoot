package com.emranhss.project.repository;

import com.emranhss.project.entity.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobSeekerRepo extends JpaRepository<JobSeeker, Long> {
    Optional<JobSeeker> findByUserId(int userId);
<<<<<<< HEAD

    @Query("SELECT js FROM JobSeeker js WHERE js.user.email = :email")
    Optional<JobSeeker> findByUserEmail(@Param("email") String email);

    @Query("SELECT j FROM JobSeeker j LEFT JOIN FETCH j.educations WHERE j.id = :id")
    Optional<JobSeeker> findByIdWithEducations(@Param("id") Long id);
=======
>>>>>>> 0e3f204ff0631cca9428023e610dc5f1a7106550
}
