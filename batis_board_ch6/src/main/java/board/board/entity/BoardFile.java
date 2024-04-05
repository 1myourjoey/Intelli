package board.board.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_file")
public class BoardFile {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idx;
	
	private int boardIdx;
	
	private String originalFileName;
	
	private String storedFilePath;
	
	private long fileSize;

	private String creatorId;

	private String createdDatetime;

	private String updaterId;

	private String updatedDatetime;

	@Column(columnDefinition = "varchar(2) default 'N'")
	private String deletedYn;
}
