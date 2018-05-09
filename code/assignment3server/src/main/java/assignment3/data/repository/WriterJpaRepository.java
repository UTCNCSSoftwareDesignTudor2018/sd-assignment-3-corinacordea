package assignment3.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import assignment3.data.entity.Writer;

public interface WriterJpaRepository extends JpaRepository<Writer,Integer>{
	public Writer findByWriterUsernameAndWriterPassword(String username, String password);

	public Writer findByWriterId(Integer writerId);
}
