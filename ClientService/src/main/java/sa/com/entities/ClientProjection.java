package sa.com.entities;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = Client.class)
public interface ClientProjection {
    public Long getId();
    public String getName();
}
