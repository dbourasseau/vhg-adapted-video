package fr.labri.progess.comet.proxy;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import fr.labri.progess.comet.model.Content;

public class CacheService {

	final Client client = ClientBuilder.newClient();
	private String url;
	private Integer port;

	public CacheService(String url, Integer port) {
		this.url = url;
		this.port = port;
	}

	void askForCache(String uri) {

		WebTarget target = client.target("http://" + url + ":" + this.port)
				.path("api").path("content");
		Content content = new Content();
		content.setUri(uri);
		target.request().async()
				.post(Entity.entity(content, MediaType.APPLICATION_XML));
	}

}
