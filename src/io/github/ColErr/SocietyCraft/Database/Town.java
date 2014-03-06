package io.github.ColErr.SocietyCraft.Database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.avaje.ebean.validation.NotEmpty;

@Entity()
@Table(name="SocCft_town")
public class Town {
	@Id
	private int id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String mayorname;
}
