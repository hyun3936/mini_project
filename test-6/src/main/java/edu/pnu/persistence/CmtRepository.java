package edu.pnu.persistence;



import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Comment;

public interface CmtRepository extends JpaRepository<Comment, Integer >{



}
