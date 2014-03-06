package io.github.ColErr.SocietyCraft.Database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.avaje.ebean.validation.NotNull;
import com.avaje.ebean.validation.NotEmpty;

@Entity()
@Table(name="SocCft_town")
public class Chunk {
	@Id
	private int id;
	
	@NotNull
	private int x;
	
	@NotNull
	private int y;
	
	@NotEmpty
	private String worldname;
	
	@NotNull
	private int townid;
}
